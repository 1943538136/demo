package com.example.demo.account.config;

import com.example.demo.account.service.CustomizeUserDetailsService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Author :tanjm
 * Date:  2021/6/7
 * Desc:
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    //@Resource
    //private DataSource dataSource;
    @Autowired
    private CustomizeUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .csrf().disable().cors();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.jdbcAuthentication().dataSource(dataSource);
        auth.userDetailsService(userDetailsService);
        //.inMemoryAuthentication()
        //.withUser("admin").password(bcryptPasswordEncoderBean().encode("admin")).roles("USER","ADMIN");
    }

    @Bean
    public PasswordEncoder bcryptPasswordEncoderBean() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
