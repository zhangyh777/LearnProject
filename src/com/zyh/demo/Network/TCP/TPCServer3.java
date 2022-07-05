package com.zyh.demo.Network.TCP;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author:zyh
 * Version:1.0
 *
 * 1.服务器端在8888端口监听
 * 2.客户端发送图片到服务器端
 * 3.服务器端接收到图片后保存到src目录下，发送消息”收到图片“给客户端
 * 4.客户端收到信息后再退出
 *
 *
 */
public class TPCServer3 {
    public static void main(String[] args) throws IOException {
        //1.等待连接
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        System.out.println("连接成功");



        //4.接收数据
        //4.1.缓冲输入流
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        //4.2.读取文件内容
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //4.3.存储文件内容
        String savePath = "src\\a.png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(savePath));
        bos.write(bytes);
        bos.close();
        //5.发送数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("成功接收图片".getBytes());
        //停止发送
        socket.shutdownOutput();

        outputStream.close();
        bis.close();
        socket.close();
        serverSocket.close();
    }
}
