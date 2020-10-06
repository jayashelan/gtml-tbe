package com.tbe.gtml.rules;

import com.tbe.gtml.context.GtmltbeContext;

public interface RuleProcessor  <T extends GtmltbeContext> {

    boolean isEligible(T context);

    void process(T context);
}
