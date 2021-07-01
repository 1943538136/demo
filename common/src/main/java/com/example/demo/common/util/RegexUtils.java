package com.example.demo.common.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author :tanjm
 * Date:  2021/7/1
 * Desc:
 */
public class RegexUtils {
    private static final String LOCKED = "LOCKED";
    private static final ConcurrentHashMap<String, Pattern> PATTERN_MAP = new ConcurrentHashMap<>();

    public static String getMatchingContent(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            //System.out.println(matcher.groupCount());
            int groupcount = matcher.groupCount();
            for (int i = 0; i <= groupcount; i++) {
                return matcher.group(1);
            }
        }
        return null;
    }

    private static Pattern getPattern(String regex) {
        if (null == regex) {
            return null;
        }
        String key = regex.trim();
        if (PATTERN_MAP.containsKey(key)) {
            return PATTERN_MAP.get(key);
        } else {
            return createPattern(key);
        }
    }

    private static Pattern createPattern(String regex) {
        if (PATTERN_MAP.containsKey(regex)) {
            return PATTERN_MAP.get(regex);
        }
        synchronized (LOCKED) {
            if (PATTERN_MAP.containsKey(regex)) {
                return PATTERN_MAP.get(regex);
            }
            Pattern pattern = Pattern.compile(regex);
            PATTERN_MAP.put(regex, pattern);
            return pattern;
        }
    }
}
