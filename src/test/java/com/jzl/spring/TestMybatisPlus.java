package com.jzl.spring;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jzl.entity.OoBean;
import com.jzl.entity.Student;
import com.jzl.entity.Weather;
import com.jzl.mapper.master.StudentMapper;
import com.jzl.mapper.master.WeatherMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 17:04 2019/4/28
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMybatisPlus {
    Logger logger = LoggerFactory.getLogger(TestMybatisPlus.class);

    @Autowired
    private WeatherMapper weatherMapper;

    @Autowired
    private StudentMapper studentMapper;


    @Test
    public void testGroup() {
        QueryWrapper<Weather> wrapper = new QueryWrapper<>();
        wrapper.select("city", "count(city)").groupBy("city");
        List<Map<String, Object>> maps = weatherMapper.selectMaps(wrapper);
        Weather weather = new Weather();
        weather.setId(1);
        List<Map<String, Object>> maps1 = weatherMapper.selectMaps(Wrappers.query(weather));



        System.out.println(maps);

    }

    @Test
    public void testSum() {
        weatherMapper.selectSum();
        System.out.println("fffff");
    }

    @Test
    public void testQuery() throws JsonProcessingException {

//        Weather weather = weatherMapper.selectById(1);
        Page<Weather> weatherPage = new Page<>(1, 5);
        IPage<Weather> weatherIPage = weatherMapper.selectPage(weatherPage, null);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(weatherIPage));
    }

    @Test
    public void test() {
        Page<Map<String, Object>> page = new Page<>(1, 3);
        List<Weather> lists = weatherMapper.lists(page);
        System.out.println(lists);
    }

    @Test
    public void test1() {
        Weather weather = weatherMapper.selectCity();
        System.out.println(weather);
    }

    @Test
    public void testInsert() {
        Weather weather = new Weather();
        weather.setWeather("olleh");
        weather.setTemperature("123");
        Integer integer = weatherMapper.customInsertSelective(weather);
        System.out.println(integer);
        System.out.println(weather.getId());
    }

    @Test
    public void testBatchInsert() {

        List<Weather> weathers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Weather weather = new Weather();
            weather.setWeather("olleh");
            weathers.add(weather);
        }
        weatherMapper.customBatchInsert(weathers);

    }

    @Test
    public void testSelectByWeather() {
        Weather weather = new Weather();
        weather.setWeather("olleh");
        List<Weather> weathers = weatherMapper.selectByWeather(weather);
        System.out.println(weathers);
    }

    @Test
    public void testUpdate() {
        Weather weather = new Weather();
        weather.setWeather("ccccccc");
        weather.setId(10001);
        weatherMapper.updateById(weather);
//        weatherMapper.customeUpdateById(weather);
    }

    @Test
    public void testQueryWrapper() {

        QueryWrapper<Weather> wrapper = new QueryWrapper<>();
        wrapper.select("sum(id)").eq("id", "1008611");

        List<Object> objects = weatherMapper.selectObjs(wrapper);


        System.out.println("olleh");


    }

    @Test
    public void testJzl() {
        Weather weather = weatherMapper.testJzl(1, "郑州");
        System.out.println(weather);
    }

    @Test
    public void testOom() {
        OoBean bean = new OoBean();
        ArrayList<String> ids = new ArrayList<>();
        ids.add("1");
        ids.add("2");
        bean.setIds(ids);

        bean.setName("olleh");
        List<Weather> weathers = weatherMapper.selectByWeatherList("12",bean);
        System.out.println(weathers);
    }

    @Test
    public void testStudent() {
//        Student student = studentMapper.selectOne(new LambdaQueryWrapper<Student>().eq(Student::getId, 4).and(w -> w.eq(Student::getName, 35).or().eq(Student::getAge, 24)));
//        System.out.println("st-----" + student);
//        List<Student> students = studentMapper.queryByDate(new Date());
//        students.stream().forEach(s -> System.out.println(s));
        Student student = studentMapper.selectById(5);
        System.out.println(student);
    }
}
