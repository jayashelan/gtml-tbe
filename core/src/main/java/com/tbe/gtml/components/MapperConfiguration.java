package com.tbe.gtml.components;


import com.tbe.gtml.commons.exceptions.GtmlRuntimeException;
import com.tbe.gtml.model.fixedlength.FixedLengthTrade;
import com.tbe.gtml.model.kvp.KvpTrade;
import com.tbe.gtml.model.xml.*;
import com.tbe.gtml.parsers.bindy.FixedLengthDataFormat;
import com.tbe.gtml.parsers.bindy.KvpDataFormat;
import com.tbe.gtml.parsers.bindy.XmlDataFormat;
import com.tbe.gtml.parsers.serde.FixedLengthSerDe;
import com.tbe.gtml.parsers.serde.KvpSerDe;
import com.tbe.gtml.parsers.serde.XmlSerDe;
import com.tbe.gtml.parsers.serialization.SerDe;
import com.tbe.gtml.parsers.serialization.SerDeException;
import io.quarkus.arc.DefaultBean;
import org.eclipse.persistence.jaxb.JAXBContextFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

@ApplicationScoped
public class MapperConfiguration {


    SerDe<FixedLengthTrade> provideFixedLengthSerDe(){
        return new FixedLengthSerDe(new FixedLengthDataFormat<>(FixedLengthTrade.class));
    }

    SerDe<XmlTrade> provideXmlSerDe(){

        Class[] classes = new Class[] {XmlTrade.class, XmlCmmInterestPaymentTerms.class,
                XmlToken.class, XmlTradeAccount.class, XmlTradeAlternateId.class,XmlTradeBargainCondition.class,
                XmlTradeCharge.class,XmlTradeInstrumentId.class,XmlTradeMixedCapacity.class,
                XmlTradeRelationExecution.class,XmlUser.class};
        try {
            JAXBContext jaxbContext = JAXBContextFactory.createContext(classes,null);
            XmlDataFormat<XmlTrade> dataFormat = new XmlDataFormat<>(jaxbContext);
            return new XmlSerDe(dataFormat);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    SerDe<KvpTrade> provideKvpTradeSerDe(){
        try {
            return new KvpSerDe(new KvpDataFormat<>(KvpTrade.class));
        } catch (SerDeException e) {
            throw new GtmlRuntimeException(e,e.getCode());
        }
    }


}
