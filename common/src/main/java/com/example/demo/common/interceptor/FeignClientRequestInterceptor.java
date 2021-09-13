package com.example.demo.common.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Author :tanjm
 * Date:  2021/9/13
 * Desc:
 */
public class FeignClientRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        requestTemplate.header("Authorization", request.getHeader("Authorization"));
        //requestTemplate.headers(request.getHeaderNames())
        //Enumeration<String>  headerNames=request.getHeaderNames();
       /* for (Enumeration<String>  headerEnumeration : headerNames) {
            //requestTemplate.header(headerEnumeration.nextElement().)
        }*/
    }
}
