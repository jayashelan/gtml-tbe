package com.tbe.gtml.model.fixedlength;

import lombok.Data;
import org.apache.camel.dataformat.bindy.annotation.FixedLengthRecord;
import org.apache.camel.dataformat.bindy.annotation.Link;

@Data
@FixedLengthRecord(length = 100,paddingChar = ' ')
public class FixedLengthTrade {

    @Link
    private FixedLengthHeader header;


}
