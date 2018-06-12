package com.aop;

import com.exception.GlobalException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class WebLogAop {

    private ThreadLocal<Long>startTime = new ThreadLocal<Long>();

    private ThreadLocal<Logger> log = new ThreadLocal<Logger>();

    private Logger logger;

    @Pointcut("execution(* com.controller.*.*(..))")
    public void webLog() {
    }

    private void initLogger(){
        logger = log.get();
        //logger = LoggerFactory.getLogger(this.getClass());
    }


    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {

        log.set(LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringTypeName()));
        startTime.set(System.currentTimeMillis());

        initLogger();

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature
                ().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(value = "webLog()", returning = "returnValue")
    public void doAfterReturning(JoinPoint joinPoint, Object returnValue) {
        // 处理完请求，返回内容
        initLogger();
        logger.info("RETURN_VALUE : " + returnValue);
        logger.info("PROCESS_TIME : " + (System.currentTimeMillis() - startTime.get()));
    }

    @AfterThrowing(value = "webLog()",throwing="e")
    public void afterThrowing(Throwable e) {
        initLogger();
        if (e instanceof GlobalException){
            GlobalException globalException = (GlobalException)e;
            logger.info("EXCEPTION : code: {}, msg: {}", globalException.getMsg().getCode(), globalException.getMsg().getMsg());
        }
    }

}
