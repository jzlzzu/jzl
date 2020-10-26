package com.jzl.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 16:58 2020/9/10
 * @Modified By:
 */
@Component
public class Test implements CommandLineRunner {
    @Autowired
    private EventPublisServiceImpl eventPublisServiceImpl;

    @Override
    public void run(String... args) throws Exception {
    eventPublisServiceImpl.publishEvent();
    }
}
