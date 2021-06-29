package com.example.demo.account.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * Author :tanjm
 * Date:  2021/6/8
 * Desc:
 */
@Order(99)
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.authorizeRequests()
                .antMatchers("/swagger-ui.html", "/webjars/**", "/v2/**", "/swagger-resources/**").permitAll().and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .csrf().disable().cors();
    }
}
