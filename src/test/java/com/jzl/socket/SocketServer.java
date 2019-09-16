package com.jzl.socket;

import org.junit.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 11:00 2019/9/7
 * @Modified By:
 */
public class SocketServer {
    @Test
    public void receive() throws IOException {
        ServerSocket serverSocket = new ServerSocket(6066);
        serverSocket.setSoTimeout(10000);
        while (true){
            System.out.println("等待远程连接,端口号为 : "+ serverSocket.getLocalPort());
            Socket socket = serverSocket.accept();
            System.out.println("远程主机地址 : "+socket.getRemoteSocketAddress());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            System.out.println(dataInputStream.readUTF());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF("Thanks " + socket.getLocalSocketAddress());
            socket.close();
        }
    }
}
