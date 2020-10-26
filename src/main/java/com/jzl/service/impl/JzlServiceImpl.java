package com.jzl.service.impl;

import com.jzl.service.JzlInter;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 15:27 2020/10/16
 * @Modified By:
 */
@Service
public class JzlServiceImpl implements JzlInter{

    @Transactional
    @Override
    public void test1() {
        System.out.println("jzlService-------");
    }
}
