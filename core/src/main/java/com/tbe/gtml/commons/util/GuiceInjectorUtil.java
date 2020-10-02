package com.tbe.gtml.commons.util;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;



public class GuiceInjectorUtil {

    static Injector injector = null;


    static {
        Properties gProps = new Properties();
        try {
            System.out.println("Loading guice.properties file ");
            gProps.load(GuiceInjectorUtil.class.getResourceAsStream("/guice.properties"));
            System.out.println("Successfully loaded guice.properties file");
        } catch (Exception e) {
            System.out.println("Exception during reading guice.properties file " + e);
        }
        Set keys = gProps.keySet();
        ArrayList<Module> modules = new ArrayList<Module>();

        String className = null;
        try {
            if (keys != null) {
                Iterator it = keys.iterator();
                while (it.hasNext()) {
                    className = gProps.getProperty((String) it.next());
                    System.out.println("Creating module for class " + className);
                    Module m = (Module) Class.forName(className).getDeclaredConstructor().newInstance();
                    modules.add(m);
                }
            }
            injector = Guice.createInjector(modules);
        } catch (Exception ex) {
            System.out.println("Class not found " + className);
        }

    }


    public static Injector getInjector() {
        return injector;
    }
}