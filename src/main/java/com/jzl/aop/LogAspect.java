package com.jzl.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 16:23 2019/5/30
 * @Modified By:
 */
@Component
@Aspect
public class LogAspect {

    @Pointcut("execution(* com.jzl.controller..*.*(..))")
    public void method(){

    }

    @Around("method()")
    public Object log(ProceedingJoinPoint point) throws Throwable {
        System.out.println("切面执行");
        return point.proceed();

    }


}
