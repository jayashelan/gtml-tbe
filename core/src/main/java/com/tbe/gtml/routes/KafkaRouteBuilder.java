package com.tbe.gtml.routes;


import com.tbe.gtml.components.KafkaConfig;
import com.tbe.gtml.components.KafkaConfigs;
import com.tbe.gtml.processor.KafkaProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.apache.camel.builder.PredicateBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaConstants;
import org.apache.camel.component.kafka.KafkaManualCommit;
import org.apache.camel.throttling.ThrottlingExceptionRoutePolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class KafkaRouteBuilder extends RouteBuilder {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Inject
	private KafkaProcessor kafkaProcessor;

	@Inject
	private KafkaConfig kafkaConfig;

	/**
	 * Defines a Kafka Route with a ThrottlingExceptionRoutePolicy
	 */
	@Override
	public void configure() throws Exception {
		logger.info("configure():start");

		if (kafkaConfig.getConfigs().getTopic() != null
				&& kafkaConfig.getCamelKafkaOptions() != null
				&& !kafkaConfig.getCamelKafkaOptions().isEmpty()) {

			System.out.println(kafkaConfig.getKafkaURL());

			from(kafkaConfig.getKafkaURL())
				.routePolicy(getThrottlingExceptionRoutePolicy())
				.process(kafkaProcessor)
				.choice()
					.when(getManualCommitPredicate())
						.process(this::doManualCommit)
					.otherwise()
						.end();
		}
	}

	private Predicate getManualCommitPredicate() {
		return PredicateBuilder.constant("true".equalsIgnoreCase(kafkaConfig.getCamelKafkaOptions().get("allowManualCommit")));
	}
	
	/**
	 * Defines a throttling route policy, The circuit is opened after 60secs
	 * Performs a health check if the server is available.
	 * Circuit is closed if the health check succeeds, otherwise retry after 60secs.
	 * @return
	 */
	private ThrottlingExceptionRoutePolicy getThrottlingExceptionRoutePolicy() {

		ThrottlingExceptionRoutePolicy routePolicy = new ThrottlingExceptionRoutePolicy(1, 30000, 60000, null);
		return routePolicy;
	}
	
	/**
	 * Performs a manual commit by checking if last in offset in the batch
	 * 
	 * @param exchange
	 */
	private void doManualCommit(Exchange exchange) {
		Boolean lastRecordOfBatch = exchange.getIn().getHeader(KafkaConstants.LAST_RECORD_BEFORE_COMMIT, Boolean.class);
		if (lastRecordOfBatch != null && lastRecordOfBatch) {
			KafkaManualCommit kafkaManualCommit = exchange.getIn().getHeader(KafkaConstants.MANUAL_COMMIT,
					KafkaManualCommit.class);
			if (kafkaManualCommit != null) {
				logger.info("Triggering manual commit");
				kafkaManualCommit.commitSync();
			}
		}
	}
}