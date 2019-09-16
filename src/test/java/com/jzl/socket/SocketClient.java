package com.jzl.socket;

import org.junit.Test;

import java.io.*;
import java.net.Socket;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 10:43 2019/9/7
 * @Modified By:
 */
public class SocketClient {
    @Test
    public void socketSend() throws IOException {
        Socket socket = new Socket("10.121.198.68",6066);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        dataOutputStream.writeUTF("HELLO FROM " +socket.getLocalSocketAddress());
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        System.out.println("服务器响应" + dataInputStream.readUTF());
        socket.close();
    }
}
