package com.zyh.demo.Network.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;


/**
 * Author:zyh
 * Version:1.0
 * 客户端：
 * 1.Socket(InetAddress ip,int port)获取服务器端IP，通信端口，连接服务器，连接成功的话返回Socket对象
 * 2.socket.getOutputStream()发送数据,socket.getInputStream()接收数据，和服务端进行通信
 * 3.关闭socket和IO流
 */
public class TCPClientA {
    public static void main(String[] args) throws IOException {
        //连接指定主机的指定端口（这里是本机作为客户端,端口为9999）
        //如果连接成功，返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        System.out.println("客户端 socket= "+socket.getClass());
        //发送数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,server".getBytes());
        //发送结束标记
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        int n = 0;
        byte[] b = new byte[1024];
        while((n= inputStream.read(b))!=-1){
            System.out.println(new String(b,0,n));
        }


        //关闭流
        inputStream.close();
        outputStream.close();
        socket.close();

        System.out.println("关闭客户端");

    }
}
