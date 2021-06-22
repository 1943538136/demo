package com.example.demo.common.annotation;

import java.lang.annotation.*;

/**
 * @author tanjm
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EnumDictDef {
    String enumKey();

    String valueField();

    String textField();

    String enumDesc() default "";
}
