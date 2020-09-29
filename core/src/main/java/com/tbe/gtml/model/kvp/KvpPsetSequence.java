package com.tbe.gtml.model.kvp;

import lombok.Builder;
import lombok.Data;
import org.apache.camel.dataformat.bindy.annotation.KeyValuePairField;
import org.apache.camel.dataformat.bindy.annotation.Message;

@Data
@Builder
@Message(pairSeparator = "\\u0001",keyValuePairSeparator = "=",type="FIX",version = "4.4",isOrdered = true)
public class KvpPsetSequence {

    @KeyValuePairField(tag = 782)
    private String settlPartyId;

    @KeyValuePairField(tag = 783)
    private String settlPartyIdSource;

    @KeyValuePairField(tag = 784)
    private String settlPartyRole;


}
