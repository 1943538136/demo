package com.example.demo.common.util;

import com.example.demo.common.annotation.EnumDictDef;
import com.example.demo.common.constant.YesNoEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Author :tanjm
 * Date:  2021/6/8
 * Desc:
 */
public class EnumUtils {
    private static final Logger logger = LoggerFactory.getLogger(EnumUtils.class);

    public static <T extends Enum<T>> String getText(Class<T> enumType, Integer value) {
        T instance=valueOf(enumType,value);
        if(null!=instance){
            EnumDictDef enumDictDef = enumType.getDeclaredAnnotation(EnumDictDef.class);
            Method method = getReadMethod(enumType, enumDictDef.textField());
            try {
                return (String) method.invoke(instance,null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static <T extends Enum<T>> T valueOf(Class<T> enumType, Integer value) {
        if (null == enumType) {
            logger.warn("Enum class type is empty, please check!!!");
            return null;
        }
        if (null == value) {
            logger.warn("Enum value is empty, please check!!!");
            return null;
        }
        EnumDictDef enumDictDef = enumType.getDeclaredAnnotation(EnumDictDef.class);
        if (null == enumDictDef) {
            logger.warn("No EnumDictDef found, please check!!!");
            return null;
        }
        Method method = getReadMethod(enumType, enumDictDef.valueField());

        if (null != enumType && null != enumType) {
            T[] enumArray = enumType.getEnumConstants();
            for (T _enum : enumArray) {
                try {
                    Integer v = (Integer) method.invoke(_enum, null);
                    if (null != v && v.intValue() == value.intValue()) {
                        return _enum;
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    //Method readMethod
    private static Method getReadMethod(Class clazz, String propertyName) {
        try {
            PropertyDescriptor descriptor = new PropertyDescriptor(propertyName, clazz);
            return descriptor.getReadMethod();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return null;
    }

/*    public static void main(String[] args) {
        //EnumUtils.valueOf(EnumYesNo.class, 1);
        System.out.println(EnumUtils.getText(YesNoEnum.class, 1));
        System.out.println(EnumUtils.getText(YesNoEnum.class, 2));
        System.out.println(EnumUtils.getText(YesNoEnum.class, 3));
        //System.out.println(EnumUtils.getReadMethod(EnumYesNo.class,"value"));
    }*/
}
