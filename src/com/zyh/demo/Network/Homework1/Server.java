package com.zyh.demo.Network.Homework1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 字符流
 * 客户端发送“name”,服务器收到后回复“我是xxx”,
 * 客户端发送“hobby”,服务器收到后回复“打球”,
 * 如果不是这两个回答，客户端回复“what”
 *
 */
public class Server {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        //接收数据
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String s = br.readLine();
        String answer = "";

        if("name".equals(s)){
            answer = "zyh";
        }else if("hobby".equals(s)){
            answer = "play ball";
        }else{
            answer = "what";
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(answer);
        bw.flush();
        bw.newLine();






        socket.close();
        serverSocket.close();
    }
}
