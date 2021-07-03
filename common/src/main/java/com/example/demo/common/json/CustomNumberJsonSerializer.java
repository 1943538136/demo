package com.example.demo.common.json;

import com.example.demo.common.annotation.JacksonExpand;
import com.example.demo.common.util.NumberUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.apache.commons.lang3.StringUtils;
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
public class CustomNumberJsonSerializer extends JsonSerializer<Number> {
    private static final Logger logger = LoggerFactory.getLogger(CustomNumberJsonSerializer.class);

    @Override
    public void serialize(Number value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        JsonStreamContext outputContext = gen.getOutputContext();
        Object currentValue = outputContext.getCurrentValue();
        // 这里获取了序列化的属性
        String currentName = outputContext.getCurrentName();
        if (value != null) {
            Field findField = ReflectionUtils.findField(currentValue.getClass(), currentName);
            findField.setAccessible(true);
            // 设置age的值，必须指明修改的是哪个对象的属性
            JacksonExpand jacksonExpand = findField.getAnnotation(JacksonExpand.class);
            if (null != jacksonExpand) {
                //Class enumClass = resExpandFormat.enumClass();
                String pattern = jacksonExpand.pattern();
                int scale = jacksonExpand.scale();
                if (StringUtils.isNotBlank(pattern)) {
                    gen.writeString(NumberUtils.format(value, pattern));
                } else if (scale > -1) {
                    gen.writeString(NumberUtils.format(value, scale));
                } else {
                    gen.writeObject(value);
                }
            }
        }
    }
}
