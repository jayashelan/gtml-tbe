package com.tbe.gtml.parsers.bindy;

import com.tbe.gtml.constants.ErrorCode;
import com.tbe.gtml.parsers.serialization.SerDe;
import com.tbe.gtml.parsers.serialization.SerDeException;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.dataformat.bindy.*;
import org.apache.camel.spi.PackageScanClassResolver;
import org.apache.camel.util.ObjectHelper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Slf4j
public class FixedLengthDataFormat<T> extends BindyAbstractDataFormat implements SerDe<T> {


    private String objectType;

    private PackageScanClassResolver packageScanClassResolver;

    private BindyAbstractFactory fixedFactory;

    public FixedLengthDataFormat(Class<T> classType) {
        this.setClassType(classType);
    }

    @Override
    public byte[] toBytes(Object object) throws SerDeException {
        List<Map<String, Object>> models = (ArrayList) object;
        StringBuilder marshalFixedMessage = new StringBuilder();

        for (Map<String, Object> model : models) {
            try {
                marshalFixedMessage.append(getFactory().unbind(null, model));
            } catch (Exception e) {
                throw new SerDeException(e, ErrorCode.SERDE_PARSER_EXCEPTION);
            }
        }
        return marshalFixedMessage.toString().getBytes();
    }

    @Override
    public T fromBytes(byte[] bytes) throws SerDeException {
        List<Map<String, Object>> models = new ArrayList<>();

        Map<String, Object> model;

        Scanner scanner = new Scanner(new String(bytes));

        int count = 0;

        try {
            BindyFixedLengthFactory factory = (BindyFixedLengthFactory) getFactory();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (ObjectHelper.isEmpty(line)) {
                    continue;
                }
                count++;

                if (line.length() < factory.recordLength() || line.length() > factory.recordLength()) {
                    throw new IllegalArgumentException(String.format("Size of the Record :%s is not equal to the value provided in the model",
                            line.length(), factory.recordLength()));

                }

                model = factory.factory();

                factory.bind(null, line, model, count);

                factory.link(model);

                models.add(model);


            }

            if(models.isEmpty()){
                throw new IllegalArgumentException("No record have been defined in the message !");
            }
            return (T) models.get(0).get(this.objectType);
        } catch (Exception e) {

            throw new SerDeException(e,ErrorCode.SERDE_PARSER_EXCEPTION);
        }finally {
            scanner.close();
        }

    }


    @Override
    protected BindyAbstractFactory createModelFactory(FormatFactory formatFactory) throws Exception {
        BindyFixedLengthFactory bindyFixedLengthFactory = new BindyFixedLengthFactory(this.getClassType());
        bindyFixedLengthFactory.setFormatFactory(formatFactory);
        return bindyFixedLengthFactory;
    }

    @Override
    public void marshal(Exchange exchange, Object graph, OutputStream stream) throws Exception {
        //do nothing
    }

    @Override
    public Object unmarshal(Exchange exchange, InputStream stream) throws Exception {
        return null;
    }

    @Override
    public String getDataFormatName() {
        return null;
    }

    @Override
    public void close() throws IOException {

    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public PackageScanClassResolver getPackageScanClassResolver() {
        return packageScanClassResolver;
    }

    public void setPackageScanClassResolver(PackageScanClassResolver packageScanClassResolver) {
        this.packageScanClassResolver = packageScanClassResolver;
    }

    public BindyAbstractFactory getFixedFactory() {
        return fixedFactory;
    }

    public void setFixedFactory(BindyAbstractFactory fixedFactory) {
        this.fixedFactory = fixedFactory;
    }
}
