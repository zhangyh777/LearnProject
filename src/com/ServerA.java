package com;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author:zyh
 * Version:1.0
 */
public class ServerA {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();

        System.out.println("连接成功");

        //接收数据
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        //存储数据
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\a.flac"));
//        //每次写入一个字节数组
//        byte[] bytes = StreamUtils.streamToByteArray(bis);
//        bos.write(bytes);
        //每次写入一个字节
        int n = 0;
        while((n=bis.read())!=-1){
            bos.write(n);
        }


        //发送数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("成功接收文件".getBytes());
        socket.shutdownOutput();
        //关闭IO流和socket
        bos.close();
        bis.close();
        outputStream.close();
        socket.close();
        serverSocket.close();




    }
}
