package com.jzl.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jzl.aop.LoginRequired;
import com.jzl.application.Config;
import com.jzl.config.MyProperties;
import com.jzl.entity.Jzl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 16:06 2019/4/8
 * @Modified By:
 */
@RestController
@RequestMapping("/jzl")
public class JzlController {

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private Environment env;

    @Autowired
    private MyProperties myProperties;


    @Autowired
    private Config config;

    @LoginRequired(loginRequired = true)
    @GetMapping("get")
    public void jzlGet(@SessionAttribute(name="str",required = false) String str) throws IOException {

        String method = request.getMethod();

        System.out.println(config.getJzl());
        String path = new ClassPathResource("server.keystore").getPath();
        ClassPathResource classPathResource = new ClassPathResource("server.keystore");
        System.out.println(path);
        String name = new File("src/main/resources/server.keystore").getName();
        System.out.println("name"+ name);

        HashMap<String, String> map = new HashMap<>();
        map.put("response_status","401");
        ObjectMapper mapper = new ObjectMapper();
        OutputStream os = response.getOutputStream();
        os.write(mapper.writeValueAsBytes(map));
        System.out.println("调用get方法");
        System.out.println(env.getProperty("spring.datasource.first.jdbc-url"));

//        response.sendRedirect("/jzl/get1");

//        return "getCC";
    }

    @PostMapping("post")
    public void jzlPost(@RequestBody Jzl jzl) throws IOException {
        System.out.println(jzl);
    }

}
