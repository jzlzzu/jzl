package com.jzl.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jzl.async.AsyncTask;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 17:02 2020/4/14
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class TestAsync {

    @Autowired
    private AsyncTask asyncTask;

    @Test
    public void name() throws ExecutionException, InterruptedException {
        Map map = new HashMap<String,String>() {
            {
                put("sms", "sms");
                put("flow", "flow");
            }
        };

        Map map1 = new HashMap<String,String>() {
            {
                put("sms", "sms");
                put("flow", "flow");
            }
        };
        Future<Object> sms = asyncTask.getSms(JSONObject.toJSONString(map));
        Future<Object> flow = asyncTask.getFlow(JSONObject.toJSONString(map1));

        Object o1 = flow.get();
        Object o = sms.get();

        System.out.println(o);
        System.out.println(o1);

    }
}
