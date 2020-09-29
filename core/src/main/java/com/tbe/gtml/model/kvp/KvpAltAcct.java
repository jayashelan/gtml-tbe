package com.tbe.gtml.model.kvp;

import lombok.Builder;
import lombok.Data;
import org.apache.camel.dataformat.bindy.annotation.KeyValuePairField;
import org.apache.camel.dataformat.bindy.annotation.Message;

@Data
@Builder
@Message(pairSeparator = "\\u0001",keyValuePairSeparator = "=",type="FIX",version = "4.4")
public class KvpAltAcct {

    @KeyValuePairField(tag = 10698)
    private String parentAcctId;

    @KeyValuePairField(tag = 11435)
    private String parentAcctType;
}
