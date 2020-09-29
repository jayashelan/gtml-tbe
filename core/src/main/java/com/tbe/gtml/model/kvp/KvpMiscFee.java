package com.tbe.gtml.model.kvp;

import lombok.Builder;
import lombok.Data;
import org.apache.camel.dataformat.bindy.annotation.KeyValuePairField;
import org.apache.camel.dataformat.bindy.annotation.Message;

@Data
@Builder
@Message(pairSeparator = "\\u0001",keyValuePairSeparator = "=",type="FIX",version = "4.4",isOrdered = true)
public class KvpMiscFee {

    @KeyValuePairField(tag = 137)
    private String miscFeeAmt;

    @KeyValuePairField(tag = 891)
    private String miscFeeBasis;

    @KeyValuePairField(tag = 139)
    private String type;

    @KeyValuePairField(tag = 138)
    private String miscFeeCurrency;

    @KeyValuePairField(tag = 10130)
    private String miscFeeDesc;

    @KeyValuePairField(tag = 10160)
    private String miscFeeOverride;

    @KeyValuePairField(tag = 10714)
    private String miscFeeScope;


}
