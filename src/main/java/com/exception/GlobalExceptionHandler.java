package com.exception;

import com.result.CodeMsg;
import com.result.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value=BindException.class)
    public Result<CodeMsg> BindExceptionHandler(Exception e) {
        if(e instanceof BindException) {
            BindException ex = (BindException)e;
            List<ObjectError> errors =  ex.getAllErrors();
            ObjectError error = errors.get(0);
            String msg = error.getDefaultMessage();
            return Result.error(CodeMsg.BIND_ERROR.fillArgs(msg));
        }
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @ExceptionHandler(value = GlobalException.class)
    public Result<CodeMsg> GlobalException(Exception e) {
        if(e instanceof GlobalException) {
            GlobalException ex = (GlobalException) e;
            return Result.error(ex.getMsg());
        }
        return Result.error(CodeMsg.SERVER_ERROR);
    }

}
