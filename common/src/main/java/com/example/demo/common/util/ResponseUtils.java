package com.example.demo.common.util;

import com.example.demo.common.constant.SysErrorEnum;
import com.example.demo.common.core.ResponseData;

/**
 * Author :tanjm
 * Date:  2021/6/8
 * Desc:
 */
public class ResponseUtils {

    public static <T> ResponseData<T> success() {
        return success(null);
    }

    public static <T> ResponseData success(T data) {
        return success(null, null, data);
    }

    public static <T> ResponseData success(Integer errcode, String errmsg, T data) {
        return getResponseData(true, errcode, errmsg, data);
    }

    public static <T> ResponseData<T> error() {
        return error(null, null);
    }

    public static <T> ResponseData<T> error(Integer errcode, String errmsg) {
        return error(errcode, errmsg, null);
    }

    public static <T> ResponseData<T> error(Integer errcode, String errmsg, T data) {
        return getResponseData(false, errcode, errmsg, data);
    }

    private static <T> ResponseData<T> getResponseData(Boolean success, Integer errcode, String errmsg, T data) {
        ResponseData response = new ResponseData();
        boolean _success = (null != success && success) ? true : false;
        response.setSuccess(_success);
        if (_success) {
            response.setErrcode(null == errcode ? SysErrorEnum.SUCCESS.getErrcode() : errcode);
            response.setErrmsg(null == errmsg ? SysErrorEnum.SUCCESS.getErrmsg() : errmsg);
        } else {
            response.setErrcode(null == errcode ? SysErrorEnum.SYS_ERROR.getErrcode() : errcode);
            response.setErrmsg(null == errmsg ? SysErrorEnum.SYS_ERROR.getErrmsg() : errmsg);
        }
        if (null != data) {
            response.setData(data);
        }
        return response;
    }

}
