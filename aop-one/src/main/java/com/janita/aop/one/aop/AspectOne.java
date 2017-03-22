package com.janita.aop.one.aop;

import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by Janita on 2017-03-22 08:53
 */
@Aspect
@Component
@Order(1)
public class AspectOne {
    private Logger logger = Logger.getLogger(getClass());
    private Gson gson = new Gson();
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.janita.aop.one.controller.**.*(..))")
    private void controllerAspect(){}

    @Before(value = "controllerAspect()")
    public void methodBefore(JoinPoint joinPoint){

        startTime.set(System.currentTimeMillis());

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        logger.info("======请求内容======");
        logger.info("请求地址 ："+request.getRequestURL().toString());
        logger.info("请求方式 ："+request.getMethod());
        logger.info("请求类方法 : "+joinPoint.getSignature());
        logger.info("请求类方法参数 : "+ Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "o",pointcut = "controllerAspect()")
    public void methodAfterReturning(Object o){
        logger.info("--------返回内容---------");
        logger.info("Response内容 : "+gson.toJson(o));
        logger.info("---------返回内容--------");
        logger.info("请求的处理时间为 : "+(System.currentTimeMillis() - startTime.get()));
    }
}
