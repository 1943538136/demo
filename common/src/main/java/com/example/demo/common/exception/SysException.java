package com.example.demo.common.exception;

/**
 * 系统异常，无法预知异常产生原因。如数据库执行异常，主键冲突或者约束条件冲突
 * 异常返回码->>500
 * <p>
 * 1、插入数据异常；
 * 2、更新数据异常；
 * 3、删除数据异常；
 * </p>
 * Author :tanjm
 * Date:  2021/6/8
 * Desc:
 */
public class SysException extends AbstractException {
    public SysException() {
    }

    public SysException(Integer errcode, String errmsg) {
        super(errcode, errmsg);
    }
}
