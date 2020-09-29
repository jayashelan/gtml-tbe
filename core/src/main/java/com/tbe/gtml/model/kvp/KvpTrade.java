package com.tbe.gtml.model.kvp;

import lombok.Data;
import org.apache.camel.dataformat.bindy.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Section(number = 2)
@Message(pairSeparator = "\\u0001",keyValuePairSeparator = "=",type="FIX",version = "4.4")
public class KvpTrade {

    @Link
    private KvpHeader header;

    @KeyValuePairField(tag = 15)
    private String currency;

    @KeyValuePairField(tag = 31)
    private String lastPx;

    @KeyValuePairField(tag = 32)
    private String lastQty;

    @KeyValuePairField(tag = 38)
    private String orderQty;

    @KeyValuePairField(tag = 54)
    private String side;

    @KeyValuePairField(tag = 60, pattern = "yyyyMMdd-HH:mm:ss.SSS")
    private Date transactTime;

    @KeyValuePairField(tag = 63)
    private String settlType;

    @KeyValuePairField(tag = 64,pattern = "yyyyMMdd")
    private Date settlDate;

    @KeyValuePairField(tag = 66)
    private String listID;

    @KeyValuePairField(tag = 75,pattern = "yyyyMMdd")
    private Date tradeDate;

    @KeyValuePairField(tag = 81)
    private String processCode;

    @KeyValuePairField(tag = 150)
    private String execType;

    @KeyValuePairField(tag = 377)
    private String solicitedFlag;

    @KeyValuePairField(tag = 528)
    private String orderCapacity;

    @KeyValuePairField(tag = 1016)
    private String modifiedBy;

    @KeyValuePairField(tag = 1018)
    private String zexecId;

    @KeyValuePairField(tag = -14)
    private String syncNum;

    @KeyValuePairField(tag = 1024)
    private String ordSyncNum;

    @KeyValuePairField(tag = 1036)
    private String salesPersonId;

    @KeyValuePairField(tag = 1039)
    private String traderId;

    @KeyValuePairField(tag = 1040)
    private String branchId;

    @KeyValuePairField(tag = 1041)
    private String tradeArea;

    @KeyValuePairField(tag = 1279)
    private String lseIndicator;

    @OneToMany(mappedTo = "com.tbe.gtml.model.kvp.KvpBargainCondition")
    private List<KvpBargainCondition> bargainConditions;

    @KeyValuePairField(tag = 1109)
    private String acctPosCurr;

    @Link
    private KvpNoOfFees noOfFees;

    @OneToMany(mappedTo = "com.tbe.gtml.model.kvp.KvpMiscFee")
    private List<KvpMiscFee>  miscFees;

    @KeyValuePairField(tag = 1272)
    private String donotBillFlag;

    @KeyValuePairField(tag = 1273)
    private String eaCode;

    @KeyValuePairField(tag = 1274)
    private String ebsExchange;

    @KeyValuePairField(tag = 1275)
    private String ebsTransType;

    @KeyValuePairField(tag = 1276)
    private String sdiLine1;

    @KeyValuePairField(tag = 1277)
    private String parentTradeId;

    @KeyValuePairField(tag = 654)
    private String legRefId;

    @KeyValuePairField(tag = 1022)
    private String expectedValue;

    @KeyValuePairField(tag = 1185)
    private String saCode;

    @KeyValuePairField(tag = 1141)
    private String linkSettlementFlag;

    @KeyValuePairField(tag = 1)
    private String account;

    @KeyValuePairField(tag = 375)
    private String contraBroker;

    @KeyValuePairField(tag = 581)
    private String accountType;

    @KeyValuePairField(tag = 22)
    private String securityIdSource;

    @KeyValuePairField(tag = 48)
    private String securityId;

    @KeyValuePairField(tag = 44)
    private String price;

    @KeyValuePairField(tag = 120)
    private String settlCurrency;

    @KeyValuePairField(tag = 155)
    private String settleCurrFxRate;

    @KeyValuePairField(tag = 156)
    private String settlCurrFxRateCalc;

    @KeyValuePairField(tag = 423)
    private String priceType;

    @KeyValuePairField(tag = 1280)
    private String legNumber;

    @KeyValuePairField(tag = 58)
    private String text;

    @KeyValuePairField(tag = 1289)
    private String sdiLine2;

    @KeyValuePairField(tag = 11)
    private String clordId;

    @KeyValuePairField(tag = 1290)
    private String sdiLine3;

    @KeyValuePairField(tag = 1291)
    private String sdiLine4;

    @KeyValuePairField(tag = 1238)
    private String tradeOptionalField;

    @KeyValuePairField(tag = 70)
    private String allocId;

    @KeyValuePairField(tag = 730)
    private String settlPrice;

    @KeyValuePairField(tag = 1347)
    private String forexAccomodationInd;

    @KeyValuePairField(tag = 1348)
    private String markFlow;

    @KeyValuePairField(tag = 17)
    private String execId;

    @KeyValuePairField(tag = 100)
    private String exdestination;

    @KeyValuePairField(tag = 194)
    private String lastSpotRate;

    @KeyValuePairField(tag = 861)
    private String reportedPx;

    @KeyValuePairField(tag = 7566)
    private String timezoneOffset;

    @KeyValuePairField(tag = 1142)
    private String pnotePrice;

    @KeyValuePairField(tag = 1143)
    private String pnoteRate;

    @KeyValuePairField(tag = 1144)
    private String pnoteMdIndex;

    @KeyValuePairField(tag = 1146)
    private String pnoteCommisionIn;

    @KeyValuePairField(tag = 1147)
    private String pnoteCommisionOut;

    @KeyValuePairField(tag = 1001)
    private String mergeId;

    @KeyValuePairField(tag = 395)
    private String numTickets;

    @KeyValuePairField(tag = 1106)
    private String custAcct;

    @KeyValuePairField(tag = 1023)
    private String exchange;

    @KeyValuePairField(tag = 1049)
    private String execLinkId;

    @KeyValuePairField(tag = 1133)
    private String value;

    @KeyValuePairField(tag = 1369)
    private String stampStatus;

    @KeyValuePairField(tag = 1478)
    private String customerInstructionPointer;

    @KeyValuePairField(tag = 1479)
    private String firmInstructionPointer;

    @KeyValuePairField(tag = 1540)
    private String placeOfSettlement;

    @KeyValuePairField(tag = 1617)
    private String blotterCode;

    @KeyValuePairField(tag = 1052)
    private String orderVersion;

    @KeyValuePairField(tag = 660)
    private String acctIdSource;

    @KeyValuePairField(tag = 1642)
    private String confirmTrailerText;

    @KeyValuePairField(tag = 1959)
    private String compExecCapacity;

    @KeyValuePairField(tag = 1472)
    private String noComments;

    @KeyValuePairField(tag = 1473)
    private String commentType;

    @KeyValuePairField(tag = 1373)
    private String comments;

    @KeyValuePairField(tag = 454)
    private String nosecurityAltId;

    @KeyValuePairField(tag = 455)
    private String securityAltId;

    @KeyValuePairField(tag = 456)
    private String securityAltIdSource;

    @KeyValuePairField(tag = 1257)
    private String routeFlag;

    @KeyValuePairField(tag = 1486)
    private String text2;

    @KeyValuePairField(tag = 77)
    private String positionEffect;

    @KeyValuePairField(tag = 1964)
    private String leafExecId;

    @KeyValuePairField(tag = 1965)
    private String leafSrcSystemId;

    @KeyValuePairField(tag = 1210)
    private String rootOrderId;

    @KeyValuePairField(tag = 1515)
    private String rootSrcSystemId;

    @KeyValuePairField(tag = 204)
    private String customerOrFirm;

    @KeyValuePairField(tag = 1330)
    private String settlementCountryCode;

    @KeyValuePairField(tag = 1179)
    private String zeusKey;

    @KeyValuePairField(tag = 1027)
    private String accountMnc;

    @KeyValuePairField(tag = 167)
    private String securityType;

    @KeyValuePairField(tag = 1305)
    private String cmtaFlag;

    @KeyValuePairField(tag = 1383)
    private String cmtaAlloc;

    @KeyValuePairField(tag = 453)
    private String nopartyIds;

    @KeyValuePairField(tag = 447)
    private String partyIdSource;

    @KeyValuePairField(tag = 448)
    private String partyId;

    @KeyValuePairField(tag = 452)
    private String partyRole;

    @KeyValuePairField(tag = 802)
    private String nopartySubIds;

    @KeyValuePairField(tag = 523)
    private String partySubId;

    @KeyValuePairField(tag = 803)
    private String partySubIdType;

    @KeyValuePairField(tag = 1323)
    private String tradeReferenceType;

    @KeyValuePairField(tag = 1053)
    private String ordLinkId;

    @KeyValuePairField(tag = 1082)
    private String accountSlang;

    @KeyValuePairField(tag = 1207)
    private String fcNo;

    @KeyValuePairField(tag = 1053)
    private String channelName;

    @KeyValuePairField(tag = 1068)
    private String agencyCrossQty;

    @KeyValuePairField(tag = 1069)
    private String principalCrossQty;

    @KeyValuePairField(tag = 1171)
    private String grandParentNum;

    @KeyValuePairField(tag = 1061)
    private String sumRleQty;

    @KeyValuePairField(tag = 1062)
    private String sumPreQty;

    @KeyValuePairField(tag = 1063)
    private String sumAgeQty;

    @KeyValuePairField(tag = 1643)
    private String trailerCode;

    @KeyValuePairField(tag = 1189)
    private String accomodationLegend;

    @KeyValuePairField(tag = 10)
    private String checkSum;

    @KeyValuePairField(tag = 1718)
    private String clientType;

    @KeyValuePairField(tag = 37)
    private String sellSideOrdId;

    @KeyValuePairField(tag = 1046)
    private String exchangeIndicator;

    @KeyValuePairField(tag = 1357)
    private String salesCredit;

    @KeyValuePairField(tag = 1031)
    private String legalEntity;

    @KeyValuePairField(tag = 421)
    private String country;

    @KeyValuePairField(tag = 1278)
    private String parentTradeVersion;

    @KeyValuePairField(tag = 55)
    private String symbol;

    @KeyValuePairField(tag = 207)
    private String securityExchange;

    @KeyValuePairField(tag = 157)
    private String numDaysInterest;

    @KeyValuePairField(tag = 1145)
    private String pnoteUnderLyingCcy;

    @KeyValuePairField(tag = 1057)
    private String introBrkMnc;

    @KeyValuePairField(tag = 5053)
    private String settlementMethod;

    @KeyValuePairField(tag = 40)
    private String ordType;

    @KeyValuePairField(tag = 5752)
    private String vspPrice;

    @KeyValuePairField(tag = 5751)
    private String vspDate;

    @KeyValuePairField(tag = 1644)
    private String restrictionOverrideText;

    @KeyValuePairField(tag = 1649)
    private String uniqDealId;

    @KeyValuePairField(tag = 1650)
    private String dealtTypeInd;

    @KeyValuePairField(tag = 440)
    private String etfCnsClearingNo;

    @KeyValuePairField(tag = 172)
    private String etfSettlementMethod;

    @KeyValuePairField(tag = 1651)
    private String orderTradeType;

    @KeyValuePairField(tag = 1029)
    private String subAccount;

    @KeyValuePairField(tag = 577)
    private String clearingInstruction;

    @KeyValuePairField(tag = 1307)
    private String syndicateIndicator;

    @KeyValuePairField(tag = 1598)
    private String allocationInstruction;

    @KeyValuePairField(tag = 999)
    private String srcSystemHeader;

    @KeyValuePairField(tag = 1017)
    private String execBkrMnem;

    @Link
    private KvpNoOfAccts noOfAccts;

    @OneToMany(mappedTo = "com.tbe.gtml.model.kvp.KvpAltAcct")
    private List<KvpAltAcct> altAccts = new ArrayList<>();

    @KeyValuePairField(tag = 11510)
    private String orderPrice;

    @KeyValuePairField(tag = 11511)
    private String orderCurrency;

    @KeyValuePairField(tag = 11512)
    private String exchangeRate;

    @KeyValuePairField(tag = 11515)
    private String converstionRatio;

    @KeyValuePairField(tag = 11514)
    private String converstionCost;

    @KeyValuePairField(tag = 11588)
    private String newAgencyCrossQty;

    @KeyValuePairField(tag = 11589)
    private String newPrincipalCrossQty;

    @KeyValuePairField(tag = 11590)
    private String newSumRLExQty;

    @KeyValuePairField(tag = 11591)
    private String newSumPREqty;

    @KeyValuePairField(tag = 11592)
    private String newSumAGExQty;

    @KeyValuePairField(tag = 11518)
    private String netCharge;

}
