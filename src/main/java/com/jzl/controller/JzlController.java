package com.jzl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
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

    @GetMapping("get")
    public void jzlGet() throws IOException {
        OutputStream os = response.getOutputStream();
        os.write("E1111cba".getBytes());
        System.out.println("调用get方法");
//        return "getCC";
    }

}
