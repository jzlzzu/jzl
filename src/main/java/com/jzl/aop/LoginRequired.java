package com.jzl.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 10:41 2019/3/18
 * @Modified By:
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
public @interface LoginRequired {

    boolean loginRequired() default false;

}
