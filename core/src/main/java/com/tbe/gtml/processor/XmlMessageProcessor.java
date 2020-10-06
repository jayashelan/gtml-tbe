package com.tbe.gtml.processor;

import com.tbe.gtml.constants.MessageType;
import com.tbe.gtml.context.TradeContext;
import com.tbe.gtml.model.xml.XmlTrade;
import com.tbe.gtml.parsers.serialization.SerDe;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class XmlMessageProcessor implements  MessageProcessor<TradeContext> {

    private final SerDe<XmlTrade> tradeSerDe;

    @Inject
    public XmlMessageProcessor(SerDe<XmlTrade> tradeSerDe) {
        this.tradeSerDe = tradeSerDe;
    }


    @Override
    public void process(TradeContext TradeContext, MessageType messageType, String... recipients) {

    }
}
