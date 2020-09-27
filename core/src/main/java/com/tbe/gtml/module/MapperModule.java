package com.tbe.gtml.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.tbe.gtml.common.parsers.bindy.FixedLengthDataFormat;
import com.tbe.gtml.common.parsers.serialization.SerDe;
import com.tbe.gtml.model.fixedlength.FixedLengthTrade;
import com.tbe.gtml.model.serde.FixedLengthSerDe;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class MapperModule  extends AbstractModule {



    @Override
    protected void configure() {
        log.info("! Binding MapperModue !");
    }

    @Provides
    @Singleton
    SerDe<FixedLengthTrade> provideFixedLengthSerDe(){
        FixedLengthDataFormat<FixedLengthTrade> dataFormat = null;
        dataFormat = new FixedLengthDataFormat<>(FixedLengthTrade.class);
        return new FixedLengthSerDe(dataFormat);
    }
}
