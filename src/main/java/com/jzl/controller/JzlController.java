package com.jzl.controller;

import com.jzl.application.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 16:06 2019/4/8
 * @Modified By:
 */
@RestController("/jzl")
public class JzlController {

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private Environment env;


    @Autowired
    private Config config;

    @GetMapping("get")
    public void jzlGet() throws IOException {

        System.out.println(config.getJzl());
        String path = new ClassPathResource("server.keystore").getPath();
        System.out.println(path);
        String name = new File("src/main/resources/server.keystore").getName();
        System.out.println("name"+ name);

        OutputStream os = response.getOutputStream();
        os.write("E1111cba".getBytes());
        System.out.println("调用get方法");
        System.out.println(env.getProperty("spring.datasource.first.jdbc-url"));
//        return "getCC";
    }

}
