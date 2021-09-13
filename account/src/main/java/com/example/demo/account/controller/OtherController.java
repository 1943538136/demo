package com.example.demo.account.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author :tanjm
 * Date:  2021/6/7
 * Desc:
 */
@RestController
public class OtherController {
    private static final Logger logger = LoggerFactory.getLogger(OtherController.class);

    public static final String A="ROLE_USER_ADMIN";

    /**
     *
     * @param request
     * @param response
     * @return
     */
    //@PreAuthorize 权限必须带前缀
    //@PreAuthorize(hasRole(A))
    //DenyAll
    //PermitAll
    @RolesAllowed(A)
    @GetMapping(value = {"", "/", "/index"})
    public String index(HttpServletRequest request, HttpServletResponse response) {
        logger.info("index");
        return "index" + request.getRemoteUser();
    }

    @GetMapping("/message")
    public String message() {
        return "secret message";
    }

    @PostMapping("/message")
    public String createMessage(@RequestBody String message) {
        return String.format("Message was created. Content: %s", message);
    }

    @RequestMapping(value = "/feignClientTest", method = RequestMethod.POST)
    public String feignClientTest(String username) {
        return username + " -->> feignClientTest";
    }
}
