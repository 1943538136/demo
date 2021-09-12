package com.example.demo.common.aspect;

import com.example.demo.common.util.JsonUtils;
import com.example.demo.common.util.RegexUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 请求日志
 */
@Aspect
@Component
public class RequestLoggerAspect {
    private static final Logger logger = LoggerFactory.getLogger(RequestLoggerAspect.class);
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void pointcutGetMapping() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    private void pointcutPostMapping() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PutMapping)")
    private void pointcutPutMapping() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    private void pointcutDeleteMapping() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    private void pointcutRequestMapping() {
    }

    @Before("pointcutGetMapping()||pointcutPostMapping()||pointcutPutMapping()||pointcutDeleteMapping()||pointcutRequestMapping()")
    public void doBeforeRequest(JoinPoint joinPoint) {
        try {
            Object[] args = joinPoint.getArgs();
            //这个RequestContextHolder是Springmvc提供来获得请求的东西
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            StringBuffer loggerStringBuffer = new StringBuffer();
            if (request.getParameterMap().size() > 0) {
                Enumeration<String> parameterNames = request.getParameterNames();
                Map<String, Object> map = new HashMap<>(64);
                while (parameterNames.hasMoreElements()) {
                    //参数名
                    String key = parameterNames.nextElement();
                    if (null != key && "access_token".equalsIgnoreCase(key.trim())) {
                        //忽略access_token真实参数
                        map.put(key, "${ACCESS_TOKEN}");
                        continue;
                    } else if (null != key && "refresh_token".equalsIgnoreCase(key.trim())) {
                        //忽略refresh_token真实参数
                        map.put(key, "${REFRESH_TOKEN}");
                        continue;
                    } else {
                        //值
                        String[] values = request.getParameterValues(key);
                        if (values != null && values.length == 1) {
                            map.put(key, values[0]);
                        } else {
                            map.put(key, values);
                        }
                    }
                }
                loggerStringBuffer.append(" Parms[").append(JsonUtils.writeAsString(map)).append("]");
            }
            for (Object obj : args) {
                if (obj instanceof ServletRequest) {
                    continue;
                }
                if (obj instanceof ServletResponse) {
                    continue;
                }
            }
            logger.info("Request:{} ==>> {}{}", request.getMethod(), request.getRequestURL(), loggerStringBuffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Request logging failed, please check!!!");
        }
    }
}
