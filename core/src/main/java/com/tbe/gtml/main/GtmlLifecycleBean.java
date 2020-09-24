package com.tbe.gtml.main;

import com.google.common.base.Splitter;
import com.google.inject.Guice;
import com.google.inject.Module;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class GtmlLifecycleBean {



    @ConfigProperty(name = "guice.modules")
    String modules;



    void onStart(@Observes StartupEvent ev) {
        System.out.println("The application is starting...");
        loadGuiceModules();
    }

    void onStop(@Observes ShutdownEvent ev) {
        System.out.println("The application is stopping...");
    }

    void loadGuiceModules(){

           ArrayList<Module> modules = new ArrayList<Module>();
            for (String className: getModules()){
                try {
                Module m = (Module) Class.forName(className).getDeclaredConstructor().newInstance();
                modules.add(m);
                } catch (Exception ex) {
                    System.out.println("Class not found " + className);
                }
            }
           Guice.createInjector(modules);
    }

    private List<String> getModules(){
        return Splitter.on(" ")
                .omitEmptyStrings()
                .trimResults()
                .splitToList(this.modules);
    }
}
