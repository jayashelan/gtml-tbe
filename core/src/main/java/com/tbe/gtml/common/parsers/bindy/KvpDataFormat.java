package com.tbe.gtml.common.parsers.bindy;

import com.tbe.gtml.common.constants.ErrorCode;
import com.tbe.gtml.common.parsers.serialization.SerDe;
import com.tbe.gtml.common.parsers.serialization.SerDeException;
import org.apache.camel.Exchange;
import org.apache.camel.dataformat.bindy.BindyAbstractDataFormat;
import org.apache.camel.dataformat.bindy.BindyAbstractFactory;
import org.apache.camel.dataformat.bindy.BindyKeyValuePairFactory;
import org.apache.camel.dataformat.bindy.FormatFactory;
import org.apache.camel.spi.PackageScanClassResolver;
import org.apache.camel.util.ObjectHelper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

public class KvpDataFormat<T> extends BindyAbstractDataFormat implements SerDe<T> {

    private String objectType;

    private PackageScanClassResolver packageScanClassResolver;

    private BindyAbstractFactory kvpFactory;

    public KvpDataFormat(Class<T> objectType) throws SerDeException{
        this.setClassType(objectType);
    }

    //Single Entry
    @Override
    public T fromBytes(byte[] bytes) throws SerDeException {

        //Declare
        List<Map<String,Object>> models = new ArrayList<>();

        Map<String,Object> model;

        Scanner scanner  = new Scanner(new String(bytes));

        int count = 0;

        try {
            BindyKeyValuePairFactory factory = (BindyKeyValuePairFactory) getFactory();
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                if (ObjectHelper.isEmpty(line)) {
                    continue;
                }
                count++;
                ObjectHelper.notNull(factory.getPairSeparator(),"The pair separator property of the annotation @Message" );
                String separator = factory.getPairSeparator();
                model = factory.factory();

                List<String> result = Arrays.asList(line.split(separator));

                if (result.isEmpty()){
                    throw new IllegalArgumentException("No records have been defined in the KVP");
                }

                factory.bind(null,result,model,count);

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
    public byte[] toBytes(Object object) throws SerDeException {
        List<Map<String,Object>> models = (ArrayList)object;
        StringBuilder marshalFixMessage = new StringBuilder();
        for (Map<String,Object> model :models){
            try {
                marshalFixMessage.append(getFactory().unbind(null,model));
            }catch (Exception e){
                throw new SerDeException(e, ErrorCode.SERDE_PARSER_EXCEPTION);
            }
        }
        return marshalFixMessage.toString().getBytes();

    }

    @Override
    protected BindyAbstractFactory createModelFactory(FormatFactory formatFactory) throws Exception {
        BindyKeyValuePairFactory bindyKeyValuePairFactory = new BindyKeyValuePairFactory(this.getClassType());
        bindyKeyValuePairFactory.setFormatFactory(formatFactory);
        return bindyKeyValuePairFactory;
    }

    @Override
    public void marshal(Exchange exchange, Object graph, OutputStream stream) throws Exception {

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

    public BindyAbstractFactory getKvpFactory() {
        return kvpFactory;
    }

    public void setKvpFactory(BindyAbstractFactory kvpFactory) {
        this.kvpFactory = kvpFactory;
    }
}
