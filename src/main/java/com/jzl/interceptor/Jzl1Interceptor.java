package com.jzl.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 15:27 2019/5/30
 * @Modified By:
 */
@Slf4j
@Component
public class Jzl1Interceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Jzl1Interceptor 拦截器1执行啦啦");
        return super.preHandle(request, response, handler);
    }
}
