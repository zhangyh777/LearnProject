package com.zyh.demo.Network.TCP;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;


/**
 * Author:zyh
 * Version:1.0
 */
public class TPCClient3 {
    public static void main(String[] args) throws IOException {
        //2.创建连接
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        System.out.println("连接成功");
        String filePath = "C:\\Users\\zyh\\Desktop\\java\\Map.png";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        //将读取到的字节存到字节数组中
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //3.发送数据
        //3.1.缓冲输出流
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        //3.2.将字节数组放到输出流中发送出去
        bos.write(bytes);
        //3.3.停止发送
        socket.shutdownOutput();
        //6.接收数据
        InputStream inputStream = socket.getInputStream();
        int n=0;
        byte[] b = new byte[1024];
        while((n=inputStream.read(b))!=-1){
            System.out.println(new String(b,0,n));
        }
        inputStream.close();
        bis.close();
        socket.close();


    }
}
