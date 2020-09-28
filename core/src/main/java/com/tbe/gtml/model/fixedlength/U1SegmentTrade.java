package com.tbe.gtml.model.fixedlength;

import com.google.common.base.Strings;
import lombok.Data;
import org.apache.camel.dataformat.bindy.annotation.DataField;

import java.lang.reflect.Field;
import java.util.Objects;

@Data
public class U1SegmentTrade {

    @DataField(pos = 1,length = 2)
    private String u1SegId;

    @DataField(pos = 3,length = 8 )
    private String fillerAt3;

    @DataField(pos = 11,length = 4)
    private String containerSegLen;

    @DataField(pos = 15,length = 31)
    private String fillerAt15;

    @DataField(pos = 46,length = 3)
    private String noContainerSubSeg;

    @DataField(pos = 49, length = 3)
    private String container1Id;

    @DataField(pos = 52,length = 14)
    private String fillerAt52;

    @DataField(pos = 66,length = 1)
    private String statInd;

    @DataField(pos = 67,length = 32)
    private String fillerAt67;

    @DataField(pos = 99,length = 2)
    private String u1SegDelimiter;


    public String build(){
        StringBuilder sb = new StringBuilder();
        Field[] mainClassFields = this.getClass().getDeclaredFields();
        for (Field mainClassField :mainClassFields){
            mainClassField.setAccessible(true);

            if(mainClassField.isAnnotationPresent(DataField.class)){
                DataField tokenHolder = mainClassField.getAnnotation(DataField.class);
                Object value = null;

                try {
                    value = mainClassField.get(this);
                } catch (IllegalAccessException e) {

                }
                if (Objects.isNull(value)){
                    value="";
                }
                sb.append(Strings.padEnd(String.valueOf(value),tokenHolder.length(),' '));
            }
        }
        return sb.toString();
    }
}


