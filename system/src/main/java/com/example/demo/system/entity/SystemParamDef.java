package com.example.demo.system.entity;

import com.example.demo.common.core.CommonEntity;

import java.io.Serializable;

/**
 * 系统枚举定义
 * Author :tanjm
 * Date:  2021/7/3
 * Desc:
 */
public class SystemParamDef extends CommonEntity implements Serializable {
    private static final long serialVersionUID = 7220483938573128293L;
    private String key;
    private String value;
    private String desc;
    private Boolean enabled;
    private String remark;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
