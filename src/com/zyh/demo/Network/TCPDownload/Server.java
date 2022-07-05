package com.zyh.demo.Network.TCPDownload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //1.等待连接
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("等待连接");

        Socket socket = serverSocket.accept();
        //2.接收数据（文件名）
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        String fileName = "";
        int n = 0;
        byte[] bytes = new byte[1024];
        while((n=bis.read(bytes))!=-1){
            fileName += new String(bytes,0,n);
        }
        //3.拼接文件具体信息
        String filePath = "F:\\"+fileName;
        String resFile = "";
        if("a".equals(fileName)){
            System.out.println("目标文件服务器端有，直接下载");
            resFile = "F:\\a.flac";
        }else{
            System.out.println("目标文件服务器端没有，下载其他文件");
            resFile = "F:\\b.flac";
        }
        //4.读取文件内容
        bis = new BufferedInputStream(new FileInputStream(resFile));

        //5..发送文件内容
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());;
        while((n= bis.read())!=-1){
            bos.write(n);
        }
        bos.flush();


        bis.close();
        bos.close();
        socket.close();
        serverSocket.close();




    }
}
