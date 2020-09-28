package com.tbe.gtml.model.serde;

import com.google.common.collect.ImmutableMap;
import com.tbe.gtml.common.parsers.bindy.XmlDataFormat;
import com.tbe.gtml.common.parsers.serialization.SerDe;
import com.tbe.gtml.common.parsers.serialization.SerDeException;
import com.tbe.gtml.model.xml.XmlTrade;
import com.tbe.gtml.model.xml.XmlTradeAlternateId;
import com.tbe.gtml.util.LambdaUtils;

import java.util.*;
import java.util.concurrent.Phaser;

public class XmlSerde implements SerDe<XmlTrade> {

    private final XmlDataFormat<XmlTrade> dataFormat;

    public XmlSerde(XmlDataFormat<XmlTrade> dataFormat) {
        this.dataFormat = dataFormat;
    }

    @Override
    public XmlTrade fromBytes(byte[] bytes) throws SerDeException {
        return this.dataFormat.fromBytes(bytes);
    }

    @Override
    public byte[] toBytes(XmlTrade trade) throws SerDeException {
        byte[] message = null;
        List<Map<String,Object>> models = new ArrayList<>();

        return this.dataFormat.toBytes(trade);
    }
}
