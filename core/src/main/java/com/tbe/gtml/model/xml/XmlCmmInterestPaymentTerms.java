package com.tbe.gtml.model.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@Data
public class XmlCmmInterestPaymentTerms {
    @XmlAttribute(name ="periodNumber")
    private String periodNumber;

    @XmlAttribute(name ="periodType")
    private String periodType;

    @XmlElement(name ="StartDate")
    private String startDate;

    @XmlElement(name ="PaymentDate")
    private String paymentDate;

    @XmlElement(name ="ActualPaymentDate")
    private String actualPaymentDate;

    @XmlElement(name ="LegAmount")
    private BigDecimal legAmount;

    @XmlElement(name ="EndDate")
    private String endDate;

    @XmlElement(name ="RateType")
    private String rateType;

    @XmlElement(name ="Rate")
    private BigDecimal rate;

    @XmlElement(name ="InterestDays")
    private Long interestDays;


}
