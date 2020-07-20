package com.jzl.poi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 11:31 2019/4/8
 * @Modified By:
 */
@Slf4j
public class TestReadProperties {
    @org.junit.Test
    public void name() {
        ClassPathResource classPathResource = new ClassPathResource("/quartz.properties");
        String path = classPathResource.getPath();
        System.out.println("A".compareTo("a"));
    }
}
