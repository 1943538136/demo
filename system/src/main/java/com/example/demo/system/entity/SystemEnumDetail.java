package com.example.demo.system.entity;

import com.example.demo.common.core.CommonEntity;

import java.io.Serializable;

/**
 * 系统枚举值
 * Author :tanjm
 * Date:  2021/7/3
 * Desc:
 * @author tanjm
 */
public class SystemEnumDetail extends CommonEntity implements Serializable {
    private static final long serialVersionUID = 103617291726036943L;
    private String value;
    private String name;
    private String desc;
    private String remark;
    private Long enumId;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getEnumId() {
        return enumId;
    }

    public void setEnumId(Long enumId) {
        this.enumId = enumId;
    }
}
