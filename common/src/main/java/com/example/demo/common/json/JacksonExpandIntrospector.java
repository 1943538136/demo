package com.example.demo.common.json;

import com.example.demo.common.annotation.JacksonExpand;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Author :tanjm
 * Date:  2021/5/25
 * Desc:
 */
public class JacksonExpandIntrospector extends JacksonAnnotationIntrospector {
    private static final Logger logger = LoggerFactory.getLogger(JacksonExpandIntrospector.class);
    private static final long serialVersionUID = 4795448858711071877L;
    private static ConcurrentHashMap<String, Object> JSON_SERIALIZER_MAP = new ConcurrentHashMap<>();

    public static final String KEY_CUSTOM_ENUM_JSON_SERIALIZER = "CUSTOM_ENUM_JSON_SERIALIZER";

    static {
        JSON_SERIALIZER_MAP.put(KEY_CUSTOM_ENUM_JSON_SERIALIZER, new CustomEnumJsonSerializer());
    }
    @Override
    public Object findSerializer(Annotated annotated) {
        JacksonExpand jacksonExpand = annotated.getAnnotation(JacksonExpand.class);
        if (jacksonExpand != null) {
            Class<?> enumClass = jacksonExpand.enumClass();
            if (null != enumClass && Enum.class.isAssignableFrom(enumClass)) {
                Object jsonSerializer = JSON_SERIALIZER_MAP.get(KEY_CUSTOM_ENUM_JSON_SERIALIZER);
                if (null != jsonSerializer) {
                    return jsonSerializer;
                }
            }
        }
        return super.findSerializer(annotated);
    }
}
