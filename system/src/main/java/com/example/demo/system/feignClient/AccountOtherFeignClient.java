package com.example.demo.system.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Author :tanjm
 * Date:  2021/9/12
 * Desc:
 */
@FeignClient(name = "account")
public interface AccountOtherFeignClient {
    @RequestMapping(value =  "/feignClientTest", method = RequestMethod.GET)
    String feignClientTest(String username);
}
