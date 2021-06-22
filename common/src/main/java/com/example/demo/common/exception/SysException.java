package com.example.demo.common.exception;

/**
 * 系统异常
 * <p>
 *
 * </p>
 * Author :tanjm
 * Date:  2021/6/8
 * Desc:
 */
public class SysException extends BaseException {
    public SysException() {
        super(null, true);
        super.setErrcode(-1);
    }

    public SysException(String msg, boolean writableStackTrace) {
        super(msg, writableStackTrace);
        super.setErrcode(-1);
    }
}
