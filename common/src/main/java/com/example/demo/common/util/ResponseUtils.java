package com.example.demo.common.util;

import com.example.demo.common.constant.SysErrorEnum;
import com.example.demo.common.core.ResponseData;

/**
 * Author :tanjm
 * Date:  2021/6/8
 * Desc:
 */
public class ResponseUtils {
    /**
     * 0 ->> 成功！
     *
     * @return
     */
    public static <T> ResponseData<T> success() {
        ResponseData response = new ResponseData(SysErrorEnum.SUCCESS);
        return response;
    }

    public static <T> ResponseData success(T data) {
        ResponseData response = new ResponseData(SysErrorEnum.SUCCESS, data);
        return response;
    }

    /**
     * -1 ->> 系统繁忙！
     *
     * @return
     */
    public static <T> ResponseData<T> error() {
        ResponseData response = new ResponseData(SysErrorEnum.SYS_ERROR);
        return response;
    }

    public static <T> ResponseData<T> error(Integer errcode, String errmsg, T data) {
        ResponseData response = new ResponseData(errcode, errmsg, data);
        return response;
    }

}
