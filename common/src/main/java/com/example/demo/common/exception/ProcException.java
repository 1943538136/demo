package com.example.demo.common.exception;

import com.example.demo.common.constant.SysErrorEnum;

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
        super(SysErrorEnum.PROC_ERROR);
    }
    public ProcException(String errmsg) {
        super(SysErrorEnum.PARM_ERROR.getErrcode(), errmsg, false);
    }
}
