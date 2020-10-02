package com.tbe.gtml.commons.util;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.KeyValuePairField;
import org.eclipse.persistence.oxm.annotations.XmlPath;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class GsonUtils {

    private GsonUtils(){}

    public static Gson getGsonBuilder(boolean handleNull){
        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting().disableInnerClassSerialization().setFieldNamingStrategy(new FieldNamingStrategy() {
            @Override
            public String translateName(Field field) {
                Annotation[] annotations = field.getDeclaredAnnotations();
                for (Annotation annotation :annotations ){
                    if (annotation instanceof KeyValuePairField){
                        KeyValuePairField kvp = (KeyValuePairField) annotation;
                        return field.getName() + "(" +kvp.tag() +")";
                    }
                    if (annotation instanceof DataField){
                        DataField dataField = (DataField) annotation;
                        return field.getName() + "(pos="+ dataField.pos()+", length ="+dataField.length()+")";
                    }
                    if(annotation instanceof XmlPath){
                        XmlPath xmlPath = (XmlPath) annotation;
                        return field.getName() + "("+xmlPath.value()+")";
                    }
                }
                return field.getName();
            }
        }).disableHtmlEscaping();

        if(handleNull){
            return gsonBuilder.serializeNulls().create();
        }
        return gsonBuilder.create();



    }
}
