package com.example.demo.common.exception;

/**
 * 校验异常
 * <p>
 * 1、根据ID查找数据，数据未找到；
 * </p>
 * Author :tanjm
 * Date:  2021/6/8
 * Desc:
 */
public class ValException extends BaseException {
    public ValException() {
        super(null, false);
        super.setErrcode(2);
    }

    public ValException(String msg, boolean writableStackTrace) {
        super(msg,  writableStackTrace);
        super.setErrcode(2);
    }
}
