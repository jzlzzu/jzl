package com.jzl.hash;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 20:42 2019/5/9
 * @Modified By:
 */
public class Test {

    @org.junit.Test
    public void test1(){
        long jzl = ConsistentHash.md5HashingAlg("jzl");
        long jzl1 = ConsistentHash.fnv1HashingAlg("jzl");
        System.out.println(jzl);
        System.out.println(jzl1);

        System.out.println(HttpMethod.OPTIONS.name());;
        System.out.println(HttpStatus.UNAUTHORIZED.value());;
    }

    @org.junit.Test
    public void test2(){
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("a","1");
        hashMap.put("b","2");
        hashMap.forEach((k,v)->{
            System.out.println(k + "----" +v);
        });


    }

    /**
     * jasypt
     * @param args
     */
    public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //加密所需的salt(盐)
        textEncryptor.setPassword("jzl");
        //要加密的数据（数据库的用户名或密码）
        String username = textEncryptor.encrypt("root");
        String password = textEncryptor.encrypt("root123");
        System.out.println("username:"+username);
        System.out.println("password:"+password);
    }

}
