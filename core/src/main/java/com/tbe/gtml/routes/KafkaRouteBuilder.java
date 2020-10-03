package com.tbe.gtml.routes;

import com.tbe.gtml.components.KafkaConfigBuilder;
import com.tbe.gtml.processor.KafkaProcessor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.apache.camel.builder.PredicateBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaConstants;
import org.apache.camel.component.kafka.KafkaManualCommit;
import org.apache.camel.throttling.ThrottlingExceptionRoutePolicy;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Slf4j
public class KafkaRouteBuilder extends RouteBuilder {


    @Inject
    private KafkaProcessor kafkaProcessor;

    @Inject
    KafkaConfigBuilder config;

    /**
     * Defines a Kafka Route with a ThrottlingExceptionRoutePolicy
     */
    @Override
    public void configure() throws Exception {
        log.info("configure(KafkaRouteBuilder");

        if (config.getConfigs().kafka.topic != null
                && config.getCamelKafkaOptions() != null
                && !config.getCamelKafkaOptions().isEmpty()) {


            from(config.getKafkaURL())
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
        return PredicateBuilder.constant("true".equalsIgnoreCase(config.getCamelKafkaOptions().get("allowManualCommit")));
    }

    /**
     * Defines a throttling route policy, The circuit is opened after 60secs
     * Performs a health check if the server is available.
     * Circuit is closed if the health check succeeds, otherwise retry after 60secs.
     *
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
                log.info("Triggering manual commit");
                kafkaManualCommit.commitSync();
            }
        }
    }
}