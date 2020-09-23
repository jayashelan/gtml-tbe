package com.tbe.gtml.components;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.arc.config.ConfigProperties;

@ConfigProperties(prefix = "kafka")
public class KafkaConfigs {

    @JsonIgnore
    private String topic;
    @JsonIgnore
    private String errorTopic;

    private String brokers;
    private String groupId;
    private String consumersCount;
    private String autoOffsetReset;
    private String breakOnFirstError;
    private String autoCommitEnable;
    private String allowManualCommit;
    private String metadataMaxAgeMs;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getErrorTopic() {
        return errorTopic;
    }

    public void setErrorTopic(String errorTopic) {
        this.errorTopic = errorTopic;
    }

    public String getBrokers() {
        return brokers;
    }

    public void setBrokers(String brokers) {
        this.brokers = brokers;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getConsumersCount() {
        return consumersCount;
    }

    public void setConsumersCount(String consumersCount) {
        this.consumersCount = consumersCount;
    }

    public String getAutoOffsetReset() {
        return autoOffsetReset;
    }

    public void setAutoOffsetReset(String autoOffsetReset) {
        this.autoOffsetReset = autoOffsetReset;
    }

    public String getBreakOnFirstError() {
        return breakOnFirstError;
    }

    public void setBreakOnFirstError(String breakOnFirstError) {
        this.breakOnFirstError = breakOnFirstError;
    }

    public String getAutoCommitEnable() {
        return autoCommitEnable;
    }

    public void setAutoCommitEnable(String autoCommitEnable) {
        this.autoCommitEnable = autoCommitEnable;
    }

    public String getAllowManualCommit() {
        return allowManualCommit;
    }

    public void setAllowManualCommit(String allowManualCommit) {
        this.allowManualCommit = allowManualCommit;
    }

    public String getMetadataMaxAgeMs() {
        return metadataMaxAgeMs;
    }

    public void setMetadataMaxAgeMs(String metadataMaxAgeMs) {
        this.metadataMaxAgeMs = metadataMaxAgeMs;
    }


}
