package com.jzl.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Author: jzl
 * @Description: httpsession监听器
 * @Date: Created in 16:39 2019/11/14
 * @Modified By:
 */
public class OnlineListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("OnlineListener --- sessionCreated");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("OnlineListener --- sessionDestroyed");
    }
}
