package com.zyh.demo.Network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Author:zyh
 * Version:1.0
 */
public class INetAddress_ {
    public static void main(String[] args) throws UnknownHostException {
        //InetAddress.getLocalHost();主机名+地址
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        System.out.println(localHost.getHostName());//主机名
        System.out.println(localHost.getHostAddress());//地址
        System.out.println(localHost.getAddress());
        //INetAddress.getByName();通过主机名获取InetAddress对象
        InetAddress byName = InetAddress.getByName("DESKTOP-4NBRCP7");
        System.out.println("byName="+byName);
        InetAddress baidu = InetAddress.getByName("www.baidu.com");
        System.out.println(baidu);




    }
}
