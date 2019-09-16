package com.jzl.file;

import com.jzl.entity.Weather;
import org.apache.ibatis.annotations.SelectKey;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Set;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 17:17 2019/9/6
 * @Modified By:
 */
public class NioFile {
    public static void main(String[] args) throws IOException {
//        bufferChannel();
//        selector();


        ServerSocket serverSocket = new ServerSocket(9999);
        InetAddress inetAddress = serverSocket.getInetAddress();


        return;
    }

    private static void selector() throws IOException {
        Selector selector = Selector.open();
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        // 感兴趣的集合 准备好的集合 select channel
        SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_READ);
        Weather weather = new Weather();
        selectionKey.attach(weather);
        Object attachment = selectionKey.attachment();

        selector.select();
        Set<SelectionKey> selectionKeys = selector.selectedKeys();
    }

    private static void bufferChannel() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("C:\\jzl\\write.txt"));
        FileOutputStream fileOutputStream = new FileOutputStream(new File("c:\\jzl\\writecopy.txt"));
        FileChannel inChannel = fileInputStream.getChannel();
        FileChannel outChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true){

            int write = inChannel.read(byteBuffer);
            if(write == -1){
                break;
            }
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        inChannel.close();
        outChannel.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
