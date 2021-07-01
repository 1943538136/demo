package com.example.demo.common.config;

import com.example.demo.common.core.CustomizeJwtTokenStore;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.annotation.Resource;

/**
 * Author :tanjm
 * Date:  2021/6/8
 * Desc:
 */
@Order(1)
@Configuration
@EnableWebSecurity
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    //@Resource
    //private JwtTokenStore jwtTokenStore;
    @Bean
    public JwtTokenStore jwtTokenStoreBean() {
        return new CustomizeJwtTokenStore(jwtAccessTokenConverterBean());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverterBean() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey("cjs");
        return jwtAccessTokenConverter;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http

                .authorizeRequests()
                .antMatchers("/swagger-ui.html", "/webjars/**", "/v2/**", "/swagger-resources/**").permitAll()
                .anyRequest().authenticated().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                //.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                //.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
        ;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        super.configure(resources);
        resources.tokenStore(jwtTokenStoreBean());
    }
}
