package com.zyh.demo.junior.IO.Homework;


import java.io.*;

/**
 * Author:zyh
 * Version:1.0
 * 1.判断e盘是否有文件夹myTemp,没有的话就创建文件夹
 * 2.在myTemp文件夹下新建hello.txt,写入内容
 * 3.如果hello.txt已存在，提示存在，不再重复创建
 */
public class homework1 {
    public static void main(String[] args) {
        File Path = new File("E:\\myTemp");
        File filePath = new File("E:\\myTemp\\hello.txt");
        if(!Path.exists()){
            System.out.println("e盘下没有myTemp文件夹");
            //创建目录
            Path.mkdir();
            System.out.println("myTemp文件夹创建成功");
        }
        if(filePath.isFile()){
            System.out.println("文件已存在");
        }else{
            //创建文件
            try {
                if(filePath.createNewFile()){
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
                    bufferedWriter.write("hello,world");
                    bufferedWriter.close();
                    System.out.println("文件创建成功");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }



    }
}
