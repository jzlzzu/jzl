package com.jzl;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jzl.entity.Tree;
import com.jzl.entity.Weather;
import com.jzl.utils.HttpClientUtil;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import javax.tools.JavaCompiler;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 9:58 2019/7/2
 * @Modified By:
 * <p>
 * /**       ┏┛ ┻━━━━━┛ ┻┓
 * ┃　　　　　　 ┃
 * ┃　　　━　　　┃
 * ┃　┳┛　  ┗┳　┃
 * ┃　　　　　　 ┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　 ┃
 * ┗━┓　　　┏━━━┛
 * ┃　　　┃   神兽保佑
 * ┃　　　┃   代码无BUG！
 * ┃　　　┗━━━━━━━━━┓
 * ┃　　　　　　　    ┣┓
 * ┃　　　　         ┏┛
 * ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
 * ┃ ┫ ┫   ┃ ┫ ┫
 * ┗━┻━┛   ┗━┻━┛
 */
public class Jzl {

    @Test
    public void commonTest() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\jzl\\data\\write.txt", true));
        for (int i = 0; i < 10000000; i++) {
            bufferedWriter.append("olleh" + i + System.lineSeparator());
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }


    @Test
    public void serialJzl() throws Exception {
        Weather weather = new Weather();
        weather.setId(1);
        weather.setProvince("henan");
        weather.setCity("zzu");
        weather.setWeather("spring");

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("weather.obj"));
        outputStream.writeObject(weather);


    }

    @Test
    public void noSerialJzl() throws ParseException {

        String str = "127.0.0.1:9090/dx-manage/api/123";
        int i = str.indexOf("dx-manage");
        String substring = str.substring(i);
        System.out.println(substring);

        System.out.println(System.getProperty("user.dir"));


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2018-07-29");
        long time = date.getTime();

        Date curDate = new Date();
        long curDateStr = curDate.getTime();

        System.out.println(curDateStr - time);
        System.out.println((curDateStr - time) > 180L * 24 * 3600 * 1000);

    }


    @Test
    public void strEqu() {

        String s1 = "abc   ";
        String s2 = "abc";

        String abc = new String("abc");
        System.out.println(s1 == s2);
        System.out.println(s1 == abc);
    }
    @Test
    public void testHttpClient() throws IOException {


//        String s = HttpClientUtil.sendPostSSLRequest("https://www.baidu.com", "");
        String s = HttpClientUtil.sendPostSSLRequest("https://10.121.74.64:4443/api/dynamic/certificate/obtain_token", "{}");

        System.out.println("------------");


    }

    @Test
    public void testExecption() {
        try {
            System.out.println("开始执行");
            int i = 10 /0;
        } catch (Exception e) {
            System.out.println("exception");
        } finally {
            System.out.println("finally");
        }


    }

    @Test
    public void testFastJson() throws IOException, JSONException {

        Tree tree = new Tree("red","128");

        Object o = JSON.toJSON(tree);
        String s1 = JSON.toJSONString(tree);

        System.out.println(s1);


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("color","red");
        jsonObject.put("high","128");
        String s = String.valueOf(jsonObject);
        System.out.println(s);
        Object jsonObject1 = JSON.parse(String.valueOf(jsonObject));





    }

    @Test
    public void testjava8Date() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        LocalDateTime now = LocalDateTime.now();
        String s = now.toString();
        System.out.println(s);


    }

    @Test
    public void complicatedexpression_r(){
        BigDecimal a = new BigDecimal(5);
        BigDecimal b = new BigDecimal(6);
        BigDecimal divide = a.divide(b, 4, RoundingMode.HALF_UP);
        System.out.println(divide);

    }
}
