package com.example.demo.account;

import com.example.demo.common.config.Oauth2ClientSecurityConfigurer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@MapperScan("com.example.demo.account.mapper")
@SpringBootApplication(scanBasePackages = {"com.example.demo.common", "com.example.demo.account"})
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {Oauth2ClientSecurityConfigurer.class})})
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }

}
