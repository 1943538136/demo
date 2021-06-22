package com.example.demo.common.exception;

/**
 * Author :tanjm
 * Date:  2021/6/22
 * Desc:
 */
public class BaseException extends RuntimeException {
    protected Integer errcode;
    protected String errmsg;
    protected Object errdesc;

    public BaseException() {
        this(null, false);
    }

    public BaseException(String msg, boolean writableStackTrace) {
        super(msg, null, false, writableStackTrace);
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

    public Object getErrdesc() {
        return errdesc;
    }

    public void setErrdesc(Object errdesc) {
        this.errdesc = errdesc;
    }
}
