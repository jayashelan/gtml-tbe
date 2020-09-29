package com.tbe.gtml.parsers.bindy;

import com.tbe.gtml.constants.ErrorCode;
import com.tbe.gtml.parsers.serialization.SerDe;
import com.tbe.gtml.parsers.serialization.SerDeException;
import com.tbe.gtml.constants.Constants;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

public class XmlDataFormat<T> implements SerDe<T> {

    private final JAXBContext context;


    public XmlDataFormat(JAXBContext context) {
        this.context = context;
    }


    @Override
    public T fromBytes(byte[] bytes) throws SerDeException {
        String xmlAsString = new String(bytes);
        try {
            return (T) this.context.createUnmarshaller()
                    .unmarshal(new ByteArrayInputStream(xmlAsString
                            .getBytes(Constants.UTF)));
        } catch (UnsupportedEncodingException | JAXBException e) {
            throw new SerDeException("XmlDataFormat fromBytes Exception", e, ErrorCode.SERDE_PARSER_EXCEPTION);
        }
    }

    @Override
    public byte[] toBytes(T object) throws SerDeException {
        StringWriter writer = new StringWriter();
        try {
            Marshaller marshaller = this.context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(object, writer);
            return writer.toString().getBytes(Constants.UTF);
        } catch (JAXBException | UnsupportedEncodingException e) {
            throw new SerDeException(" CMMDataFormat toBytes Exception ", e, ErrorCode.SERDE_PARSER_EXCEPTION);
        }
    }
}
