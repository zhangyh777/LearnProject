package com.zyh.demo.Network.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


/**
 * Author:zyh
 * Version:1.0
 */
public class UDPSocket_AA {
    public static void main(String[] args) throws IOException {
        //接收端
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        //DatagramPacket对象,构造器需要byte数组
        //byte数组最大存放64*1024字节
        byte[] bytes = new byte[64*1024];
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length);
        //receive接收数据
        //收到数据之前会阻塞，直到收到数据再往下走
        System.out.println("等待接收数据...");
        datagramSocket.receive(packet);
        //解包
        //1.实际数据长度
        //2.DatagramPacket对象转byte数组
        //3.byte数组转String
        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data, 0, length);
//        String str = new String(packet.getData(),packet.getOffset(), packet.getLength());
        System.out.println(s);

        //发送数据
        byte[] b = "hello,sender".getBytes();
        packet = new DatagramPacket(b,0,b.length, InetAddress.getByName("10.20.155.245"),8887);
        datagramSocket.send(packet);


        //关闭socket
        datagramSocket.close();

    }
}
