package com.jzl.listener;

import com.jzl.listener.event.MyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 10:00 2020/1/17
 * @Modified By:
 */
@Component
public class MyListener {

    @EventListener
    public void onApplicationEvent(MyEvent myEvent) {
        System.out.println("监听器触发,监听数据" + myEvent.getEventStr());
    }
}
