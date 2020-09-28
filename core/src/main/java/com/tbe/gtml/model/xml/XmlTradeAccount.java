package com.tbe.gtml.model.xml;

import lombok.Data;
import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlTradeAccount implements TransObject {

    @XmlAttribute(name = "role")
    private String role;

    @XmlAttribute(name = "AccountSubType")
    private String accountSubType;

    @XmlAttribute(name = "AccountType")
    private String accountType;

    @XmlElement(name = "commons:ActI")
    private String accountIdentifier;

    @XmlPath("commons:AlternateId")
    private List<XmlTradeAlternateId> alternateIds = new ArrayList<>();

    @XmlPath("sdi:SDI/sdi:Line1/Text()")
    private String sdiLine1;

    @XmlPath("sdi:SDI/sdi:Line2/Text()")
    private String sdiLine2;

    @XmlPath("sdi:SDI/sdi:Line3/Text()")
    private String sdiLine3;

    @XmlPath("sdi:SDI/sdi:Line4/Text()")
    private String sdiLine4;

    @XmlPath("sdi:SDI/sdi:Depo/Text()")
    private String sdiDepo;
}
