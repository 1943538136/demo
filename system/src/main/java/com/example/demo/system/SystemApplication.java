package com.example.demo.system;

import com.example.demo.common.interceptor.FeignClientRequestInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(defaultConfiguration = FeignClientRequestInterceptor.class)
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.example.demo.common", "com.example.demo.system"})
public class SystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }

}
