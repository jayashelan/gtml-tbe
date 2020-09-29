package com.tbe.gtml.serde;

import com.tbe.gtml.model.kvp.*;
import com.tbe.gtml.parsers.bindy.KvpDataFormat;
import com.tbe.gtml.parsers.serialization.SerDe;
import com.tbe.gtml.parsers.serialization.SerDeException;
import com.tbe.gtml.util.LambdaUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class KvpSerDe implements SerDe<KvpTrade> {

    private final KvpDataFormat<KvpTrade> dataFormat;

    public KvpSerDe(KvpDataFormat<KvpTrade> dataFormat) {
        this.dataFormat = dataFormat;
    }

    @Override
    public KvpTrade fromBytes(byte[] bytes) throws SerDeException {
        return this.dataFormat.fromBytes(bytes);
    }

    @Override
    public byte[] toBytes(KvpTrade object) throws SerDeException {

        List<Map<String, Object>> models = new ArrayList<>();

        //add KvpHeader
        models.add(Map.of(KvpHeader.class.getName(), object.getHeader()));

        //KvpBargainCondition  - one to many
        LambdaUtils.collectionAsStream(object.getBargainConditions()).forEach(kvpBargainCondition -> {
            models.add(Map.of(KvpBargainCondition.class.getName(), kvpBargainCondition));
        });

        //  KvpNoOfFees
        models.add(Map.of(KvpNoOfFees.class.getName(), object.getNoOfFees()));

        // KvpMiscFee - one to many
        LambdaUtils.collectionAsStream(object.getMiscFees()).forEach(kvpMiscFee -> {
            models.add(Map.of(KvpMiscFee.class.getName(), kvpMiscFee));
        });
        //KvpNoOfAccts
        models.add(Map.of(KvpNoOfAccts.class.getName(), object.getNoOfAccts()));

        //KvpAltAcct - one to many
        LambdaUtils.collectionAsStream(object.getAltAccts()).forEach(kvpAltAcct -> {
            models.add(Map.of(KvpAltAcct.class.getName(), kvpAltAcct));
        });
        return dataFormat.toBytes(models);
    }
}
