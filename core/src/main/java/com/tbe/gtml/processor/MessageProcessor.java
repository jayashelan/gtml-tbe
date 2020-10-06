package com.tbe.gtml.processor;

import com.tbe.gtml.constants.MessageType;
import com.tbe.gtml.context.GtmltbeContext;

public interface MessageProcessor<T extends GtmltbeContext> {
    void process(T TradeContext, MessageType messageType, String... recipients);
}
