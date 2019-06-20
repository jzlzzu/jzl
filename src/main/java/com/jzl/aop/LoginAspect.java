package com.jzl.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @Author: jzl 测试切面和切面表达式
 * @Description:
 * @Date: Created in 16:23 2019/5/30
 * @Modified By:
 */
@Component
@Aspect
public class LoginAspect {

    @Pointcut("execution(* com.jzl.controller..*.*(..))")
    public void method(){

    }

    @Around("method()")
    public Object log(ProceedingJoinPoint point) throws Throwable {
        System.out.println("LoginAspect 切面执行");
        MethodSignature signature = (MethodSignature)point.getSignature();
        Method method = signature.getMethod();

       ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();

        if(isLoginRequired(method)){
            // 对添加 loginRequired注解的方法做处理
            System.out.println("对添加 loginRequired注解的方法做处理");
        }

        return point.proceed();

    }

    private boolean isLoginRequired(Method method) {
        if(method.isAnnotationPresent(LoginRequired.class)){
            return true;
        }

        return false;
    }


}
