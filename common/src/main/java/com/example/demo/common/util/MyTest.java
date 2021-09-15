package com.example.demo.common.util;

import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.io.IOException;

/**
 * Author :tanjm
 * Date:  2021/6/23
 * Desc:
 */
public class MyTest {
    public static void main(String[] args) throws IOException {
/*        URL url = new URL("http://url-t.cn/tcn/api?key=qiqii&url=https://www.baidu.com/");
        InputStream in = url.openStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        byte[] bytes = new byte[1024];
        int read = 0;
        while ((read = in.read(bytes)) != -1) {
            out.write(bytes,0,read);
        }

        System.out.println(new String(out.toByteArray(),"utf-8"));*/
        /*

         */
        SCryptPasswordEncoder sCryptPasswordEncoder = new SCryptPasswordEncoder();
        //System.out.println(sCryptPasswordEncoder.encode("abad91e4-9584-58d2-baef-6ca66720d256"));

        System.out.println(sCryptPasswordEncoder.encode("551ba1b3b676594a83eb2e295ede77f1"));
        System.out.println(sCryptPasswordEncoder.encode("0ed8f899de50587db7a74b740bd4c4ff"));
        System.out.println(sCryptPasswordEncoder.encode("1b3676fdac1d5bba9baae1c21c1dde5f"));
        System.out.println(sCryptPasswordEncoder.encode("ccdc2ccff2f351c78e3a0a2b3126ae9f"));
        System.out.println(sCryptPasswordEncoder.encode("d138572ab15b5d808ad835a2757524f6"));
        System.out.println(sCryptPasswordEncoder.encode("44354855dc2f5a0f85301c97c67e3136"));
        System.out.println(sCryptPasswordEncoder.encode("175c55f3cc795209add8ed6143120670"));
        System.out.println(sCryptPasswordEncoder.encode("85ec66d603ea5b669bdf3a198b2900c1"));
        System.out.println(sCryptPasswordEncoder.encode("b81be042dca050b78496c17b7794af4a"));
        System.out.println(sCryptPasswordEncoder.encode("59e2ff59152f5a1685fdebf399619c21"));
    }
}
