package com.example.demo.system.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Author :tanjm
 * Date:  2021/9/12
 * Desc:
 */
@Component
@FeignClient("account")
public interface AccountOtherFeignClient {
    @GetMapping(value = {"", "/", "/index"})
    String index();
}
