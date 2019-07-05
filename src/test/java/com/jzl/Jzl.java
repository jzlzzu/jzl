package com.jzl;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 9:58 2019/7/2
 * @Modified By:
 */
public class Jzl {

    @Test
    public void commonTest() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\jzl\\data\\write.txt",true));
        for (int i = 0; i < 10000000; i++) {
            bufferedWriter.append("olleh"+ i + System.lineSeparator());
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
