package com.tbe.gtml.model.serde;

import com.tbe.gtml.common.parsers.bindy.FixedLengthDataFormat;
import com.tbe.gtml.common.parsers.serialization.SerDe;
import com.tbe.gtml.common.parsers.serialization.SerDeException;
import com.tbe.gtml.model.fixedlength.FixedLengthHeader;
import com.tbe.gtml.model.fixedlength.FixedLengthTrade;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FixedLengthSerDe implements SerDe<FixedLengthTrade> {

    private final FixedLengthDataFormat<FixedLengthTrade> dataFormat;

    public FixedLengthSerDe(FixedLengthDataFormat<FixedLengthTrade> dataFormat) {
        this.dataFormat = dataFormat;
    }

    @Override
    public FixedLengthTrade fromBytes(byte[] bytes) throws SerDeException {
        return this.dataFormat.fromBytes(bytes);
    }

    @Override
    public byte[] toBytes(FixedLengthTrade object) throws SerDeException {

        List<Map<String,Object>> models = new ArrayList<>();
        Map<String,Object> model = new HashMap<>();
        model.put(FixedLengthHeader.class.getName(),object.getHeader());
        models.add(model);

        model = new HashMap<>();
        model.put(FixedLengthTrade.class.getName(),object);

        return this.dataFormat.toBytes(models);

    }


}
