package com.example.demo.common.util;

import java.beans.Introspector;
import java.lang.reflect.Method;

import static java.util.Locale.ENGLISH;

/**
 * Author :tanjm
 * Date:  2021/6/9
 * Desc:
 */
public class ClassUtils {
    private static final String GET_PREFIX = "get";
    private static final String SET_PREFIX = "set";
    private static final String IS_PREFIX = "is";

/*    public static Method getReadMethod(Class<?> cls,String propertyName){

        Method readMethod = null;
        String readMethodName="";*/
        //this.readMethodRef.get();
        //if (readMethod == null) {
            //Class<?> cls = getClass0();
           /* if (cls == null || (readMethodName == null && !this.readMethodRef.isSet())) {
                // The read method was explicitly set to null.
                return null;
            }*/
            /*String nextMethodName = GET_PREFIX + capitalize(propertyName);
            if (readMethodName == null) {
                Class<?> type = null;//getPropertyType0();
                if (type == boolean.class || type == null) {
                    readMethodName = IS_PREFIX + capitalize(propertyName);
                } else {
                    readMethodName = nextMethodName;
                }
            }*/

            // Since there can be multiple write methods but only one getter
            // method, find the getter method first so that you know what the
            // property type is.  For booleans, there can be "is" and "get"
            // methods.  If an "is" method exists, this is the official
            // reader method so look for this one first.
            /*readMethod = Introspector.findMethod(cls, readMethodName, 0);
            if ((readMethod == null) && !readMethodName.equals(nextMethodName)) {
                readMethodName = nextMethodName;
                readMethod = Introspector.findMethod(cls, readMethodName, 0);
            }*/
            /*try {
                setReadMethod(readMethod);
            } catch (IntrospectionException ex) {
                // fall
            }*/
        //}
       /* return readMethod;*/
    /*}*/

    /*String getBaseName() {
        return capitalize(getName());
    }*/

    public static String capitalize(String name) {
        if (name == null || name.length() == 0) {
            return name;
        }
        return name.substring(0, 1).toUpperCase(ENGLISH) + name.substring(1);
    }
}
