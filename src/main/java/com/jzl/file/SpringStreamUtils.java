package com.jzl.file;

import org.springframework.util.StreamUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 10:52 2019/11/29
 * @Modified By:
 */
public class SpringStreamUtils {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("C:\\jzl\\write.txt"));
        String s = StreamUtils.copyToString(fileInputStream, Charset.forName("UTF-8"));
        System.out.println(s);
    }
}
