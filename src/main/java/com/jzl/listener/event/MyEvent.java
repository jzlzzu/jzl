package com.jzl.listener.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * @Author: jzl
 * @Description: 自定义一个监听器事件
 * @Date: Created in 9:51 2020/1/17
 * @Modified By:
 */
@Data
public class MyEvent extends ApplicationEvent {

    private String eventStr;

    public MyEvent(Object source) {
        super(source);
    }

    public MyEvent(Object source, String eventStr) {
        super(source);
        this.eventStr = eventStr;
    }
}
