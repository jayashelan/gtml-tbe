package com.tbe.gtml.model.xml;

import lombok.Data;
import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlToken {

    @XmlAttribute(name="name")
    private String tokenName;

    @XmlAttribute(name = "type")
    private String tokenType;

    @XmlPath("text()")
    private String tokenValue;

}
