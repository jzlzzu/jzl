package com.jzl.file;

import java.io.*;
import java.nio.Buffer;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 18:18 2019/5/16
 * @Modified By:
 */
public class IoFile {
    public static void main(String[] args) throws Exception {


        //字符流  reader fileReader BufferedReader InputStreamReader
//        fileReader();
//        bufferedReader();
//        inputStreamReader();
//        stringReader();

        //       writer fileWriter BufferedWriter OutPutStreamWriter

//        fileWriter();
//        bufferedWriter();
//        outputStreamWriter();

        return;


        //字节流  inputStream fileInputStream bufferedInputStream
        //       outPutStream fileOutPutStream bufferedOutStream



    }

    private static void outputStreamWriter() throws IOException {
        OutputStream outputStream = new FileOutputStream(new File("C:\\jzl\\write.txt"));
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        outputStreamWriter.write("生活就像一面镜子,善待一切就是善待自己\r\n");
        outputStreamWriter.append("23种设计模式1");
        outputStreamWriter.flush();
        outputStreamWriter.close();
    }

    private static void bufferedWriter() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("C:\\jzl\\write.txt")));
        bufferedWriter.write("生活就像一面镜子,善待一切就是善待自己");
        bufferedWriter.newLine();
        bufferedWriter.append("23种设计模式");
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static void fileWriter() throws IOException {
        FileWriter fileWriter = new FileWriter(new File("C:\\jzl\\write.txt"));
        fileWriter.write("olleh\r\n");
        fileWriter.write("olleh\r\n");
        fileWriter.append("olleh123");
        fileWriter.flush();
        fileWriter.close();
    }

    private static void stringReader() throws IOException {
        StringReader stringReader = new StringReader("olleh");
        char[] cbuf = new char[2];
        int len = 0;
        while (-1 != (len = stringReader.read(cbuf))){
            System.out.println(new String(cbuf,0,len));
        }
        stringReader.close();
    }

    private static void inputStreamReader() throws IOException {
        InputStream inputStream = new FileInputStream(new File("C:\\jzl\\io.txt"));
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        char[] cbuf = new char[1024];
        int read = 0;
        while (-1 != (read = inputStreamReader.read(cbuf))){
            System.out.println(new String(cbuf,0,read));
        }
        inputStream.close();
        inputStreamReader.close();
    }

    private static void bufferedReader() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\jzl\\io.txt")));
        String line = "";
        while(null != (line = bufferedReader.readLine()) && line.length() > 0){
            System.out.println(line);
        }
        bufferedReader.close();
    }

    private static void fileReader() throws IOException {
        FileReader fileReader = new FileReader(new File("C:\\jzl\\io.txt"));
        char[] cbuf = new char[64];
        int len = 0;
        while ((len = fileReader.read(cbuf)) != -1){
            System.out.println(new String(cbuf,0,len));
        }
        fileReader.close();
    }


}
