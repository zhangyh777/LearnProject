package com.zyh.demo.Network.Homework1;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        Socket socket = new Socket(InetAddress.getLocalHost(),8888);
        //发送数据
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        System.out.println("输入问题");
        String question = scanner.next();
        bw.write(question);
        bw.newLine();
        bw.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line=br.readLine())!=null){
            System.out.println(line);
        }





        socket.close();

    }
}
