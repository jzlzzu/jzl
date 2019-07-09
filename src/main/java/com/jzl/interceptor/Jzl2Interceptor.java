package com.jzl.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 10:11 2019/7/8
 * @Modified By:
 */
@Component
public class Jzl2Interceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器2执行啦啦");

        return super.preHandle(request, response, handler);
    }
}
