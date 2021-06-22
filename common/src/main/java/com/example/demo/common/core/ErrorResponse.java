package com.example.demo.common.core;

import com.example.demo.common.constant.SysErrorConstants;

import java.io.Serializable;

/**
 * Author :tanjm
 * Date:  2021/6/22
 * Desc:
 * @author tanjm
 */
public class ErrorResponse implements Serializable {
    protected Integer errcode;
    protected String errmsg;
    protected Object errdesc;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
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
