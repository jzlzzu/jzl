package com.jzl.async;

import com.alibaba.fastjson.JSONObject;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 16:52 2020/4/14
 * @Modified By:
 */
@Component
public class AsyncTask {

    @Async
    public Future<Object> getSms(String str){
        JSONObject jsonObject = JSONObject.parseObject(str);
        return new AsyncResult<>(jsonObject.get("sms"));
    }

    @Async
    public Future<Object> getFlow(String str){
        JSONObject jsonObject = JSONObject.parseObject(str);
        return new AsyncResult<>(jsonObject.get("flow"));
    }

}
