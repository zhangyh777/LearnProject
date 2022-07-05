package com;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;


/**
 * Author:zyh
 * Version:1.0
 */
public class ClientA {
    @SuppressWarnings("all")
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),8888);
        System.out.println("连接成功");


        //IO读取文件
        String filePath = "F:\\CloudMusic\\YOASOBI - ハルカ.flac";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        //数据输出流
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        //发送数据,每次发送一个字节,
        //也可以把读取到的字节存为字节数组(用写好的工具包)
//        byte[] bytes = StreamUtils.streamToByteArray(bis);
//        bos.write(bytes);
        int n = 0;
        while ((n= bis.read())!=-1){
            bos.write(n);
        }
        //发送结束标志
        bos.flush();
        socket.shutdownOutput();

        //接收数据
        InputStream inputStream = socket.getInputStream();
        byte[] b = new byte[1024];
        int N = 0;
        while((N=inputStream.read(b))!=-1){
            System.out.println(new String(b,0,N));
        }

        //关闭IO流和socket
        bos.close();
        bis.close();
        inputStream.close();
        socket.close();



    }
}
