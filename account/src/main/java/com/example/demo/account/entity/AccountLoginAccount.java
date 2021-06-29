package com.example.demo.account.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.demo.common.core.CommonEntity;

import java.io.Serializable;

/**
 * 登录账户及密码
 * Author :tanjm
 * Date:  2021/6/28
 * Desc:
 * @author tanjm
 */
@TableName("account_login_account")
public class AccountLoginAccount extends CommonEntity implements Serializable {
    private static final long serialVersionUID = -6432396760895990616L;
    private String username;
    private String password;
    private Boolean enabled;
    private Long userId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
