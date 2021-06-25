package com.example.demo.common.exception;

import com.example.demo.common.constant.SysErrorEnum;

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
        super(SysErrorEnum.PROC_ERROR);
    }
    public ValException(String errmsg) {
        super(SysErrorEnum.PARM_ERROR.getErrcode(), errmsg, false);
    }
}
