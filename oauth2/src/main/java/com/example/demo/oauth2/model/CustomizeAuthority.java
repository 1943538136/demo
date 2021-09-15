package com.example.demo.oauth2.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

/**
 * Author :tanjm
 * Date:  2021/6/29
 * Desc:
 */
public class CustomizeAuthority implements GrantedAuthority, Serializable {
    private static final Logger logger = LoggerFactory.getLogger(CustomizeAuthority.class);
    private static final long serialVersionUID = 3441323484583301308L;
    private String authority;
    public CustomizeAuthority(String authority){
        this.authority=authority;
    }
    @Override
    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
