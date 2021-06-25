package com.example.demo.common.json;

import com.example.demo.common.annotation.JacksonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Author :tanjm
 * Date:  2021/5/25
 * Desc:
 */
public class CustomNumberJsonSerializer extends JsonSerializer<Object> {
    private static final Logger logger = LoggerFactory.getLogger(CustomNumberJsonSerializer.class);

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        JsonStreamContext outputContext = gen.getOutputContext();
        Object currentValue = outputContext.getCurrentValue();
        // 这里获取了序列化的属性
        String currentName = outputContext.getCurrentName();
        if (value != null) {
            Field findField = ReflectionUtils.findField(currentValue.getClass(), currentName);
            findField.setAccessible(true);
            // 设置age的值，必须指明修改的是哪个对象的属性
            JacksonFormat jacksonFormat = findField.getAnnotation(JacksonFormat.class);
            if (null != jacksonFormat) {
                //Class enumClass = resExpandFormat.enumClass();

                //gen.writeStringField(currentName + "OfText", null != enumText ? enumText : "");
            }
        }
    }
}
