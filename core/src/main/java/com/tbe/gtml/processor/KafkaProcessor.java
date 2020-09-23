package com.tbe.gtml.processor;


import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.kafka.KafkaConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import java.util.Objects;

@ApplicationScoped
public class KafkaProcessor implements Processor {
	

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void process(Exchange exchange) throws Exception {
        if (exchange.getIn() != null) {
            Message message = exchange.getIn();
            Object data = message.getBody();

            logger.info("topicName={}, partitionId={}, messageKey={}, currentOffset={}, message={}", 
            		message.getHeader(KafkaConstants.TOPIC), 
            		message.getHeader(KafkaConstants.PARTITION), 
            		message.getHeader(KafkaConstants.KEY),
            		message.getHeader(KafkaConstants.OFFSET), data);            
            processEvent(data);            
        }
	}

	/**
	 * This method call the server to process the data, if the server is unavailable, throws a rest client exception.
	 * 
	 * @param data to process the event
	 * @return The HTTP Status

	 */
	public void processEvent(Object data){
		logger.info("Recieved :: {}", Objects.toString(data));
	
	}


}
