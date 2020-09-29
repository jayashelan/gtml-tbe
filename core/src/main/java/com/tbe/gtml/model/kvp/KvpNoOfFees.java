package com.tbe.gtml.model.kvp;

import lombok.Builder;
import lombok.Data;
import org.apache.camel.dataformat.bindy.annotation.KeyValuePairField;
import org.apache.camel.dataformat.bindy.annotation.Message;

@Data
@Builder
@Message(pairSeparator = "\\u0001",keyValuePairSeparator = "=",type="FIX",version = "4.4",isOrdered = true)
public class KvpNoOfFees {

    @KeyValuePairField(tag = 136)
    private String numOfMiscFees;

}
