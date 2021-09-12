package com.example.demo.common.constant;

/**
 * Author :tanjm
 * Date:  2021/9/11
 * Desc:
 */
public enum SystemIDEnum {
    SYSTEM("01", "SYSTEM"),
    ACCOUNT("02", "ACCOUNT");
    private String code;
    private String name;

    SystemIDEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

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
}
