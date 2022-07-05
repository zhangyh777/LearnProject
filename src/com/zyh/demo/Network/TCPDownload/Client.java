package com.zyh.demo.Network.TCPDownload;

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
 */
public class Client {
    public static void main(String[] args) throws IOException {

        //1.创建连接
        Socket socket = new Socket(InetAddress.getLocalHost(),8888);
        System.out.println("连接成功");
        //2.发送数据（文件名）
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        System.out.println("输入文件名字");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.next();
        bos.write(fileName.getBytes());
        bos.flush();
        socket.shutdownOutput();
        //3.接收数据
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        int n = 0;
        //4.存储数据
        bos = new BufferedOutputStream(new FileOutputStream("E:\\test.flac"));
        while((n=bis.read())!=-1){
            bos.write(n);
        }
//        bos.flush();
        socket.close();



    }
}
