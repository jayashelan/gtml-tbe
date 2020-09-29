package com.tbe.gtml.model.kvp;

import lombok.Builder;
import lombok.Data;
import org.apache.camel.dataformat.bindy.annotation.KeyValuePairField;
import org.apache.camel.dataformat.bindy.annotation.Message;

@Data
@Builder
@Message(pairSeparator = "\\u0001",keyValuePairSeparator = "=",type="FIX",version = "4.4")
public class KvpBargainCondition {

    @KeyValuePairField(tag = 11303)
    private String bargainCondition;

}
