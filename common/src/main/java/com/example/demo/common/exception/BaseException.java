package com.example.demo.common.exception;

import com.example.demo.common.constant.SysError;

/**
 * Author :tanjm
 * Date:  2021/6/22
 * Desc:
 */
public class BaseException extends RuntimeException {
    protected Integer errcode;
    protected String errmsg;

    public BaseException() {
    }

    public BaseException(SysError error) {
        this(error.getErrcode(), error.getErrmsg(), false);
    }

    public BaseException(Integer errcode, String errmsg, boolean writableStackTrace) {
        super(errmsg, null, false, writableStackTrace);
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
