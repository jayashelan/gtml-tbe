package com.tbe.gtml.components;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tbe.gtml.constants.Constants;
import org.apache.commons.lang3.StringUtils;



import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;


@ApplicationScoped
public class KafkaConfig {

	@Inject
	KafkaConfigs configs;

	private String kafkaURL = "";

	private String kafkaErrorTopicURL = "";

	private Map<String, String> camelKafkaOptions = new HashMap<>();

	public KafkaConfigs getConfigs() {
		return configs;
	}

	public void setConfigs(KafkaConfigs configs) {
		this.configs = configs;
	}

	public String getKafkaURL() {
		return kafkaURL;
	}

	public void setKafkaURL(String kafkaURL) {
		this.kafkaURL = kafkaURL;
	}

	public String getKafkaErrorTopicURL() {
		return kafkaErrorTopicURL;
	}

	public void setKafkaErrorTopicURL(String kafkaErrorTopicURL) {
		this.kafkaErrorTopicURL = kafkaErrorTopicURL;
	}

	public Map<String, String> getCamelKafkaOptions() {
		return camelKafkaOptions;
	}

	public void setCamelKafkaOptions(Map<String, String> camelKafkaOptions) {
		this.camelKafkaOptions = camelKafkaOptions;
	}

	public Map<String, String> convert() {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.convertValue(configs, new TypeReference<Map<String, String>>() {});


	}

	/**
	 * Forms the kafka url based on the configuration
	 */
	@PostConstruct
	public void constructKafkaURL() {
		setCamelKafkaOptions(convert());
		System.out.println(convert());
		setKafkaURL(getKafkaTopicURL(configs.getTopic()));
		setKafkaErrorTopicURL(getKafkaTopicURL(configs.getErrorTopic()));




	}

	private String getKafkaTopicURL(String topicName) {
		StringBuilder urlBuilder = new StringBuilder("kafka:" + topicName);
		
        if (!getCamelKafkaOptions().isEmpty()) {
        	urlBuilder.append(Constants.URL_QUERY_PARAM);
			getCamelKafkaOptions().forEach(
        		(key, value) -> {
	                if (StringUtils.isNotBlank(value)) {
	                	appendConfig(urlBuilder, key, value);
	                }
	            }
            );
        }
		System.out.println(urlBuilder.toString());

        return stripEnd(urlBuilder.toString());
	}

	private void appendConfig(StringBuilder urlBuilder, String key, String value) {
		urlBuilder.append(key).append(Constants.KEY_VALUE_SEPARATOR).append(value).append(Constants.URL_QUERY_PARAMS_DELIMITER);
	}
	
	private String stripEnd(String url) {
		return StringUtils.stripEnd(StringUtils.stripEnd(url, Constants.URL_QUERY_PARAMS_DELIMITER), Constants.URL_QUERY_PARAM);
	}
	




}