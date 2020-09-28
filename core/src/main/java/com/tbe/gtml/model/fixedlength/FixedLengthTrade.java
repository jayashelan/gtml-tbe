package com.tbe.gtml.model.fixedlength;

import lombok.Data;
import org.apache.camel.dataformat.bindy.annotation.FixedLengthRecord;
import org.apache.camel.dataformat.bindy.annotation.Link;

@Data
@FixedLengthRecord(length = 100,paddingChar = ' ')
public class FixedLengthTrade {

    @Link
    private FixedLengthHeader header;

    private String baseSegmentId;

    private String fillerAt153;

    private String clientNumber;

    private String branchNumber;

    private String baseAccountNumber;

    private String accountType;

    private String checkDigit;

    private String accountCurrency;

    private String fillerAt183;

    private String transactionCategory;

    private String transactionType;

    private String whenIssueCode;

    private String side;

    private String settlementDate;

    private String tradeDate;

    private String blotterCode;

    private String tagNumber;

    private String fillerAt229;

    private String optionIndicator;

    private String dnsOrderDate;

    private String fillerAt265;

    private String effectiveDate;

    private String fillerAt306;

    private String openCloseCode;

    private String fillerAt321;

    private String rebillCode;

    private String fillerAt327;

    private String rebillMatchCode;

    private String fillerAt329;

    private String wiCanExtensionCode;

    private String fillerAt331;

    private String quantity;

    private String fillerAt359;

    private String primaryPriceCode;

    private String dollarPriceFormat;

    private String dollarPrice;

    private String fillerAt390;

    private String priceCurrency;

    private String fillerAt404;

    private String securityIndentifierCode;

    private String securityIdNumber;

    private String rrNumber;

    private String fillerAt463;

    private String solicationCode;

    private String fillerAt476;

    private String trailerCode1;

    private String trailerCode2;

    private String trailerCode3;

    private String trailerCode4;

    private String trailerCode5;

    private String fillerAt510;

    private String confirmCode;

    private String fillerAt531;

    private String userId;

    private String filler680;

    private String depositoryOverrideCode;

    private String depositoryOverrideValue;

    private String dtcNumber;

    private String agentBankNumber;

    private String CustomerNumber;

    private String intitutionId;

    private String fillerAt744;

    private String optionExpirationDate;

    private String fillerAt846;

    private String freeFormText;

    private String fillerAt977;

    private String baseSegmentDelimitor;

    private String figurationSegmentId;

    private String fillerAt1003;

    private String netAmountIdCode;

    private String netAmount;

    private String netAmountCurrencyCode;

    private String fillerAt1040;

    private String principalIdCode;

    private String principalAmount;

    private String principalCurrencyCode;

    private String filler1064;

    private String interestCode;

    private String interestAmount;

    private String interestCurrencyCode;

    private String interestAddSubtractCode;

    private String fillerAt1185;

    private String interestSupressionCode;

    private String fillerAt1187;

    private String commissionIdCode;

    private String commissionCurrencyCode;

    private String commissionAddSubtractCode;

    private String fillerAt1208;

    private String grossCreditIdCode;

    private String grossCreditAmount;

    private String grossCreditCurrencyCode;

    private String fillerAt1228;

    private String secFeeIdCode;

    private String secFeeAmount;

    private String secFecAmountCurrencyCode;

    private String fillerAt1269;

    private String nyTaxCode;

    private String fillerAt1312;

    private String gpfIdCode1;

    private String gpfAmount1;

    private String gpfCurrencyCode1;

    private String gpfAddSubtractCode1;

    private String fillerAt1339;

    private String gpfIdCode2;

    private String gpfAmount2;

    private String gpfCurrencyCode2;

    private String gpfAddSubtractCode2;

    private String fillerAt1360;

    private String gpfIdCode3;

    private String gpfAmount3;

    private String gpfCurrencyCode3;

    private String gpfAddSubtractCode3;

    private String fillerAt1381;

    private String gpfIdCode4;

    private String gpfAmount4;

    private String gpfCurrencyCode4;

    private String gpfAddSubtractCode4;

    private String fillerAt1402;

    private String gpfIdCode5;

    private String gpfAmount5;

    private String gpfCurrencyCode5;

    private String gpfAddSubtractCode5;

    private String fillerAt1423;

    private String figurationSegDelimiter;

    private String transactionSupSegId;

    private String fillerAt1703;

    private String optionOffsetCode;

    private String fillerAt1872;

    private String dtcIdMarketCode;

    private String dtcIdRole;

    private String fillerAt2048;

    private String transactionSupSegDelimiter;

    private String descriptionSegId;

    private String fillerAt2063;

    private String numSubSegments;

    private String fillerAt2079;

    private String descriptionClass1;

    private String fillerAt2081;

    private String descriptionLine1;

    private String fillerAt2114;

    private String descriptionClass2;

    private String fillerAt2121;

    private String descriptionLine2;

    private String fillerAt2154;

    private String descriptionClass3;

    private String fillerAt2161;

    private String descriptionLine3;

    private String fillerAt2194;

    private String descriptionClass4;

    private String fillerAt2201;

    private String descriptionLine4;

    private String fillerAt2234;

    private String descriptionClass5;

    private String fillerAt2241;

    private String descriptionLine5;

    private String fillerAt2274;

    private String descriptionClass6;

    private String fillerAt2281;

    private String descriptionLine6;

    private String fillerAt2314;

    private String descriptionClass7;

    private String fillerAt2321;

    private String descriptionLine7;

    private String fillerAt2354;

    private String descriptionClass8;

    private String fillerAt2394;

    private String descriptionSegDelimiter;

    private String streetsideSegId;

    private String fillerAt2403;

    private String numStreetSideSubSeg;

    private String fillerAt2437;

    private String minorClearingNumber;

    private String fillerAt2524;

    private String minorClearingSymbol;

    private String fillerAt2530;

    private String minorExecutingBadge;

    private String fillerAt2536;

    private String streetSideSegDelimiter;


















}
