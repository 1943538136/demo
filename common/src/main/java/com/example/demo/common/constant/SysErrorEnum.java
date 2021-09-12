package com.example.demo.common.constant;

/**
 * Author :tanjm
 * Date:  2021/6/22
 * Desc:
 */
public enum SysErrorEnum implements SysError {
    SUCCESS(0, "成功！"),
    SYS_ERROR(-1, "系统繁忙,请稍后重试！");
    private Integer errcode;
    private String errmsg;

    SysErrorEnum(Integer errcode, String errmsg) {
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    @Override
    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    @Override
    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
