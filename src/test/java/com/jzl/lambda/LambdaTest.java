package com.jzl.lambda;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jzl.entity.NoLombok;
import com.jzl.entity.Weather;
import org.junit.Test;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 16:16 2019/11/20
 * @Modified By:
 */
public class LambdaTest {

    @Test
    public void testList() {

        // https://blog.csdn.net/qq_22899021/article/details/94019297
        ArrayList<Weather> list = getList();

        List<Weather> weathers = list.stream().filter(weather -> weather.getId() > 5).collect(Collectors.toList());

        // 获取 id列表
        List<Integer> collect = list.stream().map(Weather::getId).collect(Collectors.toList());

        // 判断id是否都为1
        boolean b = list.stream().allMatch((weather) -> weather.getId().equals(1));

        // 找出最大 id
        Optional<Weather> max = list.stream().max(Comparator.comparingInt(Weather::getId));

        // List转Map
        Map<Integer, Weather> collect1 = list.stream().collect(Collectors.toMap(weather -> weather.getId(), weather -> weather));
//        collect1.forEach((k,v)-> System.out.println(k +"   "+ v));

        // 找到id为1 的天气
        Optional<Weather> collect2 = list.stream().filter(weather -> weather.getId().equals(1)).findAny();
//        System.out.println(collect2);

        // 按照id的降序列出所有天气信息
        List<Weather> collect3 = list.stream().sorted((e1, e2) -> Integer.compare(e2.getId(), e1.getId())).collect(Collectors.toList());
        System.out.println(collect3);

        // 按照id的升序列出所有天气信息
        List<Weather> collect4 = list.stream().sorted((e1, e2) -> Integer.compare(e1.getId(), e2.getId())).collect(Collectors.toList());
        System.out.println(collect4);

        // 获取平均id
        Double collect5 = list.stream().collect(Collectors.averagingInt(Weather::getId));

        System.out.println(collect5);

        System.out.println(b);

    }

    @Test
    public void testMap() throws IOException {
        Map<Integer, Weather> map = getMap();

        System.out.println("cccccccccccccccccccc");


    }

    @Test
    public void name() {

        // 截取字符串得到 10086
        String str = "aritcle:10086";
        String substring = str.substring(str.indexOf(":") + 1);
        System.out.println(substring);


    }

    @Test
    public void testLombok() {

        // lomBok 重写了对象的equals的 equals和hashcode方法

        Weather weather = new Weather();
        weather.setId(1);

        Weather weather1 = new Weather();
        weather1.setId(1);

        System.out.println(weather == weather1);
        System.out.println(weather.equals(weather1));

        NoLombok noLombok = new NoLombok();
        NoLombok noLombok1 = new NoLombok();

        noLombok.setColor("red");
        noLombok1.setColor("red");
        System.out.println(noLombok.equals(noLombok1));

        System.out.println(noLombok.hashCode() + "    " + noLombok1.hashCode());
        System.out.println(weather.hashCode() + "    " + weather1.hashCode());
    }

    @Test
    public void testCompare() {
        ArrayList<Weather> list = getList();

        // 排序
        Collections.sort(list, Comparator.comparingInt(Weather::getId));
        // colect


    }


    private ArrayList<Weather> getList() {
        ArrayList<Weather> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Weather weather = new Weather();
            weather.setId(i);
            weather.setCity("zz" + i);
            list.add(weather);
        }
        return list;
    }


    private HashMap<Integer, Weather> getMap() {
        HashMap<Integer, Weather> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            Weather weather = new Weather();
            weather.setId(i);
            weather.setCity("zz" + i);
            map.put(i, weather);
        }
        return map;
    }
}
