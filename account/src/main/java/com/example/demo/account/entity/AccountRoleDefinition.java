package com.example.demo.account.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.demo.common.core.CommonEntity;

import java.io.Serializable;

/**
 * /**
 * 系统角色定义表
 * Author :tanjm
 * Date:  2021/6/29
 * Desc:
 * @author tanjm
 */
@TableName("account_role_def")
public class AccountRoleDefinition extends CommonEntity implements Serializable {
    private static final long serialVersionUID = 449751940501894536L;
    private String code;
    private String name;
    private String desc;
    private Boolean enabled;
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
