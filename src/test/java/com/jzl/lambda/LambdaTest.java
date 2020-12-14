package com.jzl.lambda;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jzl.entity.NoLombok;
import com.jzl.entity.Weather;
import com.jzl.entity.Weather1;
import org.junit.Test;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.core.ParameterizedTypeReference;

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
    public void testReview() throws IOException {
        ArrayList<Weather> list = getList();
        // 获取 id列表
        List<Integer> ids = list.stream().map(weather -> weather.getId()).collect(Collectors.toList());
        System.out.println(ids);

        // 判断id是否都为1
        List<Weather> weatherId1 = list.stream().filter(weather -> weather.getId() == 1).collect(Collectors.toList());

        System.out.println("weatherId1" + weatherId1);

        // 找出最大 id

        String maxId = list.stream().max(Comparator.comparingInt(Weather::getId)).toString();
        System.out.println("maxId" + maxId);

        // List转Map
        Map<Integer, String> map = list.stream().collect(Collectors.toMap(Weather::getId, Weather::getCity));
        System.out.println("map" + map);

        // 找到id为1 的天气

        // 按照id的降序列出所有天气信息
        List<Weather> desc = list.stream().sorted((o1,o2)->Integer.compare(o2.getId(),o1.getId())).collect(Collectors.toList());
        System.out.println("desc" + desc);

        // 按照id的升序列出所有天气信息
        List<Weather> asc = list.stream().sorted(Comparator.comparingInt(Weather::getId)).collect(Collectors.toList());
        System.out.println("asc" + asc);

        // 获取平均id


    }

    @Test
    public void name() {

        ArrayList<Weather> list = getList();
        List<String> collect = list.stream().map(weather -> weather.getCity().toUpperCase()).collect(Collectors.toList());

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
        List<Weather> collect = list.stream().filter(e -> e.getId() > 1).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * list json objectmapper
     * @throws IOException
     */
    @Test
    public void TestListJson() throws IOException {
        ArrayList<Weather> list = getList();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);

        //
        List<Weather1> weather1s = JSON.parseArray(json, Weather1.class);

        JsonNode jsonNode = mapper.readTree(json);

        System.out.println(jsonNode);

        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, Weather.class);
        ArrayList<Weather> weathers = mapper.readValue(jsonNode.toString(), javaType);
        weathers.stream().forEach(l-> System.out.println(l));

        JacksonJsonParser jacksonJsonParser = new JacksonJsonParser();
        List<Object> objects = jacksonJsonParser.parseList(jsonNode.toString());
        objects.stream().forEach(l-> System.out.println(l));

        ObjectMapper mapper1 = new ObjectMapper();
        mapper1.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
//        new ParameterizedTypeReference<>()
        List<Weather1> o = mapper1.convertValue(jsonNode, new TypeReference<List<Weather1>>() {});
        System.out.println(o);

        List<Weather1> weather1s1 = JSON.parseArray(json, Weather1.class);


        System.out.println("1111");
    }

    /**
     * json转换时, 字符串的key要和对象中的一一对应 , 对象中不能缺少对应字段
     * @throws Exception
     */
    @Test
    public void testJson() throws Exception {
        Weather weather = new Weather();
        weather.setId(1);
        weather.setCity("olleh");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        String s = mapper.writeValueAsString(weather);
        Weather1 weather1 = mapper.readValue(s, Weather1.class);
        System.out.println(weather1);
    }



    public static ArrayList<Weather> getList() {
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
