package com.example.demo.common.json;

import com.example.demo.common.annotation.JacksonExpand;
import com.example.demo.common.util.EnumUtils;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Author :tanjm
 * Date:  2021/5/25
 * Desc:
 */
public class CustomEnumJsonSerializer extends JsonSerializer<Object> {
    private static final Logger logger = LoggerFactory.getLogger(CustomEnumJsonSerializer.class);

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        JsonStreamContext outputContext = gen.getOutputContext();
        Object currentValue = outputContext.getCurrentValue();
        // 这里获取了序列化的属性
        String currentName = outputContext.getCurrentName();
        //boolean isNumber = false;
        if (value instanceof Integer) {
            gen.writeNumber((Integer) value);
        } else if (value instanceof String) {
            gen.writeString((String) value);
        } else {
            gen.writeObject(value);
        }
        if (value != null) {
            Field findField = ReflectionUtils.findField(currentValue.getClass(), currentName);
            findField.setAccessible(true);
            // 设置age的值，必须指明修改的是哪个对象的属性
            JacksonExpand resExpandFormat = findField.getAnnotation(JacksonExpand.class);
            if (null != resExpandFormat) {
                Class enumClass = resExpandFormat.enumClass();
                String enumText = "";
                if (Enum.class.isAssignableFrom(enumClass)) {
                    if (value instanceof Integer) {
                        enumText = EnumUtils.getText(enumClass, (Integer) value);
                    } else if (value instanceof String) {
                        final String v = (String) value;
                        if (null != v && !"".equals(v.trim())) {
                            List<Integer> vList = new ArrayList<>();
                            List<String> tList = new ArrayList<>();
                            //逗号分隔
                            boolean commaSeparated = false;
                            //单竖线分隔
                            boolean verticalLineSeparation = false;
                            if (v.indexOf("|") > -1) {
                                commaSeparated = true;
                            } else if (v.indexOf(",") > -1) {
                                verticalLineSeparation = true;
                            }
                            if (commaSeparated || verticalLineSeparation) {
                                String[] vArray = v.split(commaSeparated ? "\\|" : verticalLineSeparation ? "," : "");
                                if (null != vArray && vArray.length > 0) {
                                    for (String _v : vArray) {
                                        if (null != _v && !"".equals(_v.trim())) {
                                            try {
                                                vList.add(Integer.valueOf(_v));
                                            } catch (Exception e) {
                                                logger.error(e.getMessage(), e);
                                            }
                                        }
                                    }
                                }
                            }

                            if (null != vList && !vList.isEmpty()) {
                                for (Integer _v : vList) {
                                    String text = EnumUtils.getText(enumClass, _v);
                                    if (StringUtils.isNotBlank(text)) {
                                        tList.add(text);
                                    }
                                }
                            }

                            if (null != tList && !tList.isEmpty()) {
                                enumText = StringUtils.join(tList, "、");
                            }
                        }

                    }
                }
                gen.writeStringField(currentName + "OfText", null != enumText ? enumText : "");
            }
        }
    }
}
