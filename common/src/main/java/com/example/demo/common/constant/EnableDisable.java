package com.example.demo.common.constant;

import com.example.demo.common.annotation.EnumDictDef;

/**
 * Author :tanjm
 * Date:  2021/6/22
 * Desc:
 */
@EnumDictDef(enumKey = DictDefKey.KEY_ENABLE_DISABLE, valueField = "value", textField = "text")
public enum EnableDisable {
    ENABLE(1, "启用"),
    DISABLE(2, "禁用");
    private int value;
    private String text;

    EnableDisable(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}