package com.example.demo.system.entity;

import com.example.demo.common.core.CommonEntity;

import java.io.Serializable;

/**
 * 系统菜单定义
 * Author :tanjm
 * Date:  2021/7/3
 * Desc:
 */
public class SystemMenuDef extends CommonEntity implements Serializable {
    private static final long serialVersionUID = 5941874578277285886L;
    private String code;
    private String name;
    private String icon;
    private String navUrl;
    private String auth;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getNavUrl() {
        return navUrl;
    }

    public void setNavUrl(String navUrl) {
        this.navUrl = navUrl;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
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
