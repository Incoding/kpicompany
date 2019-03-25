package com.kpicompany.report.convertor.jackson;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.*;
import org.codehaus.jackson.map.deser.CustomDeserializerFactory;
import org.codehaus.jackson.map.deser.StdDeserializerProvider;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 2019/3/23
 * 解决 jackson Date类型输入输出问题
 */
@Component
public class CustomerObjectMapper extends ObjectMapper {

    private Logger logger = LoggerFactory.getLogger(CustomerObjectMapper.class);

    public CustomerObjectMapper() {
        CustomSerializerFactory factory = new CustomSerializerFactory();
        factory.addGenericMapping(Date.class, new JsonSerializer<Date>() {
            @Override
            public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                jsonGenerator.writeString(sdf.format(date));
            }
        });
        CustomDeserializerFactory deserializerFactory = new CustomDeserializerFactory();
        deserializerFactory.addSpecificMapping(Date.class, new JsonDeserializer<Date>() {
            @Override
            public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date parse = null;
                String text = jsonParser.getText();
                try {
                    parse = sdf.parse(text);
                } catch (ParseException e) {
                    logger.error("不能反序列化input={}",text);
                }
                return parse;
            }
        });
        StdDeserializerProvider deserializerProvider = new StdDeserializerProvider(deserializerFactory);
        this.setDeserializerProvider(deserializerProvider);
        this.setSerializerFactory(factory);
    }
}