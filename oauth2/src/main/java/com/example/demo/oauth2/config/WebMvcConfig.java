package com.example.demo.oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author :tanjm
 * Date:  2021/9/14
 * Desc:
 */
@Configuration
public class WebMvcConfig  {
    @Bean
    public CorsFilter corsFilterBean() {

        //创建CorsConfiguration对象后添加配置
        CorsConfiguration config = new CorsConfiguration();
        //设置放行哪些原始域
        config.addAllowedOrigin("*");
        //放行哪些原始请求头部信息
        config.addAllowedHeader("*");
        //暴露哪些头部信息
        config.addExposedHeader("*");
        //放行哪些请求方式
        //config.addAllowedMethod("GET");     //get
        //config.addAllowedMethod("PUT");     //put
        //config.addAllowedMethod("POST");    //post
        //config.addAllowedMethod("DELETE");  //delete
        config.addAllowedMethod("*");     //放行全部请求

        //是否发送Cookie
        config.setAllowCredentials(true);

        //2. 添加映射路径
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**", config);
        //返回CorsFilter
        return new CorsFilter(corsConfigurationSource){
            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

                //HttpServletResponse response = (HttpServletResponse) res;
                //HttpServletRequest reqs = (HttpServletRequest) req;
                //response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
                //System.out.println(request.getHeader("Origin"));
                response.setHeader("Access-Control-Allow-Origin","*");
                response.setHeader("Access-Control-Allow-Credentials", "true");
                response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
                response.setHeader("Access-Control-Max-Age", "3600");
                response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
                //chain.doFilter(req, res);
                super.doFilterInternal(request, response, filterChain);
            }
        };
    }
}
