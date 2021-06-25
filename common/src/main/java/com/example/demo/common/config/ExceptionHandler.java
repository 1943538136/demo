package com.example.demo.common.config;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    /**
     * 用来处理bean validation异常
     *
     * @param ex
     * @return
     */
/*    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResponseData resolveConstraintViolationException(ConstraintViolationException ex) {

       *//* Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        if (!CollectionUtils.isEmpty(constraintViolations)) {
            StringBuilder msgBuilder = new StringBuilder();
            for (ConstraintViolation constraintViolation : constraintViolations) {
                msgBuilder.append(constraintViolation.getMessage()).append(",");
            }
            String errorMessage = msgBuilder.toString();
            if (errorMessage.length() > 1) {
                errorMessage = errorMessage.substring(0, errorMessage.length() - 1);
            }
            // baseResponse.setInfo(errorMessage);
            return new ResponseUtil().setErrorMsg(errorMessage);
        }*//*
        return ResponseUtils.error();
    }*/

    /**
     * 用来处理方法内参数校验异常
     *
     * @param ex
     * @return
     */
/*    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ControllerResponse resolveMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<ObjectError> objectErrors = ex.getBindingResult().getAllErrors();
        if (!CollectionUtils.isEmpty(objectErrors)) {
            StringBuilder msgBuilder = new StringBuilder();
            for (ObjectError objectError : objectErrors) {
                msgBuilder.append(objectError.getDefaultMessage()).append(",");
            }
            String errorMessage = msgBuilder.toString();
            if (errorMessage.length() > 1) {
                errorMessage = errorMessage.substring(0, errorMessage.length() - 1);
            }
            return new ResponseUtil().setErrorMsg(errorMessage);
        }
        return new ResponseUtil().setErrorMsg(ex.getMessage());
    }*/

    /**
     *
     * 处理权限不足异常
     * @author : suqiye
     * @param
     * @return
     */
/*    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public ControllerResponse resolveUnauthorizedException(UnauthorizedException e) {
        if(e.getMessage().contains("Subject does not")){
            // shiro 权限不足日志，返回前端时简化一下
            return new ResponseUtil().setErrorMsg(HttpStatus.FORBIDDEN.value(), "权限不足!");
        }
        // 自己抛出的权限不足异常，使用自己设置的message
        return new ResponseUtil().setErrorMsg(HttpStatus.FORBIDDEN.value(), e.getMessage());
    }*/

    /**
     * 捕获远程调用service异常
     * @Author suqiye
     * @Date 2020/8/4 22:10
     * @Param
     */
/*    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ControllerResponse resolveServiceException(ServiceException e) {
        return new ResponseUtil().setData(new RemoteResponse(e.getErrorCode(), e.getMessage()));
    }*/


/*    @ExceptionHandler(BaseBusinessException.class)
    @ResponseBody
    public ControllerResponse BusinessException(BaseBusinessException e) {
        return new ResponseUtil().setData(new RemoteResponse(e.getErrorCode(), e.getMessage()));
    }*/


    /**
     * 系统未捕获异常。
     * @param e
     * @return
     */
/*    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ControllerResponse exception(Exception e) {
        // 为了防止系统未知的异常，这里必须要打印异常。否则会没有异常日志，无法排查问题。
        log.error("系统异常: ",e);
        return new ResponseUtil().setErrorMsg("系统异常!");
    }*/
}