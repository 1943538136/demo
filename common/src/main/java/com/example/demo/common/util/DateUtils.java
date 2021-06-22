package com.example.demo.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author :tanjm
 * Date:  2021/6/8
 * Desc:
 */
public class DateUtils {
    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);
    private static final Object lockObj = new Object();

    private static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> sdfMap = new ConcurrentHashMap<>();

    public static final String YEAR = "yyyy";

    public static final String MONTH = "yyyy-MM";

    public static final String SHORT_TIME = "yyyy-MM-dd";

    public static final String MID_TIME = "yyyy-MM-dd HH:mm";

    public static final String LONG_TIME = "yyyy-MM-dd HH:mm:ss";

    public static final String LONG_TIME_ZERO = "yyyy-MM-dd 00:00:00";


    public static final String LONG_TIME_END = "yyyy-MM-dd 23:59:59";

    public static final String FIRST_DAY = "yyyy-MM-01";


    public static String format(Date date, String pattern) {
        if (null == date) {
            return null;
        }
        if (null == pattern || "".equals(pattern.trim())) {
            return null;
        }
        SimpleDateFormat df = getSimpleDateFormat(pattern);
        return df.format(date);
    }

    public static String format(String pattern) {
        return format(LocalDateTime.now(), pattern);
    }

    public static String format(Date date) {
        return format(date, LONG_TIME);
    }

    public static String format() {
        return format(LocalDateTime.now(), LONG_TIME);
    }

    public static String format(LocalDateTime localDateTime, String pattern) {
        if (null == localDateTime) {
            return null;
        }
        if (null == pattern || "".equals(pattern.trim())) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(formatter);
    }

    private static SimpleDateFormat getSimpleDateFormat(final String pattern) {
        ThreadLocal<SimpleDateFormat> tl = sdfMap.get(pattern);
        // 此处的双重判断和同步是为了防止sdfMap这个单例被多次put重复的sdf
        if (tl == null) {
            synchronized (lockObj) {
                tl = sdfMap.get(pattern);
                if (tl == null) {
                    // 只有Map中还没有这个pattern的sdf才会生成新的sdf并放入map
                    //System.out.println("put new sdf of pattern " + pattern + " to map");
                    // 这里是关键,使用ThreadLocal<SimpleDateFormat>替代原来直接new SimpleDateFormat
                    tl = ThreadLocal.withInitial(() -> {
                        logger.debug("thread: {} init pattern:{}" , Thread.currentThread(),pattern);
                        return new SimpleDateFormat(pattern);
                    });
                    sdfMap.put(pattern, tl);
                }
            }
        }
        return tl.get();
    }
}
