package com.zyh.demo.junior.IO;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Author:zyh
 * Version:1.0
 * Reader -> InputStreamReader -> FileReader
 */
public class FileReader_ {
    public static void main(String[] args) {
        FileReaderChar();
        FileReaderCharArr();
    }
    @Test
    public static void FileReaderChar() {
        long start = System.currentTimeMillis();
        //文件路径
        String filePath = "F:\\JavaProjects\\LearnProject\\src\\com\\zyh\\demo\\junior\\IO\\TestFile\\code.txt";
        //FileReader对象
        FileReader input = null;
        int n = 0;
        try {
            input = new FileReader(filePath);
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
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
    //read(char[] arr)
    @Test
    public static void FileReaderCharArr() {
        long start = System.currentTimeMillis();
        String filePath = "F:\\JavaProjects\\LearnProject\\src\\com\\zyh\\demo\\junior\\IO\\TestFile\\code.txt";
        FileReader input = null;
        //长度为10的char数组
        char[] arr = new char[10];
        int n = 0;
        try {
            input = new FileReader(filePath);
            //read(char[] arr),一次性读取arr.length个字节,返回实际读取到的字节的长度（可能小于arr.length）,读完的话返回-1
            while ((n = input.read(arr)) != -1) {
                //通过数组构建字符串,String(char[], int offset, int length)
                System.out.print(new String(arr, 0, n));
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
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
