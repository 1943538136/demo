package com.example.demo.account.controller;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.authserver.AuthorizationServerProperties;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

/**
 * Author :tanjm
 * Date:  2021/6/7
 * Desc:
 */
@RestController
public class OtherController {
    private static final Logger logger = LoggerFactory.getLogger(OtherController.class);

    @Autowired
    private KeyPair keyPair;

    @ResponseBody
    @GetMapping(value = {"", "/", "/index"})
    public String index(HttpServletRequest request, HttpServletResponse response) {
        logger.info("index");
        return "index" + request.getRemoteUser();
    }

/*    @GetMapping("/")
    public String index(@AuthenticationPrincipal AuthorizationServerProperties.Jwt jwt) {
        return String.format("Hello, %s!", jwt.);
    }*/

    @GetMapping("/message")
    public String message() {
        return "secret message";
    }

    @PostMapping("/message")
    public String createMessage(@RequestBody String message) {
        return String.format("Message was created. Content: %s", message);
    }

    @GetMapping("/.well-known/jwks.json")
    public Map<String, Object> getKey() {
        RSAPublicKey publicKey = (RSAPublicKey) this.keyPair.getPublic();
        RSAKey key = new RSAKey.Builder(publicKey).build();
        return new JWKSet(key).toJSONObject();
    }
}
