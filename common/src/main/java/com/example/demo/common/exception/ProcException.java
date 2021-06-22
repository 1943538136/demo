package com.example.demo.common.exception;

/**
 * 流程异常，涉及业务逻辑的数据错误
 * <p>
 * 1、业务流程状态不匹配；
 * </p>
 * Author :tanjm
 * Date:  2021/6/8
 * Desc:
 */
public class ProcException extends BaseException {
    public ProcException() {
        super(null, false);
        super.setErrcode(3);
    }

    public ProcException(String msg, boolean writableStackTrace) {
        super(msg, writableStackTrace);
        super.setErrcode(3);
    }
}
