package com.tbe.gtml.model.kvp;

import lombok.Builder;
import lombok.Data;
import org.apache.camel.dataformat.bindy.annotation.KeyValuePairField;
import org.apache.camel.dataformat.bindy.annotation.Message;
import org.apache.camel.dataformat.bindy.annotation.Section;

@Data
@Builder
@Section(number = 1)
@Message(pairSeparator = "\\u0001",keyValuePairSeparator = "=",type="FIX",version = "5.0",isOrdered = true)
public class KvpHeader {

    @KeyValuePairField(tag =8)
    private String beginString;

    @KeyValuePairField(tag = 9)
    private String bodyLength;

    @KeyValuePairField(tag = 35)
    private String msgType;

    @KeyValuePairField(tag = 49)
    private String senderCompID;

    @KeyValuePairField(tag = 56)
    private String targetCompId;

    @KeyValuePairField(tag = 142)
    private String senderLocationId;

    @KeyValuePairField(tag = 143)
    private String targetLocationId;

    @KeyValuePairField(tag = 43)
    private String possDupFlag;

    @KeyValuePairField(tag = 97)
    private String possResend;

    @KeyValuePairField(tag = 52)
    private String sendingTime;



}
