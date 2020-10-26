package com.jzl.math.string;

import org.junit.Test;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 10:32 2020/9/8
 * @Modified By:
 */
public class TestString {
    @Test
    public void testString() {
        String str = "are you ok ?";
        // 字符串反转
        char[] chars = str.toCharArray();

//        reverse(chars);

        System.out.println(chars);

    }

    private void reverse(char[] chars , int start ,int end) {
        for (int i = start; i < end / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - i -1];
            chars[chars.length - i -1] = temp;
        }
    }
}
