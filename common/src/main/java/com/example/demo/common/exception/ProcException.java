package com.example.demo.common.exception;

/**
 * 流程异常，涉及业务逻辑的数据错误。
 * 异常返回码->>200
 * <p>
 * 1、业务流程状态不匹配；
 * 2、数据状态与业务不匹配；
 * 3、数据缺失；
 * </p>
 * Author :tanjm
 * Date:  2021/6/8
 * Desc:
 */
public class ProcException extends AbstractException {

    public ProcException() {
    }

    public ProcException(Integer errcode, String errmsg) {
        super(errcode, errmsg);
    }
}
