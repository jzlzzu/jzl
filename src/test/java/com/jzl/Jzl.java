package com.jzl;

import com.alibaba.fastjson.JSON;
import com.jzl.entity.Student;
import com.jzl.entity.Tree;
import com.jzl.entity.Weather;
import com.jzl.utils.HttpClientUtil;
import org.apache.tika.Tika;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.util.Assert;

import javax.activation.MimetypesFileTypeMap;
import java.io.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

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
    public void jjj() throws InterruptedException {
        Student student = new Student();
        new Thread(()->{
            aa(student);
        }).start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println(student);
    }

    public void aa(Student student){
        student.setAge("123");
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

        System.out.println("substring".substring(substring.length()));

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

        String s1 = "!abc   ";
        String s2 = "abc";
        String substring = s1.substring(1);
        System.out.println(substring);



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
        String str ="abc";
        String[] split = str.split(",");

        System.out.print(str.split(",").length);
    }

    @Test
    public void testFastJson() throws IOException, JSONException {

        Tree tree = new Tree("red", "128");

        Object o = JSON.toJSON(tree);
        String s1 = JSON.toJSONString(tree);
        String s2 = JSON.toJSONString("oellfasfjl;d");

        String a = "\"olleh\"";
        String b = "olleh";
        Object parse = JSON.parse(a);
        Object d = JSON.parse(b);

        System.out.println(s1);
        System.out.println(s2);


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("color", "red");
        jsonObject.put("high", "128");
        String s = String.valueOf(jsonObject);
        System.out.println(s);
        Object jsonObject1 = JSON.parse(String.valueOf(jsonObject));


    }

    @Test
    public void testjava8Date() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = now.plusDays(-29L);

        String format = now.format(dtf);
        String format1 = localDateTime.format(dtf);
        System.out.println(format);
        System.out.println(format1);


    }

    @Test
    public void complicatedexpression_r() {



        BigDecimal a = new BigDecimal(5);
        BigDecimal b = new BigDecimal(6);
        BigDecimal divide = a.divide(b, 4, RoundingMode.HALF_UP);
        System.out.println(divide);

    }

    @Test
    public void testInflux() {

        long time = 1575008796535404311l;
        Date date = new Date();
        date.setTime(1575008796L);
        Date date2 = new Date();
        date2.setTime(1575008796535L);
        Date date1 = new Date();
        date1.setTime(1575008796535404311L);
        System.out.println(date);
        System.out.println(date1);
        System.out.println(date2);

        Instant now = Instant.now();

        System.out.println(now.toString());

    }

    @Test
    public void testBlockingQueue() throws InterruptedException {

        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(2);
        // 容量不足抛出异常
        queue.add("1");
        // 容量不足 阻塞
        queue.put("2");
        queue.offer("3",10,TimeUnit.MILLISECONDS);

        String peek = queue.peek();
        String take = queue.take();
        String poll = queue.poll();

        queue.element();



    }

    @Test
    public void testArrayList() {
        ArrayList<String> list = new ArrayList<>();
//        Assert.notEmpty(list,"kong------");

        String str = "#\\{hello}";
        String js = "#{123}----#{hello}";
        String s = js.replaceAll(str, "12345");
        System.out.println(js);
        System.out.println(s);
        Assert.isNull(list,"list 为空");
        Assert.isTrue(false,"jfidajiodfsjisddsoji");
    }

    @Test
    public void testFormat() {

        String a = "olleh";
        String b = "oll";
        String c = "oll" + new String("eh");

        System.out.println(a == c);
        char ch = '\ubc4f';
        System.out.println(ch);
//        Double d = 40;
        int i = 100;
//        float f = 32.00;

        String str = "http://%s:%s";
        String format = String.format(str, "127.0.0.1", "8080");
        System.out.println(format);

        switch ("aa"){
            case "ab":
                System.out.println("ab");
            case "aa":
                System.out.println("aa");
            case "ac":
                System.out.println("ac");
            case "ad":
                System.out.println("ad");
        }

    }

    /**
     * 测试反射相关方法
     * @throws Exception
     */
    @Test
    public void reflect() throws Exception {
        Class<?> aClass = Class.forName(Weather.class.getName());
        Object newInstance = aClass.getDeclaredConstructor().newInstance();
        Field city = aClass.getDeclaredField("city");
        city.setAccessible(true);
        city.set(newInstance,"日本");
        System.out.println(newInstance);

    }

    /**
     * 研究一下反射的API
     */
    @Test
    public void testReflect() {
        System.out.println(Arrays.asList("1,2,3,4,5"));
    }

    @Test
    public void testCompare() {
        Integer a = 0;
        System.out.println(a.compareTo(Integer.valueOf(0)));
    }

    @Test
    public void common123() {
        File file = new File("D:\\zsnetwork\\工作\\一体化协同办公\\协同应用需求梳理.pdf");
        MimetypesFileTypeMap fileTypeMap = new MimetypesFileTypeMap();
        String mimeType = fileTypeMap.getContentType("file.getName()");
        System.out.println(mimeType);
    }

    @Test
    public void common124() throws IOException {
        File file = new File("D:\\zsnetwork\\工作\\一体化协同办公\\协同应用需求梳理.pdf");
        Path path = file.toPath();
        String mimeType = Files.probeContentType(path);
        System.out.println(mimeType);
    }

    @Test
    public void common125() throws IOException {
        Tika tika = new Tika();
//        File file = new File("D:\\zsnetwork\\工作\\豫事办中台对接\\对接文档\\用户中心token交换API接口.docx");
//        String mimeType = tika.detect(file);
        String detect = tika.detect("D:\\zsnetwork\\工作\\豫事办中台对接\\对接文档\\用户中心token交换API接口1.pdf");
        System.out.println(detect);
    }

    @Test
    public void common126() throws IOException {
        File file = new File("D:\\zsnetwork\\工作\\豫事办中台对接\\对接文档\\用户中心token交换API接口.docx");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        String mimeType = URLConnection.guessContentTypeFromStream(bufferedInputStream);
        String mimeType1 = URLConnection.guessContentTypeFromName("D:\\zsnetwork\\工作\\豫事办中台对接\\对接文档\\用户中心token交换API接口.docx");
        System.out.println(mimeType1);
    }

}
