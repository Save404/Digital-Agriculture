package com.exception;

import com.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.net.BindException;

/*
@ControllerAdvice
@ResponseBody
*/
public class GlobalExceptionHandler {
    /*
    @ExceptionHandler(value=Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest, Exception e) {
        if(e instanceof BindException) {
            BindException ex = (BindException)e;
        }
    }
    */
}
