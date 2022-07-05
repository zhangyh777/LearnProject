package com.zyh.demo.Network.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author:zyh
 * Version:1.0
 *
 * 字符流通信
 * 1.写入之后要有flush操作，不然不会保存
 * 2.写入结束标志：Writer.newLine()+socket.shutdownutput()
 *
 */
public class TCPServer2 {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        System.out.println("连接成功");

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }


        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,client");
        //字符流传输数据时,写入结束标志 newLine+shutdownOutput
        bufferedWriter.newLine();
        //Writer要有刷新保存操作
        bufferedWriter.flush();
        socket.shutdownOutput();


        bufferedReader.close();
        bufferedWriter.close();


        socket.close();
        serverSocket.close();
        System.out.println("关闭服务端");


    }
}
