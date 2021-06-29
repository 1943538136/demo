package com.example.demo.account.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.demo.common.core.CommonEntity;

import java.io.Serializable;

/**
 * 角色权限关系表
 * Author :tanjm
 * Date:  2021/6/29
 * Desc:
 * @author tanjm
 */
@TableName("account_role_auth")
public class AccountRoleAuth extends CommonEntity implements Serializable {
    private static final long serialVersionUID = 449751940501894536L;
    private Long roleId;
    private Long authId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getAuthId() {
        return authId;
    }

    public void setAuthId(Long authId) {
        this.authId = authId;
    }
}
