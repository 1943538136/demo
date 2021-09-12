package com.example.demo.common.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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

    private static final Pattern pattern = Pattern.compile("^(\\d{4}-\\d{1,2}-\\d{1,2}) (\\d{1,2}:\\d{1,2}:\\d{1,2}.\\d{1,3}) (\\[[A-Za-z0-9-\\.:]{0,}\\]) ([A-Z]{1,5}) ([A-Za-z0-9._]{0,})(.{0,})$");

    public static void main(String[] args) throws IOException {
        //String s="";
        String filePath = "C:\\Users\\tanjm\\Desktop\\日志\\debug-order-service-provider-2021-08-25.456.log";
        List<String> logs = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String lineTxt = null;
                while ((lineTxt = br.readLine()) != null) {
                    logs.add(lineTxt);
                }
                br.close();
            } else {
                System.out.println("文件不存在!");
            }
        } catch (Exception e) {
            System.out.println("文件读取错误!");
        }
        // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
        FileWriter writer = new FileWriter("C:\\Users\\tanjm\\Desktop\\日志\\debug-order-service-provider-2021-08-25.456.sql", true);
        List<LogRow> logRows = new ArrayList<>();
        //writer.write("INSERT INTO table1(date, time, thread, level, clazz, content) VALUES");
        for (String log : logs) {
            Matcher matcher = pattern.matcher(log);
            //System.out.println(matcher.matches());
            if (matcher.find()) {
                /*System.out.println(matcher.groupCount());
                System.out.println(matcher.group(0));
                System.out.println(matcher.group(1));
                System.out.println(matcher.group(2));
                System.out.println(matcher.group(3));
                System.out.println(matcher.group(4));
                System.out.println(matcher.group(5));
                System.out.println(matcher.group(6));*/
                LogRow logRow = new LogRow();
                logRow.setDate(matcher.group(1));
                logRow.setTime(matcher.group(2));
                logRow.setThread(matcher.group(3));
                logRow.setLevel(matcher.group(4));
                logRow.setClazz(matcher.group(5));
                logRow.setContent(matcher.group(6));
                logRows.add(logRow);

                try {

                    writer.write("INSERT INTO table1(date, time, thread, level, clazz, content) VALUES('"+matcher.group(1)+"','"+matcher.group(2)+"','"+matcher.group(3)+"','"+matcher.group(4)+"','"+matcher.group(5)+"','"+matcher.group(6).replace("'","\\'")+"');\n\r");
                    //writer.write(content);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        writer.close();
        System.out.println(logRows.size());
    }

    public static class LogRow {
        private String date;
        private String time;
        private String thread;
        private String level;
        private String clazz;
        private String content;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getThread() {
            return thread;
        }

        public void setThread(String thread) {
            this.thread = thread;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getClazz() {
            return clazz;
        }

        public void setClazz(String clazz) {
            this.clazz = clazz;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
