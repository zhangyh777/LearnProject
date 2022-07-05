package com.zyh.demo.Network.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author:zyh
 * Version:1.0
 *
 * Socket对象：一个Socket就是由IP地址和端口号（范围是0～65535）组成，可以把Socket简单理解为IP地址加端口号。
 * Java标准库使用InputStream和OutputStream来封装Socket的数据流
 *
 * 当有多次发送与接收回路时，每次发送之后要有发送结束的说明，没有说明的话发送行为会被阻塞
 * 字节流：socket.shutdownOutput()
 * 字符流：.flush()+.newLine()+.shutdownOutput()
 *
 * 服务端：
 * 1.ServerSocket(int port),指定端口，等待连接
 * 2.没有客户端连接时，程序会阻塞，等待连接，如果有客户端连接，返回Socket对象，程序继续走
 * 3.socket.getInputStream()接收数据,socket.getOutputStream()发送数据,和客户端进行通信
 * 4.关闭socket和IO流
 */
public class TCPServerA {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器端监听9999端口,等待连接");
        //指定端口9999
        ServerSocket serverSocket = new ServerSocket(9999);

        //等待客户端连接
        //.accept(),可以连接多个客户端（并发）
        Socket socket = serverSocket.accept();
        System.out.println("连接成功 socket= "+socket.getClass());

        //接收数据
        InputStream inputStream = socket.getInputStream();
        //IO读写
        byte[] bytes = new byte[1024];
        int readLen=0;
        while ((readLen= inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,readLen));
        }

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,client".getBytes());
        outputStream.write("hhhhh".getBytes());
        //发送结束标记，没有该标记的话，接收方无法判断接受动作是否结束，会阻塞通信
        socket.shutdownOutput();


        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("关闭服务端");


    }
}
