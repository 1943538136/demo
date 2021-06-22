package com.example.demo.common.annotation;


import com.example.demo.common.constant.JacksonIgnoreEnumExpand;

import java.lang.annotation.*;

/**
 * @author tanjm
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JacksonExpandFormat {
    Class<? extends Enum<?>> enumClass() default JacksonIgnoreEnumExpand.class;
}
