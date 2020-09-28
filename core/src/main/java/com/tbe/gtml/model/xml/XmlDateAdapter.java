package com.tbe.gtml.model.xml;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Date;
import java.util.Objects;

public class XmlDateAdapter extends XmlAdapter<String, Date> {

    DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");


    @Override
    public Date unmarshal(String s) throws Exception {
        if (Objects.nonNull(s)) {
            return fmt.parseDateTime(s).toDate();
        }
        return null;
    }

    @Override
    public String marshal(Date date) throws Exception {
        if (Objects.nonNull(date)) {
            DateTime dateTime = new DateTime(date);
            return dateTime.toString(fmt);
        }
        return null;
    }

}
