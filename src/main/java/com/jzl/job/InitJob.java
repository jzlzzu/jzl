package com.jzl.job;

import org.apache.ibatis.io.Resources;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 15:44 2020/3/10
 * @Modified By:
 */
@Component
public class InitJob implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("url.properties");
        System.out.println(resourceAsStream);
    }
}
