package com.example.demo.common.exception;

import com.example.demo.common.constant.SysError;

/**
 * Author :tanjm
 * Date:  2021/6/22
 * Desc:
 */

public abstract class AbstractException extends RuntimeException {
    protected Integer errcode;
    protected String errmsg;

    public AbstractException() {
    }

    public AbstractException(SysError error) {
        this(error.getErrcode(), error.getErrmsg(), false);
    }

    public AbstractException(Integer errcode, String errmsg) {
        this(errcode, errmsg, false);
    }

    public AbstractException(Integer errcode, String errmsg, boolean writableStackTrace) {
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
