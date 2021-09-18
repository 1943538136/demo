package com.example.demo.oauth2.config;

import com.example.demo.oauth2.service.CustomizeUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

/**
 * Author :tanjm
 * Date:  2021/6/7
 * Desc:
 */
@Configuration
@EnableWebSecurity
public class Oauth2SecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomizeUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

   @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http
                .authorizeRequests()
                .antMatchers("/swagger-ui.html", "/webjars/**", "/v2/**", "/swagger-resources/**").permitAll()
                .antMatchers("/actuator/**").permitAll()
                //.antMatchers("/oauth/authorize/**").permitAll()
                .antMatchers("/.well-known/jwks.json").permitAll()
//                /.anyRequest().authenticated().and()
        ;
        super.configure(http);
    }

    @Bean
    public PasswordEncoder scryptPasswordEncoderBean() {
        return new SCryptPasswordEncoder();
    }
}
