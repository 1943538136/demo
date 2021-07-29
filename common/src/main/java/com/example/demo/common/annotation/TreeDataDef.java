package com.example.demo.common.annotation;

/**
 * Tree结构数据定义
 * @author tanjm
 */
public @interface TreeDataDef {
    boolean isKey() default false;
    boolean isUpperKey() default false;
}
