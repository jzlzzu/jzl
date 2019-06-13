package com.jzl.spring;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jzl.entity.Weather;
import com.jzl.mapper.master.WeatherMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Test
    public void testQuery() throws JsonProcessingException {

//        Weather weather = weatherMapper.selectById(1);
        Page<Weather> weatherPage = new Page<>(1,5);
        IPage<Weather> weatherIPage = weatherMapper.selectPage(weatherPage, null);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(weatherIPage));
    }

    @Test
    public void test() {
        Page<Map<String,Object>> page = new Page<>(1, 3);
        List<Weather> lists = weatherMapper.lists(page);
        System.out.println(lists);
    }
}
