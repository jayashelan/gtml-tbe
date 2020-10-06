package com.tbe.gtml.rules;

import com.tbe.gtml.context.TradeContext;

public class TestRule implements RuleProcessor<TradeContext> {
    @Override
    public boolean isEligible(TradeContext context) {
        return false;
    }

    @Override
    public void process(TradeContext context) {
        //do nthing for now
    }
}
