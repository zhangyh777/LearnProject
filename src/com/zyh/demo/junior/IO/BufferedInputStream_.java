package com.zyh.demo.junior.IO;

import java.io.*;

/**
 * Author:zyh
 * Version:1.0
 * BufferedInputStream和BufferedOutputStream对文件按照字节处理，可用来流处理二进制文件(字节),也能处理文本文件(字符)
 * BufferedInputStream接收一个InputStream类对象
 * BufferedOutputStream接收一个OutputStream类对象
 */
public class BufferedInputStream_ {
    /*
     *  二进制文件的读写
     */
    public static void main(String[] args) throws IOException {
        String srcfilePath = "C:\\Users\\zyh\\Desktop\\3.png";
        String destfilePath = "C:\\Users\\zyh\\Desktop\\4.png";
        FileInputStream fileInputStream = new FileInputStream(srcfilePath);
        FileOutputStream fileOutputStream = new FileOutputStream(destfilePath);
        byte[] b = new byte[1024];
        //传入InputStream或者OutputStream对象
        BufferedInputStream bis = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);
        int n = 0;
        try {
            while((n=bis.read(b))!=-1){
            //写入
            bos.write(b,0,b.length);
            }
            System.out.println("完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭
            bos.close();
            bis.close();
        }
    }
}
