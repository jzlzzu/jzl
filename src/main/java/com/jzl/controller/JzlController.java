package com.jzl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 16:06 2019/4/8
 * @Modified By:
 */
@RestController("/jzl")
public class JzlController {

    @GetMapping("get")
    public void jzlGet(){
        System.out.println("调用get方法");
    }

}
