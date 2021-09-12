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
    private Boolean success;
    private Integer errcode;
    private String errmsg;
    private T data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
