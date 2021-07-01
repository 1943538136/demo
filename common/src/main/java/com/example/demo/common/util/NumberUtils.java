package com.example.demo.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

    private static final int DEFAULT_SCALE = 6;
    private static final RoundingMode DEFAULT_ROUNDING_MODE = RoundingMode.HALF_UP;


    private static ConcurrentHashMap<String, ThreadLocal<DecimalFormat>> sdfMap = new ConcurrentHashMap<>();

    public static <T extends Number> String format(T value, String pattern) {
        if (null == value) {
            return null;
        }
        if (null == pattern || "".equals(pattern.trim())) {
            return value.toString();
        }
        DecimalFormat decimalFormat = getDecimalFormat(pattern);
        return decimalFormat.format(value);
    }

/*    public static String format(Double value, String pattern) {
        if (null == value) {
            return null;
        }
        if (null == pattern || "".equals(pattern.trim())) {
            return value.toString();
        }
        DecimalFormat decimalFormat = getDecimalFormat(pattern);
        return decimalFormat.format(value);
    }*/

    public static <T extends Number> String format(T value, int scale) {
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
            case 6:
                return "#.000000";
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


    //加法 add
    public static <T extends Number> T add(T... addends) {
        return add(false, DEFAULT_SCALE, DEFAULT_ROUNDING_MODE, addends);
    }

    public static <T extends Number> T addIgnoreNull(T... addends) {
        return add(true, DEFAULT_SCALE, DEFAULT_ROUNDING_MODE, addends);
    }

    public static <T extends Number> T add(Integer scale, T... addends) {
        return add(false, scale, DEFAULT_ROUNDING_MODE, addends);
    }

    public static <T extends Number> T addIgnoreNull(Integer scale, T... addends) {
        return add(true, scale, DEFAULT_ROUNDING_MODE, addends);
    }


    public static <T extends Number> T add(boolean ignoreNull, Integer scale, RoundingMode roundingMode, T... addends) {
        if (null == addends && !ignoreNull) {
            return null;
        }
        if (null == scale) {
            scale = DEFAULT_SCALE;
        }
        Class clazz = null;
        BigDecimal result = new BigDecimal("0");
        if (null != addends && addends.length > 0) {
            for (T addend : addends) {
                if (null == clazz) {
                    clazz = addend.getClass();
                }
                if (null != addend) {
                    result = result.add(new BigDecimal(addend.toString()));
                } else {
                    if (!ignoreNull) {
                        return null;
                    }
                }
            }
        }
        result = result.setScale(scale, roundingMode);
        return (T) transformNumberType(clazz, result);
    }

    //减法：subtract()
    public static <T extends Number> T subtract(boolean ignoreNull, int scale, RoundingMode roundingMode, T minute, T... minus) {
        if (null == minute && !ignoreNull) {
            return null;
        } else if (null == minus && !ignoreNull) {
            return null;
        }
        BigDecimal result = new BigDecimal("0");
        if (null != minute) {
            result = result.add(new BigDecimal(minute.toString()));
        } else {
            if (!ignoreNull) {
                return null;
            }
        }
        if (null != minus && minus.length > 0) {
            for (T minu : minus) {
                if (null != minu) {
                    result = result.subtract(new BigDecimal(minu.toString()));
                } else {
                    if (!ignoreNull) {
                        return null;
                    }
                }
            }
        }
        result = result.setScale(scale, roundingMode);
        return (T) transformNumberType(minute.getClass(), result);
    }

    //乘法：multiply()函数
    public static <T extends Number> T multiply(boolean ignoreNull, int scale, RoundingMode roundingMode, T... values) {
        if (null == values && !ignoreNull) {
            return null;
        }
        BigDecimal result = new BigDecimal("0");
        Class clazz = null;
        if (null != values && values.length > 0) {
            for (T value : values) {
                if (null != clazz) {
                    clazz = value.getClass();
                }
                if (null != value) {
                    result = result.multiply(new BigDecimal(value.toString()));
                } else {
                    if (!ignoreNull) {
                        return null;
                    }
                }
            }
        }
        result = result.setScale(scale, roundingMode);
        return (T) transformNumberType(clazz, result);
    }

    //除法：divide()函数
    public static <T extends Number> T divide(boolean ignoreNull, int scale, RoundingMode roundingMode, T dividend, T... divisor) {
        if (null == dividend && !ignoreNull) {
            return null;
        } else if (null == divisor && !ignoreNull) {
            return null;
        }
        BigDecimal result = new BigDecimal("0");
        result.setScale(scale);

        if (null != dividend) {
            result = result.add(new BigDecimal(dividend.toString()));
        } else {
            if (!ignoreNull) {
                return null;
            }
        }

        if (null != divisor && divisor.length > 0) {
            for (T value : divisor) {
                if (null != value) {
                    result = result.divide(new BigDecimal(value.toString()));
                } else {
                    if (!ignoreNull) {
                        return null;
                    }
                }
            }
        }
        result = result.setScale(scale, roundingMode);
        return (T) transformNumberType(dividend.getClass(), result);
    }

    //绝对值：abs()函数
    public static <T extends Number> T abs(boolean ignoreNull, int scale, RoundingMode roundingMode, T value) {
        if (null == value && !ignoreNull) {
            return null;
        }
        BigDecimal result = new BigDecimal("0");
        if (null != value) {
            result = result.add(new BigDecimal(value.toString()));
        } else {
            if (!ignoreNull) {
                return null;
            }
        }
        result = result.setScale(scale, roundingMode).abs();
        return (T) transformNumberType(value.getClass(), result);
    }

    private static <T extends Number> T transformNumberType(Class<T> clazz, BigDecimal value) {
        String className = clazz.getName();
        switch (clazz.getName()) {
            case "java.lang.Integer":
                return (T) Integer.valueOf(value.intValue());
            case "java.lang.Long":
                return (T) Long.valueOf(value.longValue());
            case "java.lang.Float":
                return (T) Float.valueOf(value.floatValue());
            case "java.lang.Double":
                return (T) Double.valueOf(value.doubleValue());
            default:
                return (T) value;
        }
    }

    /*public static void main(String[] args) {
        //BigDecimal v = new BigDecimal("5569820.012555369");
        String s1 = "5569820";
        String s2 = "5569820.012555369";
        // BigDecimal b = NumberUtils.add(19, a);
        //Long num = 1L;

        Integer a = NumberUtils.add(true, 6, RoundingMode.HALF_UP, Integer.valueOf(s1));
        Long b = NumberUtils.add(true, 6, RoundingMode.HALF_UP, Long.valueOf(s1));
        Double c = NumberUtils.add(true, 6, RoundingMode.HALF_UP, Double.valueOf(s2));
        Float d = NumberUtils.add(true, 6, RoundingMode.HALF_UP, Float.valueOf(s2));
        BigDecimal e = NumberUtils.add(true, 6, RoundingMode.HALF_UP, new BigDecimal(s2));
        System.out.println(NumberUtils.format(a, 5));
        System.out.println(NumberUtils.format(b, 5));
        System.out.println(NumberUtils.format(c, 5));
        System.out.println(NumberUtils.format(d, 5));
        System.out.println(NumberUtils.format(e, 26));
    }*/
}
