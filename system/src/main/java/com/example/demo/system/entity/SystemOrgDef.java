package com.example.demo.system.entity;

import com.example.demo.common.core.CommonEntity;

import java.io.Serializable;

/**
 * 系统枚举定义
 * Author :tanjm
 * Date:  2021/7/3
 * Desc:
 */
public class SystemOrgDef extends CommonEntity implements Serializable {
    private static final long serialVersionUID = 2873082915096698401L;
    private String code;
    private String name;
    private String desc;
    private Boolean enabled;
    private String remark;
    private Long upperId;

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

    public Long getUpperId() {
        return upperId;
    }

    public void setUpperId(Long upperId) {
        this.upperId = upperId;
    }
}
