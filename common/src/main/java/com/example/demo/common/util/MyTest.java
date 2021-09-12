package com.example.demo.common.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Author :tanjm
 * Date:  2021/6/23
 * Desc:
 */
public class MyTest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://url-t.cn/tcn/api?key=qiqii&url=https://www.baidu.com/");
        InputStream in = url.openStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        byte[] bytes = new byte[1024];
        int read = 0;
        while ((read = in.read(bytes)) != -1) {
            out.write(bytes,0,read);
        }

        System.out.println(new String(out.toByteArray(),"utf-8"));
    }
}
