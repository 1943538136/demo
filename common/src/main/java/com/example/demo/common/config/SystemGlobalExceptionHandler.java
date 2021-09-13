package com.example.demo.common.config;

import com.example.demo.common.core.ResponseData;
import com.example.demo.common.exception.ParmException;
import com.example.demo.common.exception.ProcException;
import com.example.demo.common.exception.SysException;
import com.example.demo.common.util.ResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SystemGlobalExceptionHandler {
    /**
     * 参数校验异常，200状态码
     * <p>
     * {
     * "success":false,
     * "errcode":xxxxxx,
     * "errmsg":"xxxxxx",
     * "timestamp":1631238188759
     * }
     * </p>
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ParmException.class)
    public ResponseData resolveParmExceptionHandler(ParmException e) {
        return ResponseUtils.error(e.getErrcode(), e.getErrmsg());
    }

    /**
     * 流程校验异常，200状态码
     * <p>
     * {
     * "success":false,
     * "errcode":xxxxxx,
     * "errmsg":"xxxxxx",
     * "timestamp":1631238188759
     * }
     * </p>
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ProcException.class)
    public ResponseData resolveProcExceptionHandler(ProcException e) {
        return ResponseUtils.error(e.getErrcode(), e.getErrmsg());
    }

    /**
     * 流程校验异常，500状态码
     * <p>
     * {
     * "success":false,
     * "errcode":xxxxxx,
     * "errmsg":"xxxxxx",
     * "timestamp":1631238188759
     * }
     * </p>
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SysException.class)
    public ResponseData resolveSysExceptionHandler(SysException e) {
        return ResponseUtils.error();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class, Throwable.class})
    public ResponseData resolveDefExceptionHandler(Exception e) {
        return ResponseUtils.error();
    }
}