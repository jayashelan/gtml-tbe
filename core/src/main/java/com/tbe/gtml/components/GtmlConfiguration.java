package com.tbe.gtml.components;

import io.quarkus.arc.config.ConfigProperties;
import lombok.ToString;

@ToString
@ConfigProperties(prefix = "gtml")
public class GtmlConfiguration {

    public KafkaConfig kafka;

    @ToString
    public static class KafkaConfig {

        public String topic;
        public String errorTopic;
        public OptionConfig option;

        public static class OptionConfig{
            public String allowManualCommit;
            public String autoOffsetReset;
            public String autoCommitEnable;
            public String breakOnFirstError;
            public String brokers;
            public String consumersCount;
            public String groupId;
            public String metadataMaxAgeMs;
        }


    }

}
