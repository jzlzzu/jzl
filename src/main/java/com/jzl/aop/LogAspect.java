package com.jzl.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.annotation.Target;

/**
 * @Author: jzl 测试切面和切面表达式
 * @Description:
 * @Date: Created in 16:23 2019/5/30
 * @Modified By:
 */
@Component
@Aspect
public class LogAspect {

    @Pointcut("execution(* com.jzl.controller..*.*(..))")
    public void method() {

    }

    /**
     * target ：目标对象
     * this : 代理对象
     */
    @Pointcut("target(com.jzl.controller.JzlController)")
    public void pointBefore() {

    }


    @Before("pointBefore()")
    public void beforeAdvice(){
        System.out.println("------前置通知执行-------");
    }


    @Around("method()")
    public Object log(ProceedingJoinPoint point) throws Throwable {
        System.out.println("LogAspect 切面执行");
        return point.proceed();

    }


}
