package com.jzl.listener;

import com.jzl.listener.event.MyEvent;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 10:09 2020/1/17
 * @Modified By:
 */
@Service
public class EventPublisServiceImpl implements ApplicationContextAware {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void publishEvent(){
        // 发布事件
        MyEvent event = new MyEvent("source","HELLO I AM A EVENT");
        applicationContext.publishEvent(event);
    }

}
