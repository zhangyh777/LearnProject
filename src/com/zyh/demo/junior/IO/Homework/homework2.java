package com.zyh.demo.junior.IO.Homework;

import java.io.*;

/**
 * Author:zyh
 * Version:1.0
 */
@SuppressWarnings("all")
public class homework2 {
    public static void main(String[] args) throws IOException {
        String filePath = "e:\\myTemp\\hello.txt";
        try {
            //默认utf-8编码输出
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            //文件编码为gbk,默认以utf-8输出，会乱码，需要用转换流(InputStreamReader,OutputStreamWriter)指定编码
            BufferedReader bufferedReader1 = new BufferedReader(
                                                    new InputStreamReader(
                                                            new FileInputStream(filePath),"gbk"));
            String line1;
            String line2;
            int lineNum = 0;
            while((line1 = bufferedReader.readLine())!=null){
                System.out.println((++lineNum)+" "+line1);
            }

            while((line2 = bufferedReader1.readLine())!=null){
                System.out.println(++lineNum +" "+ line2);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
