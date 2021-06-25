package com.example.demo.common.annotation;


import com.example.demo.common.constant.IgnoreEnum;

import java.lang.annotation.*;

/**
 * @author tanjm
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JacksonFormat {
    Class<? extends Enum<?>> enumClass() default IgnoreEnum.class;
}
