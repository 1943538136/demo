package com.example.demo.common.util;

import com.example.demo.common.constant.SysErrorConstants;
import com.example.demo.common.core.ErrorResponse;

/**
 * Author :tanjm
 * Date:  2021/6/8
 * Desc:
 */
public class ResponseUtils {

    public static ErrorResponse success() {
        ErrorResponse response = new ErrorResponse();
        response.setErrcode(SysErrorConstants.SUCCESS);
        response.setErrmsg(SysErrorConstants.SUCCESS_MSG);
        return response;
    }

    public static ErrorResponse error() {
        ErrorResponse response = new ErrorResponse();
        response.setErrcode(SysErrorConstants.ERROR);
        response.setErrmsg(SysErrorConstants.ERROR_MSG);
        return response;
    }

    public static ErrorResponse error(String errmsg) {
        ErrorResponse response = new ErrorResponse();
        response.setErrcode(SysErrorConstants.ERROR);
        response.setErrmsg(errmsg);
        return response;
    }

    public static ErrorResponse error(String errmsg, Object errdesc) {
        ErrorResponse response = new ErrorResponse();
        response.setErrcode(SysErrorConstants.ERROR);
        response.setErrmsg(errmsg);
        response.setErrdesc(errdesc);
        return response;
    }
}
