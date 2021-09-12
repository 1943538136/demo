package com.example.demo.system.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Author :tanjm
 * Date:  2021/9/12
 * Desc:
 */
@Component
@FeignClient(name = "account")
public interface AccountOtherFeignClient {
    @RequestMapping(value =  "/feignClientTest", method = RequestMethod.GET)
    String feignClientTest(String username);
}
