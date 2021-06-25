package com.example.demo.common.exception;

import com.example.demo.common.constant.SysErrorEnum;

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
        super(SysErrorEnum.PARM_ERROR);
    }

    public ParmException(String errmsg) {
        super(SysErrorEnum.PARM_ERROR.getErrcode(), errmsg, false);
    }
}
