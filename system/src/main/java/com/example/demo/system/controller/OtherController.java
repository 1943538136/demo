package com.example.demo.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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

    //@RolesAllowed({ "USER"})
    @ResponseBody
    @GetMapping(value = {"", "/", "/index"})
    public String index(HttpServletRequest request, HttpServletResponse response) {
        logger.info("index");
        return "index -->>"+request.getRemoteUser();
    }
}
