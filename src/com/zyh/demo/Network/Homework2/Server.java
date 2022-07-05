package com.zyh.demo.Network.Homework2;

import com.zyh.demo.Network.TCP.StreamUtils;

import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author:zyh
 * Version:1.0
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //1.等待连接
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("等待连接");
        Socket socket = serverSocket.accept();
        System.out.println("连接成功");

        //4.接收数据（文件名）
        InputStream inputStream = socket.getInputStream();
        String fileName = "";
        byte[] bytes = new byte[1024];
        int n = 0;
        while((n=inputStream.read(bytes))!=-1){
            fileName = new String(bytes,0,n);
        }

        //5.发送目标文件
        //拼接文件信息
        String resFile = "";
        if("a".equals(fileName)){
            System.out.println("目标文件服务器端有，可以下载");
            resFile = "F:\\a.flac";
        }else{
            System.out.println("目标文件服务器端没有，下载默认文件");
            resFile = "F:\\b.flac";
        }
        //5.1.提取文件内容
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(resFile));
        bytes = StreamUtils.streamToByteArray(bis);
        //5.2.发送文件内容
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        bos.flush();
        socket.shutdownOutput();

        bos.close();
        socket.close();
        serverSocket.close();

    }
}
