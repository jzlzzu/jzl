package com.jzl;

import com.jzl.entity.Weather;
import org.junit.Test;
import org.springframework.http.HttpHeaders;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 9:58 2019/7/2
 * @Modified By:
 *
/**       ┏┛ ┻━━━━━┛ ┻┓
          ┃　　　　　　 ┃
          ┃　　　━　　　┃
          ┃　┳┛　  ┗┳　┃
          ┃　　　　　　 ┃
          ┃　　　┻　　　┃
          ┃　　　　　　 ┃
          ┗━┓　　　┏━━━┛
            ┃　　　┃   神兽保佑
            ┃　　　┃   代码无BUG！
            ┃　　　┗━━━━━━━━━┓
            ┃　　　　　　　    ┣┓
            ┃　　　　         ┏┛
            ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
              ┃ ┫ ┫   ┃ ┫ ┫
              ┗━┻━┛   ┗━┻━┛
*/
public class Jzl {

    @Test
    public void commonTest() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\jzl\\data\\write.txt",true));
        for (int i = 0; i < 10000000; i++) {
            bufferedWriter.append("olleh"+ i + System.lineSeparator());
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
    public void noSerialJzl() {

        String str = "127.0.0.1:9090/dx-manage/api/123";
        int i = str.indexOf("dx-manage");
        String substring = str.substring(i);
        System.out.println(substring);

    }
}
