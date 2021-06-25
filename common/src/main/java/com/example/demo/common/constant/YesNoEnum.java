package com.example.demo.common.constant;

import com.example.demo.common.annotation.EnumDictDef;

/**
 * Author :tanjm
 * Date:  2021/6/9
 * Desc:
 */
@EnumDictDef(enumKey = DictDefKey.KEY_YES_NO, valueField = "value", textField = "text")
public enum YesNoEnum {
    YES(1, "是"),
    NO(2, "否");
    private int value;
    private String text;

    YesNoEnum(int value, String text) {
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
