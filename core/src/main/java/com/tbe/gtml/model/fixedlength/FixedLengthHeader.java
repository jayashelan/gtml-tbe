package com.tbe.gtml.model.fixedlength;

import lombok.Data;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.FixedLengthRecord;

import java.util.Date;

@Data
@FixedLengthRecord(length = 10,paddingChar = ' ')
public class FixedLengthHeader {
    @DataField(pos = 1,length = 2)
    private String dataId;

    @DataField(pos = 3,length = 8,pattern = "yyyyMMdd")
    private Date currentDate;
}
