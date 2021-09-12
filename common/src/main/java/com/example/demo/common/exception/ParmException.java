package com.example.demo.common.exception;

/**
 * 请求参数异常，应用层校验异常。
 * 异常返回码->>200
 * <p>
 * 1、请求参数为空或缺失，如：ID为Null；
 * 2、参数范围错误，如：ID为负值；
 * </p>
 * Author :tanjm
 * Date:  2021/6/22
 * Desc:
 */
public class ParmException extends AbstractException {

    public ParmException() {
    }

    public ParmException(Integer errcode, String errmsg) {
        super(errcode, errmsg);
    }
}
