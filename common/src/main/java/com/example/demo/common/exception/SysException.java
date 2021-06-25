package com.example.demo.common.exception;

import com.example.demo.common.constant.SysErrorEnum;

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
        super(SysErrorEnum.PROC_ERROR);
    }
    public SysException(String errmsg) {
        super(SysErrorEnum.PARM_ERROR.getErrcode(), errmsg, true);
    }
}
