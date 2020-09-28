package com.tbe.gtml.model.fixedlength;

import lombok.Data;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.FixedLengthRecord;
import org.apache.camel.dataformat.bindy.annotation.Link;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import java.lang.reflect.Field;
import java.util.Date;

@Data
@FixedLengthRecord(length = 5450,paddingChar = ' ')
public class FixedLengthTrade {

    @Link
    private FixedLengthHeader header;

    @DataField(pos = 151,length = 2)
    private String baseSegmentId;

    @DataField(pos = 153,length = 14)
    private String fillerAt153;

    @DataField(pos = 167,length = 3)
    private String clientNumber;

    @DataField(pos = 170,length = 3)
    private String branchNumber;

    @DataField(pos = 173,length = 5)
    private String baseAccountNumber;

    @DataField(pos = 178,length = 1)
    private String accountType;

    @DataField(pos = 179,length = 1)
    private String checkDigit;

    @DataField(pos = 180,length = 3)
    private String accountCurrency;

    @DataField(pos = 183,length = 16)
    private String fillerAt183;

    @DataField(pos = 199,length = 1)
    private String transactionCategory;

    @DataField(pos = 200,length = 3)
    private String transactionType;

    @DataField(pos = 203,length = 1)
    private String whenIssueCode;

    @DataField(pos = 204,length = 2)
    private String side;

    @DataField(pos = 206,length = 8)
    private String settlementDate;

    @DataField(pos = 214,length = 8,pattern = "yyyyMMdd")
    private Date tradeDate;

    @DataField(pos = 222,length = 2)
    private String blotterCode;

    @DataField(pos = 224,length = 5)
    private String tagNumber;

    @DataField(pos = 229,length = 29)
    private String fillerAt229;

    @DataField(pos = 258,length = 1)
    private String optionIndicator;

    @DataField(pos = 259,length = 6)
    private String dnsOrderDate;

    @DataField(pos = 265,length = 33)
    private String fillerAt265;

    @DataField(pos = 298,length = 8)
    private String effectiveDate;

    @DataField(pos = 306,length = 14)
    private String fillerAt306;

    @DataField(pos = 320,length = 1)
    private String openCloseCode;

    @DataField(pos = 321,length = 5)
    private String fillerAt321;

    @DataField(pos = 326,length = 1)
    private String rebillCode;

    @DataField(pos = 327,length = 1)
    private String fillerAt327;

    @DataField(pos = 328,length = 1)
    private String rebillMatchCode;

    @DataField(pos = 329,length = 1)
    private String fillerAt329;

    @DataField(pos = 330,length = 1)
    private String wiCanExtensionCode;

    @DataField(pos = 331,length = 11)
    private String fillerAt331;

    @DataField(pos = 342,length = 17)
    private String quantity;

    @DataField(pos = 359,length = 13)
    private String fillerAt359;

    @DataField(pos = 372,length = 1)
    private String primaryPriceCode;

    @DataField(pos = 373,length = 1)
    private String dollarPriceFormat;

    @DataField(pos = 374,length = 16)
    private String dollarPrice;

    @DataField(pos = 390,length = 11)
    private String fillerAt390;

    @DataField(pos = 401,length = 3)
    private String priceCurrency;

    @DataField(pos = 404,length = 40)
    private String fillerAt404;

    @DataField(pos = 444,length = 1)
    private String securityIndentifierCode;

    @DataField(pos = 445,length = 15,align = "L")
    private String securityIdNumber;

    @DataField(pos = 460,length = 3)
    private String rrNumber;

    @DataField(pos = 463,length = 12)
    private String fillerAt463;

    @DataField(pos = 475,length = 1)
    private String solicationCode;

    @DataField(pos = 476,length = 24)
    private String fillerAt476;

    @DataField(pos = 500,length = 2)
    private String trailerCode1;

    @DataField(pos = 502,length = 2)
    private String trailerCode2;

    @DataField(pos = 504,length = 2)
    private String trailerCode3;

    @DataField(pos = 506,length = 2)
    private String trailerCode4;

    @DataField(pos = 508,length = 2)
    private String trailerCode5;

    @DataField(pos = 510,length = 20)
    private String fillerAt510;

    @DataField(pos = 530,length = 1)
    private String confirmCode;

    @DataField(pos = 531,length = 141)
    private String fillerAt531;

    @DataField(pos = 672,length = 8)
    private String userId;

    @DataField(pos = 680,length = 28)
    private String filler680;

    @DataField(pos = 708,length = 1)
    private String depositoryOverrideCode;

    @DataField(pos = 709,length = 9)
    private String depositoryOverrideValue;

    @DataField(pos = 718,length = 4)
    private String dtcNumber;

    @DataField(pos = 722,length = 5)
    private String agentBankNumber;

    @DataField(pos = 727,length = 12)
    private String CustomerNumber;

    @DataField(pos = 739,length = 5)
    private String intitutionId;

    @DataField(pos = 744,length = 96)
    private String fillerAt744;

    @DataField(pos = 840,length = 6)
    private String optionExpirationDate;

    @DataField(pos = 846,length = 81)
    private String fillerAt846;

    @DataField(pos = 927,length = 50)
    private String freeFormText;

    @DataField(pos = 977,length = 22)
    private String fillerAt977;

    @DataField(pos = 999,length = 2)
    private String baseSegmentDelimitor;

    @DataField(pos = 1001,length = 2)
    private String figurationSegmentId;

    @DataField(pos = 1003,length = 14)
    private String fillerAt1003;

    @DataField(pos = 1017,length = 3)
    private String netAmountIdCode;

    @DataField(pos = 1020,length = 17)
    private String netAmount;

    @DataField(pos = 1037,length = 3)
    private String netAmountCurrencyCode;

    @DataField(pos = 1040,length = 1)
    private String fillerAt1040;

    @DataField(pos = 1041,length = 3)
    private String principalIdCode;

    @DataField(pos = 1044,length = 17)
    private String principalAmount;

    @DataField(pos = 1061,length = 3)
    private String principalCurrencyCode;

    @DataField(pos = 1064,length = 97)
    private String filler1064;

    @DataField(pos = 1161,length = 3)
    private String interestCode;

    @DataField(pos = 1164,length = 17)
    private String interestAmount;

    @DataField(pos = 1181,length = 3)
    private String interestCurrencyCode;

    @DataField(pos = 1184,length = 1)
    private String interestAddSubtractCode;

    @DataField(pos = 1185,length = 1)
    private String fillerAt1185;

    @DataField(pos = 1186,length = 1)
    private String interestSupressionCode;

    @DataField(pos = 1187,length = 1)
    private String fillerAt1187;

    @DataField(pos = 1188,length = 3)
    private String commissionIdCode;

    @DataField(pos = 1191,length = 13)
    private String commissionAmount;

    @DataField(pos = 1204,length = 3)
    private String commissionCurrencyCode;

    @DataField(pos = 1207,length = 1)
    private String commissionAddSubtractCode;

    @DataField(pos = 1208,length = 1)
    private String fillerAt1208;

    @DataField(pos = 1209,length = 3)
    private String grossCreditIdCode;

    @DataField(pos = 1212,length = 13)
    private String grossCreditAmount;

    @DataField(pos = 1225,length = 3)
    private String grossCreditCurrencyCode;

    @DataField(pos = 1228,length = 22)
    private String fillerAt1228;

    @DataField(pos = 1250,length = 3)
    private String secFeeIdCode;

    @DataField(pos = 1253,length = 13)
    private String secFeeAmount;

    @DataField(pos = 1266,length = 3)
    private String secFecAmountCurrencyCode;

    @DataField(pos = 1269,length = 27)
    private String fillerAt1269;

    @DataField(pos = 1296,length = 3)
    private String nyTaxCode;

    @DataField(pos = 1299,length = 13)
    private String nyTaxAmt;

    @DataField(pos = 1312,length = 7)
    private String fillerAt1312;

    @DataField(pos = 1319,length = 3)
    private String gpfIdCode1;

    @DataField(pos = 1322,length = 13)
    private String gpfAmount1;

    @DataField(pos = 1335,length = 3)
    private String gpfCurrencyCode1;

    @DataField(pos = 1338,length = 1)
    private String gpfAddSubtractCode1;

    @DataField(pos = 1339,length = 1)
    private String fillerAt1339;

    @DataField(pos = 1340,length = 3)
    private String gpfIdCode2;

    @DataField(pos = 1343,length = 13)
    private String gpfAmount2;

    @DataField(pos = 1356,length = 3)
    private String gpfCurrencyCode2;

    @DataField(pos = 1359,length = 1)
    private String gpfAddSubtractCode2;

    @DataField(pos = 1360,length = 1)
    private String fillerAt1360;

    @DataField(pos = 1361,length = 3)
    private String gpfIdCode3;

    @DataField(pos = 1364,length = 13)
    private String gpfAmount3;

    @DataField(pos = 1377,length = 3)
    private String gpfCurrencyCode3;

    @DataField(pos = 1380,length = 1)
    private String gpfAddSubtractCode3;

    @DataField(pos = 1381,length = 1)
    private String fillerAt1381;

    @DataField(pos = 1382,length = 3)
    private String gpfIdCode4;

    @DataField(pos = 1385,length = 13)
    private String gpfAmount4;

    @DataField(pos = 1398,length = 3)
    private String gpfCurrencyCode4;

    @DataField(pos = 1401,length = 1)
    private String gpfAddSubtractCode4;

    @DataField(pos = 1402,length = 1)
    private String fillerAt1402;

    @DataField(pos = 1403,length = 3)
    private String gpfIdCode5;

    @DataField(pos = 1406,length = 13)
    private String gpfAmount5;

    @DataField(pos = 1419,length = 3)
    private String gpfCurrencyCode5;

    @DataField(pos = 1422,length = 1)
    private String gpfAddSubtractCode5;

    @DataField(pos = 1423,length = 276)
    private String fillerAt1423;

    @DataField(pos = 1699,length = 2)
    private String figurationSegDelimiter;

    @DataField(pos = 1701,length = 2)
    private String transactionSupSegId;

    @DataField(pos = 1703,length = 168)
    private String fillerAt1703;

    @DataField(pos = 1871,length = 1)
    private String optionOffsetCode;

    @DataField(pos = 1872,length = 173)
    private String fillerAt1872;

    @DataField(pos = 2045,length = 2)
    private String dtcIdMarketCode;

    @DataField(pos = 2047,length = 1)
    private String dtcIdRole;

    @DataField(pos = 2048,length = 11)
    private String fillerAt2048;

    @DataField(pos = 2059,length = 2)
    private String transactionSupSegDelimiter;

    @DataField(pos = 2061,length = 2)
    private String descriptionSegId;

    @DataField(pos = 2063,length = 14)
    private String fillerAt2063;

    @DataField(pos = 2077,length = 2)
    private String numSubSegments;

    @DataField(pos = 2079,length = 1)
    private String fillerAt2079;

    @DataField(pos = 2080,length = 1)
    private String descriptionClass1;

    @DataField(pos = 2081,length = 3)
    private String fillerAt2081;

    @DataField(pos = 2084,length = 30, align = "L")
    private String descriptionLine1;

    @DataField(pos = 2114,length = 6)
    private String fillerAt2114;

    @DataField(pos = 2120,length = 1)
    private String descriptionClass2;

    @DataField(pos = 2121,length = 3)
    private String fillerAt2121;

    @DataField(pos = 2124,length = 30,align = "L")
    private String descriptionLine2;

    @DataField(pos = 2154,length = 6)
    private String fillerAt2154;

    @DataField(pos = 2160,length = 1)
    private String descriptionClass3;

    @DataField(pos = 2161,length = 3)
    private String fillerAt2161;

    @DataField(pos = 2164,length = 30,align = "L")
    private String descriptionLine3;

    @DataField(pos = 2194,length = 6)
    private String fillerAt2194;

    @DataField(pos = 2200,length = 1)
    private String descriptionClass4;

    @DataField(pos = 2201,length = 3)
    private String fillerAt2201;

    @DataField(pos = 2204,length = 30, align = "L")
    private String descriptionLine4;

    @DataField(pos = 2234,length = 6)
    private String fillerAt2234;

    @DataField(pos = 2240,length = 1)
    private String descriptionClass5;

    @DataField(pos = 2241,length = 3)
    private String fillerAt2241;

    @DataField(pos = 2244,length = 30,align = "L")
    private String descriptionLine5;

    @DataField(pos = 2274,length = 6)
    private String fillerAt2274;

    @DataField(pos = 2280,length = 1)
    private String descriptionClass6;

    @DataField(pos = 2281,length = 3)
    private String fillerAt2281;

    @DataField(pos = 2284,length = 30,align = "L")
    private String descriptionLine6;

    @DataField(pos = 2314,length = 6)
    private String fillerAt2314;

    @DataField(pos = 2320,length = 1)
    private String descriptionClass7;

    @DataField(pos = 2321,length = 3)
    private String fillerAt2321;

    @DataField(pos = 2324,length = 30,align = "L")
    private String descriptionLine7;

    @DataField(pos = 2354,length = 6)
    private String fillerAt2354;

    @DataField(pos = 2360,length = 1)
    private String descriptionClass8;

    @DataField(pos = 2361,length = 3)
    private String fillerAt2361;

    @DataField(pos = 2364,length = 30,align = "L")
    private String descriptionLine8;

    @DataField(pos = 2394,length = 5 )
    private String fillerAt2394;

    @DataField(pos = 2399,length = 2)
    private String descriptionSegDelimiter;

    @DataField(pos = 2401,length = 2)
    private String streetsideSegId;

    @DataField(pos = 2403,length = 32)
    private String fillerAt2403;

    @DataField(pos = 2435,length = 2)
    private String numStreetSideSubSeg;

    @DataField(pos = 2437,length = 82)
    private String fillerAt2437;

    @DataField(pos = 2519,length = 5)
    private String minorClearingNumber;

    @DataField(pos = 2524,length = 1)
    private String fillerAt2524;

    @DataField(pos = 2525,length = 5)
    private String minorClearingSymbol;

    @DataField(pos = 2530,length = 1)
    private String fillerAt2530;

    @DataField(pos = 2531,length = 5)
    private String minorExecutingBadge;

    @DataField(pos = 2536,length = 64)
    private String fillerAt2536;

    @DataField(pos = 2600,length = 2)
    private String streetSideSegDelimiter;

    public void validate(Logger log){
        final StringBuilder sb = new StringBuilder();
        boolean toThrow = false;
        final Field[] fields = this.getClass().getDeclaredFields();
        for (Field field: fields){
            if(field.isAnnotationPresent(DataField.class) && !Date.class.equals(field.getType())){
                DataField dataHolder = field.getAnnotation(DataField.class);

                try {
                    String value = String.valueOf(field.get(this));
                    if(!StringUtils.equalsAnyIgnoreCase("null",value) && dataHolder.length() < value.length()){
                        sb.append(String.format("LENGTH MISMATCH FIELD[%s] LENGTH [%s] VALUE[%s]",field.getName(),dataHolder.length(),value)).append(",");
                        toThrow = true;
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if(toThrow){
            log.info("Trade failed PreValidation {}",sb.toString());
            throw new RuntimeException(sb.toString());
        }
    }


}
