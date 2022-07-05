package com.zyh.demo.junior.IO;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Author:zyh
 * Version:1.0
 * InputStream,抽象类,
 * 常用实现子类：FileInputStream,BufferedInputStream,ObjectInputStream
 * | 抽象基类  | 字节流        | 字符流  |
 * | --------| ------------ | ------ |
 * | 输入流   | InputStream  | Reader |
 * | 输出流   | OutputStream | Writer |
 */
public class FileInputStream_ {
    public static void main(String[] args) {
        FileReadChar();
        FileReadByteArr();
    }

    public static void FileReadChar() {
        //文件路径
        String filePath = "F:\\JavaProjects\\LearnProject\\src\\Readme.txt";
        //FileInputStream对象
        FileInputStream input = null;
        int n = 0;
        try {
            input = new FileInputStream(filePath);
            //read(),返回的是读取的单个字节的ASCII编码,如果读完的话返回-1
            while ((n = input.read()) != -1) {//如果读到字节
                System.out.print((char) n);//打印字符
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {//关闭文件流
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //read(byte[] b)
    public static void FileReadByteArr() {
        String filePath = "F:\\JavaProjects\\LearnProject\\src\\Readme.txt";
        FileInputStream input = null;
        //长度为5的byte数组
        byte[] arr = new byte[5];
        int n = 0;
        try {
            input = new FileInputStream(filePath);
            //read(byte[] b),一次性读取b.length个字节,返回实际读取到的字节的长度（可能小于b.length）,读完的话返回-1
            while ((n = input.read(arr)) != -1) {
                //通过数组构建字符串,String(byte[], int offset, int length)
                System.out.println(new String(arr, 0, n));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
