package com.tbe.gtml.model.xml;

import lombok.Data;
import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name ="Execution")
@XmlType(propOrder = {"version,origSystem,blotterCode,tradingArea,countryCode,optionOpenCloseCode,exeAccountType,businessLine,tradeStatus," +
        "currentState,source,capacity,interFirm,side,compressionStatus,shortSell,shortSellExempt,exClearing,reversalIndicator," +
        "intraFirm,tbaTradeExecSubType,tbaTradeType,tbaTradeSubType,ficcFlag,specialTrade,exceptionOverride,legacyPlatform,extSetlDays," +
        "setlDays,tradeCategory,clearanceType,price,quantity,tafEligibleQunatity,totalPrice,asEnteredPrice,solicitationCode," +
        "transactionType,autoSettle,transactionEntryDate,settlementMethod,tradeDate,settlementDate,actualSettlementDate,linkedEtid," +
        "branchCode,deskCode,entryDate,exchangeCode,specialTradeInd,settleType,fii,smcpId,whenIssued,tafEligible,sec31FeeEligible," +
        "securityType,spotExchRtMul,spotExchRtDiv,salesPersonIdSystem,salesPersonIdType,salesPersonIdValue,traderIdType," +
        "tradeIdValue,userIdType,userIdValue,userIdSystem,legalEntityId,legalEntityIdSystem,legalEntityIdType,legalEntityIdValue," +
        "settlementSystemConst,settlementSystemType,settlementSystemValue,xmlTradeInstrumentIdsForP,bankLocationAgencyCode," +
        "bankLocationStockLocation,bankLocationCashLocation,alternateIds,tradeAccounts,relationExecutions,xmlTradeInstrumentIdsForS," +
        "tradeCharges,tradeMixedCapacities,bargainConditions,xmlTokens,xmlUsers,largerTraderId1,largerTraderId2," +
        "largerTraderId3,largerTraderIdQualifier,yield,stipulations,sdiDepo,additionalInfoLine1,crntPoolFctrRt,remPrincipalBalance," +
        "trailerCodes,freeFormInfo1,freeFormInfo2,freeFormInfo3,freeFormInfo4,freeFormInfo5"})
public class XmlTrade implements TransObject {

    @XmlPath("@version")
    private String version;

    @XmlPath("OrigSystem/text()")
    private String origSystem;

    @XmlPath("BlotterCode/text()")
    private String blotterCode;

    @XmlPath("TradingArea/text()")
    private String tradingArea;

    @XmlPath("CountryCode/text()")
    private String countryCode;

    @XmlPath("@OptionOpenCloseCode")
    private String optionOpenCloseCode;

    @XmlPath("@accountType")
    private String exeAccountType;

    @XmlPath("@BusinessLine")
    private String businessLine;

    @XmlPath("Status/text()")
    private String tradeStatus;

    @XmlPath("CurrentState/text()")
    private String currentState;

    @XmlPath("Source/text()")
    private String source;

    @XmlPath("@capacity")
    private String capacity;

    @XmlPath("@interFirm")
    private boolean interFirm;

    @XmlPath("@type")
    private String side;

    @XmlPath("@compressionStatus")
    private String compressionStatus;

    @XmlPath("@shortSell")
    private boolean shortSell;

    @XmlPath("@shortSellExempt")
    private boolean shortSellExempt;

    @XmlPath("@exClearing")
    private boolean exClearing;

    @XmlPath("@reversalIndicator")
    private String reversalIndicator;

    @XmlPath("@intraFirm")
    private boolean intraFirm;

    @XmlPath("@tbaTradeExecSubType")
    private String tbaTradeExecSubType;

    @XmlPath("@tbaTradeType")
    private String tbaTradeType;

    @XmlPath("@tbaTradeSubType")
    private String tbaTradeSubType;

    @XmlPath("@ficcFlag")
    private String ficcFlag;

    @XmlPath("@specialTrade")
    private boolean specialTrade;

    @XmlPath("@exceptionOverride")
    private boolean exceptionOverride;

    @XmlPath("@legacyPlatform")
    private String legacyPlatform;

    @XmlPath("ExtSetlDays/text()")
    private long extSetlDays;

    @XmlPath("SetlDays/text()")
    private String setlDays;

    @XmlPath("TradeCategory/text()")
    private String tradeCategory;

    @XmlPath("ClearanceType/text()")
    private String clearanceType;

    @XmlPath("ExecutionItem[@role='S']/PriceQuantityAssociation[@type='TRD']/Price[@type='UNIT']/Value/text()")
    private String price;

    @XmlPath("ExecutionItem[@role='S']/PriceQuantityAssociation[@type='TRD']/Quantity[@type='UNIT']/Value/text()")
    private String quantity;

    @XmlPath("ExecutionItem[@role='S']/PriceQuantityAssociation[@type='TRD']/TAFQuantity[@type='UNIT']/Value/text()")
    private String tafEligibleQunatity;

    @XmlPath("ExecutionItem[@role='S']/PriceQuantityAssociation[@type='FULL']/Price[@type='TOTL']/Value/text()")
    private String totalPrice;

    @XmlPath("ExecutionItem[@role='S']/PriceQuantityAssociation[@type='FULL']/Price[@type='TOTL']/AsEnteredValue/text()")
    private String asEnteredPrice;

    @XmlPath("Transaction/@solicitationCode")
    private String solicitationCode;

    @XmlPath("Transaction/@type")
    private String transactionType;

    @XmlPath("Transaction/@autoSettle")
    private String autoSettle;

    @XmlPath("Transaction/EntryDate/text()")
    @XmlJavaTypeAdapter(XmlDateAdapter.class)
    private Date transactionEntryDate;

    @XmlPath("VpFop/text()")
    private String settlementMethod;

    @XmlPath("TradeDate/text()")
    @XmlJavaTypeAdapter(XmlDateAdapter.class)
    private Date tradeDate;

    @XmlPath("SettlementDate/text()")
    @XmlJavaTypeAdapter(XmlDateAdapter.class)
    private Date settlementDate;

    @XmlPath("ActualSettlementDate/text()")
    @XmlJavaTypeAdapter(XmlDateAdapter.class)
    private Date actualSettlementDate;

    @XmlPath("LinkedEtid/text()")
    private String linkedEtid;

    @XmlPath("BranchCode/text()")
    private String branchCode;

    @XmlPath("DeskCode/text()")
    private String deskCode;

    @XmlPath("EntryDate/text()")
    @XmlJavaTypeAdapter(XmlDateAdapter.class)
    private Date entryDate;

    @XmlPath("ExChangeCode/text()")
    private String exchangeCode;

    @XmlPath("SpecialTradeInd/text()")
    private String specialTradeInd;

    @XmlPath("SettleTYpe/text()")
    private String settleType;

    @XmlPath("ExecutionItem[@role='S']/Instrument/commons:FiI/text()")
    private String fii;

    @XmlPath("ExecutionItem[@role='S']/Instrument/commons:SMCP/text()")
    private String smcpId;

    @XmlPath("ExecutionItem[@role='S']/Instrument/@whenIssued")
    private String whenIssued;

    @XmlPath("ExecutionItem[@role='S']/Instrument/@TAFEligible")
    private boolean tafEligible;

    @XmlPath("ExecutionItem[@role='S']/Instrument/@Sec31FeeEligible")
    private boolean sec31FeeEligible;

    @XmlPath("ExecutionItem[@role='S']/Instrument/@securityType")
    private String securityType;

    @XmlPath("ExchangeRate/Rate[@multiply='true']/text()")
    private String spotExchRtMul;

    @XmlPath("ExchangeRate/Rate[@multiply='false']/text()")
    private String spotExchRtDiv;

    @XmlPath("Employee[@role='SLSP']/commons:AlternateId/commons:System/text()")
    private String salesPersonIdSystem;

    @XmlPath("Employee[@role='SLSP']/commons:AlternateId/commons:Type/text()")
    private String salesPersonIdType;

    @XmlPath("Employee[@role='SLSP']/commons:AlternateId/commons:Value/text()")
    private String salesPersonIdValue;

    @XmlPath("Employee[@role='TRDR']/commons:AlternateId/commons:Type/text()")
    private String traderIdType;

    @XmlPath("Employee[@role='TRDR']/commons:AlternateId/commons:Value/text()")
    private String tradeIdValue;

    @XmlPath("Employee[@role='USER']/commons:AlternateId/commons:Type/text()")
    private String userIdType;

    @XmlPath("Employee[@role='USER']/commons:AlternateId/commons:Value/text()")
    private String userIdValue;

    @XmlPath("Employee[@role='USER']/commons:AlternateId/commons:System/text()")
    private String userIdSystem;

    @XmlPath("ResponsibleLegalEntity/commons:LeI/text()")
    private String legalEntityId;

    @XmlPath("ResponsibleLegalEntity/commons:AlternateId/commons:System/text()")
    private String legalEntityIdSystem;

    @XmlPath("ResponsibleLegalEntity/commons:AlternateId/commons:Type/text()")
    private String legalEntityIdType;

    @XmlPath("ResponsibleLegalEntity/commons:AlternateId/commons:Value/text()")
    private String legalEntityIdValue;

    @XmlPath("Account[@role='PCLR']/commons:AlternateId/commons:System/text()")
    private String settlementSystemConst;

    @XmlPath("Account[@role='PCLR']/commons:AlternateId/commons:Type/text()")
    private String settlementSystemType;

    @XmlPath("Account[@role='PCLR']/commons:AlternateId/commons:Value/text()")
    private String settlementSystemValue;

    @XmlPath("ExecutionItem[@role='P']/Instrument/commons:AlternateId")
    private List<XmlTradeInstrumentId> xmlTradeInstrumentIdsForP = new ArrayList<>();

    @XmlPath("BankLocation/AgentCode/text()")
    private String bankLocationAgencyCode;

    @XmlPath("BankLocation/StockLocation/text()")
    private String bankLocationStockLocation;

    @XmlPath("BankLocation/CashLocation/text()")
    private String bankLocationCashLocation;

    @XmlPath("AlternateId")
    private List<XmlTradeAlternateId> alternateIds = new ArrayList<>();

    @XmlPath("Account")
    private List<XmlTradeAccount> tradeAccounts = new ArrayList<>();

    @XmlPath("RelatedExecution")
    private List<XmlTradeRelationExecution> relationExecutions = new ArrayList<>();

    @XmlPath("ExecutionItem[@role='S']/Instrument/commons:AlternateId")
    private List<XmlTradeInstrumentId> xmlTradeInstrumentIdsForS = new ArrayList<>();

    @XmlPath("ExecitonItem[@role='P']/ExecutionItemAmount")
    private List<XmlTradeCharge> tradeCharges = new ArrayList<>();

    @XmlPath("CapacityQuantity")
    private List<XmlTradeMixedCapacity> tradeMixedCapacities = new ArrayList<>();

    @XmlPath("BargainConditions")
    private List<XmlTradeBargainCondition> bargainConditions = new ArrayList<>();

    @XmlPath("Token")
    private List<XmlToken> xmlTokens  = new ArrayList<>();

    @XmlPath("Employee[@role='USER']/commons:AlternateId")
    private List<XmlUser> xmlUsers  = new ArrayList<>();

    @XmlPath("LargerTrader/LTID1/text()")
    private String largerTraderId1;

    @XmlPath("LargerTrader/LTID2/text()")
    private String largerTraderId2;

    @XmlPath("LargerTrader/LTID3/text()")
    private String largerTraderId3;

    @XmlPath("LargerTrader/LTIDQualifier/text()")
    private boolean largerTraderIdQualifier;

    @XmlPath("ExecutionItem[@role='S']/PriceQuantityAssocation/[@type='YLD']/Price/Value/text()")
    private String yield;

    @XmlPath("Stipulations/text()")
    private String stipulations;

    @XmlPath("SDIDepo/text()")
    private String sdiDepo;

    @XmlPath("AdditionalInfo/Line1/text()")
    private String additionalInfoLine1;

    @XmlPath("ExecutionItem[@role='S']/PriceQuantityAssociation[@type='FCTR']/Price[@type='UNIT']/Value/text()")
    private String crntPoolFctrRt;

    @XmlPath("ExecutionItem[@role='S']/PriceQuantityAssociation[@type='FCTR']/Quantity[@type='UNIT']/Value/text()")
    private String remPrincipalBalance;

    @XmlPath("TrailerCodes/text()")
    private String trailerCodes;

    @XmlPath("FreeFormInfo[@type='ECHO']/text()")
    private String freeFormInfo1;

    @XmlPath("FreeFormInfo[@type='DNB']/text()")
    private String freeFormInfo2;

    @XmlPath("FreeFormInfo[@type='TRN2']/text()")
    private String freeFormInfo3;

    @XmlPath("FreeFormInfo[@type='ROUTING']/text()")
    private String freeFormInfo4;

    @XmlPath("FreeFormInfo[@type='ADDN2']/text()")
    private String freeFormInfo5;

}
