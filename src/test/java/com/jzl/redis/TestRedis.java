package com.jzl.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 17:03 2020/1/17
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    @SneakyThrows
    public void test() {

        HashMap<String, String[]> arrMap = new HashMap<>();
        String[] strings = {
                "a","b","c"
        };
        arrMap.put("strings",strings);
        Header header1 = new BasicHeader("ceshi","value");
        Header header2 = new BasicHeader("ceshi2","value");
        Header[] headers = new Header[]{
                header1,header2
        };
        HashMap<String, Object> map = new HashMap<>();
        map.put("arrMap",arrMap);
        map.put("headers",headers);

        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(map);
        redisTemplate.opsForValue().set("str",s);
        String str = (String) redisTemplate.opsForValue().get("str");
        Map map1 = mapper.readValue(str, Map.class);
        Object o = map1.get("arrMap");
        Object o2 = map1.get("headers");
        HashMap<String, String[]> arrMap1 = (HashMap<String, String[]>) o;
        List<Map<String, String>> o21 = (List<Map<String, String>>) o2;

        System.out.println("ccccc");

//        redisTemplate.opsForZSet().add("zsetv1","member1",100);
//        redisTemplate.opsForZSet().add("zsetv1","member2",200);
//        redisTemplate.opsForZSet().add("zsetv1","member3",300);
//
//
//        Set<ZSetOperations.TypedTuple<Object>> set = redisTemplate.opsForZSet().rangeByScoreWithScores("zsetv1",0,200);
//        Iterator<ZSetOperations.TypedTuple<Object>> iterator = set.iterator();
//        while (iterator.hasNext()){
//            ZSetOperations.TypedTuple<Object> next = iterator.next();
//            String value = (String) next.getValue();
//        }

        System.out.println("------------");

    }
}
