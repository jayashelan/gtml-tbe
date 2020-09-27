package com.tbe.gtml.module;

import com.google.inject.AbstractModule;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Slf4j
public class GtmlCoreModule extends AbstractModule {


    @Override
    protected void configure() {
        log.info("! Binding GtmlCoreModule !");
        install(new MapperModule());

    }
}
