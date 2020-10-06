package com.tbe.gtml.module;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import com.tbe.gtml.constants.EventStatus;
import com.tbe.gtml.constants.MessageType;
import com.tbe.gtml.context.TradeContext;
import com.tbe.gtml.processor.MessageProcessor;
import com.tbe.gtml.processor.XmlMessageProcessor;
import com.tbe.gtml.rules.RuleProcessor;
import com.tbe.gtml.rules.TestRule;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Set;

@ApplicationScoped
@Slf4j
public class GtmlCoreModule  extends  AbstractModule {

    @Override
    protected void configure() {
        MapBinder<MessageType,MessageProcessor<TradeContext>> messageProcessorMapBinder = MapBinder.newMapBinder(binder(),
                new TypeLiteral<MessageType>(){},
                new TypeLiteral<MessageProcessor<TradeContext>>(){});

        addMessageProcessors(messageProcessorMapBinder);

        MapBinder<EventStatus, Set<RuleProcessor<TradeContext>>> rulesBinder = MapBinder.newMapBinder(binder(),
                new TypeLiteral<EventStatus>(){},
                new TypeLiteral<Set<RuleProcessor<TradeContext>>>(){}
                );

        populateRulesBinder(rulesBinder);
    }

    private void addMessageProcessors(MapBinder<MessageType,MessageProcessor<TradeContext>> messageProcessorMapBinder){
        messageProcessorMapBinder.addBinding(MessageType.XML).to(XmlMessageProcessor.class);
    }

    private void populateRulesBinder(MapBinder<EventStatus, Set<RuleProcessor<TradeContext>>> rulesBinder){

        List<Class< ? extends RuleProcessor<TradeContext>>> actvRulesList = List.of(
                TestRule.class
        ) ;

        //bind the rules
        Multibinder<RuleProcessor<TradeContext>> actvRulesSet = Multibinder.newSetBinder(binder(),new TypeLiteral<RuleProcessor<TradeContext>>(){}, Names.named("actv"));

        actvRulesList.forEach(aClass -> actvRulesSet.addBinding().to(aClass));

        rulesBinder.addBinding(EventStatus.ACTV).toProvider(new Provider<Set<RuleProcessor<TradeContext>>>() {

            @Inject
            @Named("actv")
            Set<RuleProcessor<TradeContext>> ruleProcessors;

            @Override
            public Set<RuleProcessor<TradeContext>> get() {
                return ruleProcessors;
            }
        });
        //Cxld Event
        List<Class< ? extends  RuleProcessor<TradeContext>>> cxldRulesList = List.of(
          TestRule.class
        );

        Multibinder<RuleProcessor<TradeContext>> cxldRulesSet = Multibinder.newSetBinder(binder(),new TypeLiteral<RuleProcessor<TradeContext>>(){}, Names.named("cxld"));

        cxldRulesList.forEach(aClass -> cxldRulesSet.addBinding().to(aClass));

        rulesBinder.addBinding(EventStatus.CXLD).toProvider(new Provider<Set<RuleProcessor<TradeContext>>>() {

            @Inject
            @Named("cxld")
            Set<RuleProcessor<TradeContext>> ruleProcessors;

            @Override
            public Set<RuleProcessor<TradeContext>> get() {
                return ruleProcessors;
            }
        });

        //Mod Event
        List<Class< ? extends  RuleProcessor<TradeContext>>> modRulesList = List.of(
                TestRule.class
        );

        Multibinder<RuleProcessor<TradeContext>> modRulesSet = Multibinder.newSetBinder(binder(),new TypeLiteral<RuleProcessor<TradeContext>>(){}, Names.named("mod"));

        modRulesList.forEach(aClass -> modRulesSet.addBinding().to(aClass));

        rulesBinder.addBinding(EventStatus.MOD).toProvider(new Provider<Set<RuleProcessor<TradeContext>>>() {

            @Inject
            @Named("mod")
            Set<RuleProcessor<TradeContext>> ruleProcessors;

            @Override
            public Set<RuleProcessor<TradeContext>> get() {
                return ruleProcessors;
            }
        });








    }



}
