package com.tbe.gtml.model.fixedlength;

import lombok.Data;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.FixedLengthRecord;

import java.util.Date;

@Data
@FixedLengthRecord(length = 150,paddingChar = ' ')
public class FixedLengthHeader {

    @DataField(pos = 1,length = 4)
    private String dataId;

    @DataField(pos = 5,length = 8)
    private String fillerAt5;

    @DataField(pos = 13,length = 8,pattern = "yyyyMMdd")
    private Date currentDate;

    @DataField(pos = 21,length = 6,pattern = "yyyyMMdd")
    private Date currentTime;

    @DataField(pos = 27,length = 1)
    private String environment;

    @DataField(pos = 28,length = 3)
    private String hdrClientNumber;

    @DataField(pos = 31,length = 1)
    private String action;

    @DataField(pos = 32,length = 14,align = "L")
    private String referenceId;

    @DataField(pos = 46,length = 8,pattern = "yyyyMMdd")
    private Date origTransmissionDate;

    @DataField(pos = 54,length = 2)
    private String tradeType;

    @DataField(pos = 56,length = 1)
    private String responseReqInd;

    @DataField(pos = 57,length = 21)
    private String fillerAt57;

    @DataField(pos = 78,length = 3)
    private String layoutVersion;

    @DataField(pos = 81,length = 70)
    private String fillerAt81;



}
