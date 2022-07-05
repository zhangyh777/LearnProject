package com.zyh.demo.Network.TCP;

/**
 * TCP协议：
 * 一种面向连接，可靠传输的协议；
 * 在传输数据之前需要先建立连接，建立连接后才能传输数据，
 * 传输完后还需要断开连接
 *
 * java TCP编程核心类：ServerSocket,Socket
 *
 * 服务端：
 * 服务器端用ServerSocket监听指定端口；
 * 服务器端用accept()接收连接并返回Socket；
 * 客户端：
 * 客户端使用Socket(InetAddress, port)连接服务器；
 *
 * 双方通过Socket打开InputStream/OutputStream读写数据；
 * 服务器端通常使用多线程同时处理多个客户端连接，利用线程池可大幅提升效率；
 * flush()用于强制输出缓冲区到网络。
 */
public class TCP {
    public static void main(String[] args) {

    }
}
