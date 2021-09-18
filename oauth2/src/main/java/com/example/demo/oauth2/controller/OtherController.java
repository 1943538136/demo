package com.example.demo.oauth2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.KeyPair;

/**
 * Author :tanjm
 * Date:  2021/6/7
 * Desc:
 */
@RestController
public class OtherController {
    private static final Logger logger = LoggerFactory.getLogger(OtherController.class);

    //@Autowired
    //private AccountOtherFeignClient accountOtherFeignClient;
    @Autowired
    private KeyPair keyPair;
    //@RolesAllowed({ "USER"})
    @ResponseBody
    @GetMapping(value = {"", "/", "/index"})
    public String index(HttpServletRequest request, HttpServletResponse response) {
        logger.info("index");
        //logger.info(accountOtherFeignClient.feignClientTest(request.getRemoteUser()));
        return "index -->>" + request.getRemoteUser();
    }


/*    @GetMapping("/.well-known/jwks.json")
    @ResponseBody
    public Map<String, Object> getKey() {
        RSAPublicKey publicKey = (RSAPublicKey) this.keyPair.getPublic();
        RSAKey key = new RSAKey.Builder(publicKey).build();
        return new JWKSet(key).toJSONObject();
    }*/
}
