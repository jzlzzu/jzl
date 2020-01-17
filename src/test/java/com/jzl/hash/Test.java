package com.jzl.hash;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jzl.entity.Jzl;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.util.*;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 20:42 2019/5/9
 * @Modified By:
 */
public class Test {

    @org.junit.Test
    public void test1() {
        long jzl = ConsistentHash.md5HashingAlg("jzl");
        long jzl1 = ConsistentHash.fnv1HashingAlg("jzl");
        System.out.println(jzl);
        System.out.println(jzl1);

        System.out.println(HttpMethod.OPTIONS.name());
        ;
        System.out.println(HttpStatus.UNAUTHORIZED.value());
        ;
    }

    @org.junit.Test
    public void test2() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("a", "1");
        hashMap.put("b", "2");
        hashMap.forEach((k, v) -> {
            System.out.println(k + "----" + v);
        });

        String str = "aa,b,c";
        String[] split = str.split(",");
        List<String> stringList = Arrays.asList(split);
        System.out.println(stringList.contains("a"));


    }


    /**
     * jasypt
     *
     * @param args
     */
    public static void main(String[] args) throws JsonProcessingException {

        Jzl jzl = new Jzl();
        jzl.setId(1);
        jzl.setName("fff");
        jzl.setAge("111");
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(jzl);

        System.out.println(s);

        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //加密所需的salt(盐)
        textEncryptor.setPassword("jzl");
        //要加密的数据（数据库的用户名或密码）
        String username = textEncryptor.encrypt("root");
        String password = textEncryptor.encrypt("root123");
        System.out.println("username:" + username);
        System.out.println("password:" + password);
    }

}
