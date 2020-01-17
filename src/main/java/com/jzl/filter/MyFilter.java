package com.jzl.filter;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 14:01 2019/7/24
 * @Modified By:
 */
@Configuration
@WebFilter(filterName = "MyFilter" , urlPatterns = "/**")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter -- init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("MyFilter -- doFilter");
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {
        System.out.println("MyFilter -- destroy");
    }
}
