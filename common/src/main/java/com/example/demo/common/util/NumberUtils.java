package com.example.demo.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author :tanjm
 * Date:  2021/6/8
 * Desc:
 */
public class NumberUtils {
    private static final Logger logger = LoggerFactory.getLogger(NumberUtils.class);
    private static final Object lockObj = new Object();

    private static ConcurrentHashMap<String, ThreadLocal<DecimalFormat>> sdfMap = new ConcurrentHashMap<>();

    public static String format(Double value, String pattern) {
        if (null == value) {
            return null;
        }
        if (null == pattern || "".equals(pattern.trim())) {
            return value.toString();
        }
        DecimalFormat decimalFormat = getDecimalFormat(pattern);
        return decimalFormat.format(value);
    }

    public static String format(BigDecimal value, int scale) {
        if (null == value) {
            return null;
        }
        DecimalFormat decimalFormat = getDecimalFormat(getPattern(scale));

        return decimalFormat.format(value);
    }

    private static String getPattern(int scale) {
        switch (scale) {
            case 0:
                return "#";
            case 1:
                return "#.0";
            case 2:
                return "#.00";
            case 3:
                return "#.000";
            case 4:
                return "#.0000";
            case 5:
                return "#.00000";
            default:
                StringBuffer stringBuffer = new StringBuffer("#");
                stringBuffer.append(".");
                for (int i = 0; i < scale; i++) {
                    stringBuffer.append("0");
                }
                return stringBuffer.toString();
        }

    }

    private static DecimalFormat getDecimalFormat(final String pattern) {
        ThreadLocal<DecimalFormat> tl = sdfMap.get(pattern);

        // 此处的双重判断和同步是为了防止sdfMap这个单例被多次put重复的sdf
        if (tl == null) {
            synchronized (lockObj) {
                tl = sdfMap.get(pattern);
                if (tl == null) {
                    // 只有Map中还没有这个pattern的sdf才会生成新的sdf并放入map
                    //System.out.println("put new sdf of pattern " + pattern + " to map");
                    // 这里是关键,使用ThreadLocal<SimpleDateFormat>替代原来直接new SimpleDateFormat
                    tl = ThreadLocal.withInitial(() -> {
                        logger.debug("thread: {} init pattern:{}", Thread.currentThread(), pattern);
                        return new DecimalFormat(pattern);
                    });
                    sdfMap.put(pattern, tl);
                }
            }
        }
        return tl.get();
    }

/*    public static void main(String[] args) {
        System.out.println(format(new BigDecimal("5569820.012555369"), 5));
    }*/
}
