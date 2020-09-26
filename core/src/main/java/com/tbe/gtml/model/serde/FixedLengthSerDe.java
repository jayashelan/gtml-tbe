package com.tbe.gtml.model.serde;

import com.tbe.gtml.common.parsers.bindy.FixedLengthDataFormat;
import com.tbe.gtml.common.parsers.serialization.SerDe;
import com.tbe.gtml.common.parsers.serialization.SerDeException;
import com.tbe.gtml.model.fixedlength.FixedLengthHeader;
import com.tbe.gtml.model.fixedlength.FixedLengthPojo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FixedLengthSerDe implements SerDe<com.tbe.gtml.model.fixedlength.FixedLengthPojo> {

    private final FixedLengthDataFormat<FixedLengthPojo> dataFormat;

    public FixedLengthSerDe(FixedLengthDataFormat<FixedLengthPojo> dataFormat) {
        this.dataFormat = dataFormat;
    }

    @Override
    public FixedLengthPojo fromBytes(byte[] bytes) throws SerDeException {
        return this.dataFormat.fromBytes(bytes);
    }

    @Override
    public byte[] toBytes(FixedLengthPojo object) throws SerDeException {

        List<Map<String,Object>> models = new ArrayList<>();
        Map<String,Object> model = new HashMap<>();
        model.put(FixedLengthHeader.class.getName(),object.getHeader());
        models.add(model);

        model = new HashMap<>();
        model.put(FixedLengthPojo.class.getName(),object);

        return this.dataFormat.toBytes(models);

    }


}
