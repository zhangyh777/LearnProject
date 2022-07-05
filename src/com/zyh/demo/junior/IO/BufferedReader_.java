package com.zyh.demo.junior.IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Author:zyh
 * Version:1.0
 * BufferedReader和BufferedWriter是对文件按照字符进行处理的,不要用来处理二进制文件（图片，视频，音频，，）
 */
public class BufferedReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "F:\\JavaProjects\\LearnProject\\src\\Readme.txt";
        //节点流FileReader
        FileReader fileReader = new FileReader(filePath);
        //包装流(处理流),接收一个节点流对象,
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        try {
            String line;
            //readLine按行读取文件,读取完毕时返回null
            while((line=bufferedReader.readLine())!=null){
                System.out.println(line);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //直接关闭外层流即可,BufferedReader对象
            bufferedReader.close();
        }
    }
}
