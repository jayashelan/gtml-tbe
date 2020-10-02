package com.tbe.gtml.parsers.serde;

import com.tbe.gtml.parsers.bindy.XmlDataFormat;
import com.tbe.gtml.parsers.serialization.SerDe;
import com.tbe.gtml.parsers.serialization.SerDeException;
import com.tbe.gtml.model.xml.XmlTrade;

import java.util.*;

public class XmlSerDe implements SerDe<XmlTrade> {

    private final XmlDataFormat<XmlTrade> dataFormat;

    public XmlSerDe(XmlDataFormat<XmlTrade> dataFormat) {
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
