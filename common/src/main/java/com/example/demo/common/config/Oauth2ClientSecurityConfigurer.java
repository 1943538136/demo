package com.example.demo.common.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Author :tanjm
 * Date:  2021/6/8
 * Desc:
 */
@Configuration
@EnableOAuth2Sso
@EnableWebSecurity
@EnableResourceServer
public class Oauth2ClientSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        //http.addFilterAfter(new TokenFilter(), FilterSecurityInterceptor.class);
        //http.addFilterBefore(new TokenFilter(), FilterSecurityInterceptor.class);
        http
                .authorizeRequests().anyRequest().authenticated().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)

        ;

        // @formatter:on
    }
}
