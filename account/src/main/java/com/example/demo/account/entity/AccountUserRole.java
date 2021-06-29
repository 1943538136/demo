package com.example.demo.account.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.demo.common.core.CommonEntity;

import java.io.Serializable;

/**
 * 用户角色关系表
 * Author :tanjm
 * Date:  2021/6/28
 * Desc:
 * @author tanjm
 */
@TableName("account_user_role")
public class AccountUserRole extends CommonEntity implements Serializable {
    private static final long serialVersionUID = 4392418505983501297L;
    private Long userId;
    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
