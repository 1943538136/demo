package com.example.demo.common.core;

import com.example.demo.common.constant.SysError;

import java.io.Serializable;

/**
 * Author :tanjm
 * Date:  2021/6/22
 * Desc:
 *
 * @author tanjm
 */
public class ResponseData<T> implements Serializable {
    private static final long serialVersionUID = -2901595145147318555L;
    private Integer errcode;
    private String errmsg;
    private T data;

    public ResponseData() {
    }

    public ResponseData(Integer errcode, String errmsg) {
        this(errcode, errmsg, null);
    }

    public ResponseData(SysError error) {
        this(error, null);
    }

    public ResponseData(SysError error, T data) {
        this(error.getErrcode(), error.getErrmsg(), data);
    }

    public ResponseData(Integer errcode, String errmsg, T data) {
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.data = data;
    }

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

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
