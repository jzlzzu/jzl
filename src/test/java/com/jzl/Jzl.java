package com.jzl;

import com.jzl.entity.Weather;
import org.junit.Test;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public void name() {
        String s1 = "abc";
        String s2 = "abc";

        String abc = new String("abc");
        System.out.println(s1 == s2);
        System.out.println(s1 == abc);
    }
}
