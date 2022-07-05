package com.zyh.demo.Network.TCP;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Author:zyh
 * Version:1.0
 *
 * 字符流通信
 * 1.写入之后要有flush操作，不然不会保存
 * 2.写入结束标志：Writer.newLine()+socket.shutdownutput()
 */
public class TCPClient2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        System.out.println("连接成功");

        OutputStream outputStream = socket.getOutputStream();

        BufferedWriter  bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,server");
        //字符流传输数据时,写入结束标志 newLine+shutdownOutput
        bufferedWriter.newLine();
        //保存
        bufferedWriter.flush();
        socket.shutdownOutput();


        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while((line= bufferedReader.readLine())!=null){
            System.out.println(line);
        }



        bufferedReader.close();

        bufferedWriter.close();

        socket.close();
        System.out.println("关闭客户端");





    }
}
