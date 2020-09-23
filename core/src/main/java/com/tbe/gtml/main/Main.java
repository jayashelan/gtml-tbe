package com.tbe.gtml.main;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.apache.camel.quarkus.main.CamelMainApplication;

@QuarkusMain
public class Main {
    public static void main(String... args) {
        //
        // your logic here
        //
        System.out.println("Starting.............");
        Quarkus.run(CamelMainApplication.class, args);
        System.out.println("After starting.............");
    }
}
