package com.jzl.jzlspring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 9:57 2020/6/13
 * @Modified By:
 */
@Component
public class MyInitBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        //
    }
}
