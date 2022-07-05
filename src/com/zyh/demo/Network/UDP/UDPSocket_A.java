package com.zyh.demo.Network.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;



/**
 * Author:zyh
 * Version:1.0
 */
public class UDPSocket_A {
    public static void main(String[] args) throws IOException {
        //发送端
        DatagramSocket datagramSocket = new DatagramSocket(8887);
        //封装数据DatagramPacket传入byte数组，长度，主机，端口
        byte[] bytes = "hello,receiver".getBytes();
        //指定主机+端口
        DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length, InetAddress.getByName("10.20.155.245"),8888);
        //发送数据
        datagramSocket.send(packet);


        //接收数据
        byte[] b = new byte[64*1024];
        packet = new DatagramPacket(b,b.length);
        datagramSocket.receive(packet);
        //解包
        String s = new String(packet.getData(),packet.getOffset(), packet.getLength());
        System.out.println(s);


        datagramSocket.close();


    }
}
