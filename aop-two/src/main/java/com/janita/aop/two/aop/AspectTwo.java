package com.janita.aop.two.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Janita on 2017-03-22 08:53
 */
@Aspect
@Component
public class AspectTwo {
    private Logger logger = Logger.getLogger(AspectTwo.class);

    @Pointcut("@annotation(com.janita.aop.two.annotation.ExecTime)")
    private void annotationPointCut(){}

    /**
     * 通过此方法可以修改返回前端的数据
     * @param joinPoint
     * @return
     */
    @Around("annotationPointCut()")
    public Object wasteTime(ProceedingJoinPoint joinPoint){
        Object output = null ;
        try {
            long start = System.currentTimeMillis();
            output = joinPoint.proceed();
            long elapsedTime = System.currentTimeMillis() - start;

            String className = joinPoint.getTarget().getClass().getSimpleName();

            logger.info("***********************************");
            logger.info(String.format("method [%s.%s()] execution time:%sms", className, joinPoint.getSignature().getName(), elapsedTime));


        }catch (Throwable throwable){
            logger.error("aop record method exec time error",throwable);
        }
        return output;
    }
}
