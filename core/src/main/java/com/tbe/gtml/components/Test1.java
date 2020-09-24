package com.tbe.gtml.components;

import com.google.inject.AbstractModule;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Test1 extends AbstractModule {

    @Override
    protected void configure() {
        System.out.println("Test1 !!!!!");
    }

}
