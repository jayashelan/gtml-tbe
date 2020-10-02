package com.tbe.gtml.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.tbe.gtml.commons.exceptions.GtmlRuntimeException;
import com.tbe.gtml.model.kvp.KvpTrade;
import com.tbe.gtml.parsers.bindy.FixedLengthDataFormat;
import com.tbe.gtml.parsers.bindy.KvpDataFormat;
import com.tbe.gtml.parsers.bindy.XmlDataFormat;
import com.tbe.gtml.parsers.serde.KvpSerDe;
import com.tbe.gtml.parsers.serialization.SerDe;
import com.tbe.gtml.model.fixedlength.FixedLengthTrade;
import com.tbe.gtml.model.xml.*;
import com.tbe.gtml.parsers.serialization.SerDeException;
import com.tbe.gtml.parsers.serde.FixedLengthSerDe;
import com.tbe.gtml.parsers.serde.XmlSerDe;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.persistence.jaxb.JAXBContextFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;


@Slf4j
public class MapperModule  extends AbstractModule {

    @Override
    protected void configure() {
        log.info("! Binding MapperModule !");
    }

    @Provides
    @Singleton
    SerDe<FixedLengthTrade> provideFixedLengthSerDe(){
        return new FixedLengthSerDe(new FixedLengthDataFormat<>(FixedLengthTrade.class));
    }

    @Provides
    @Singleton
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

    @Provides
    @Singleton
    SerDe<KvpTrade> provideKvpTradeSerDe(){
        try {
            return new KvpSerDe(new KvpDataFormat<>(KvpTrade.class));
        } catch (SerDeException e) {
            throw new GtmlRuntimeException(e,e.getCode());
        }
    }
}
