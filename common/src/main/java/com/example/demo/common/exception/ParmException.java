package com.example.demo.common.exception;

/**
 * 参数异常
 * <p>
 * 1、请求参数为空或缺失，如：ID为Null；
 * 3、参数范围错误，如：ID为负值；
 * </p>
 * Author :tanjm
 * Date:  2021/6/22
 * Desc:
 */
public class ParmException extends BaseException {
    public ParmException() {
        super(null, false);
        super.setErrcode(1);
    }

    public ParmException(String msg, boolean writableStackTrace) {
        super(msg, writableStackTrace);
        super.setErrcode(1);
    }
}
