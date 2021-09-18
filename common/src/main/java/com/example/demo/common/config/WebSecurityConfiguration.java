package com.example.demo.common.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

/**
 * Author :tanjm
 * Date:  2021/9/17
 * Desc:
 */
@Configuration
@EnableWebSecurity
@ConditionalOnMissingBean({WebSecurityConfigurerAdapter.class})
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Bean
    @ConditionalOnMissingBean({PasswordEncoder.class})
    public PasswordEncoder scryptPasswordEncoderBean() {
        return new SCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER).and()
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                .authorizeRequests()
                .antMatchers("/swagger-ui.html", "/webjars/**", "/v2/**", "/swagger-resources/**").permitAll()
                .antMatchers("/actuator/**").permitAll()
                .anyRequest().authenticated().and()
        ;
    }
}
