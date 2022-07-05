package com.zyh.demo.Network.Homework2;

import com.zyh.demo.Network.TCP.StreamUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;


/**
 * TCP下载文件
 * 1.客户端输入mp3文件名传递给服务端，服务端收到数据后给客户端返回这个音乐文件，如果服务器没有这个文件，返回默认的mp3文件
 * 2.客户端收到文件后，保存到本地磁盘
 *
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //2.创建连接
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        System.out.println("连接成功");
        //3.发送数据（文件名）
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入文件名");
        String fileName = scanner.next();
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(fileName.getBytes());
        //停止发送
        socket.shutdownOutput();
        //6.接收数据（文件）
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //7.存储接收到的文件
        bos = new BufferedOutputStream(new FileOutputStream("E:\\test.flac"));
        bos.write(bytes);
        System.out.println("下载成功");
        bos.close();




        socket.close();

    }
}
