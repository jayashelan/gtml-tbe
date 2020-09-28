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

    private String fillerAt5;

    @DataField(pos = 3,length = 8,pattern = "yyyyMMdd")
    private Date currentDate;

    private Date currentTime;

    private String environment;

    private String hdrClientNumber;

    private String action;

    private String referenceId;

    private Date origTransmissionDate;

    private String tradeType;

    private String responseReqInd;

    private String fillerAt57;

    private String layoutVersion;

    private String fillerAt81;



}
