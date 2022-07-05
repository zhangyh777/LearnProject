package com.zyh.demo.junior.IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Author:zyh
 * Version:1.0
 *
 *
 *
 *
 *
 */
public class FileOutStream_ {
    public static void main(String[] args) throws IOException {
//        writeFile();
        writeFileByteArr();
    }
    public static void writeFile() throws IOException {
        //文件路径
        String filePath = "F:\\JavaProjects\\LearnProject\\src\\com\\zyh\\demo\\junior\\IO\\TestFile\\3.txt";
        //FileOutPutStream对象
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filePath);
            //写入单个字节
            fileOutputStream.write('a');
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            fileOutputStream.close();
        }
    }
    public static void writeFileByteArr() throws IOException {
        //文件路径
        String filePath = "F:\\JavaProjects\\LearnProject\\src\\com\\zyh\\demo\\junior\\IO\\TestFile\\3.txt";
        //FileOutPutStream对象
        FileOutputStream fileOutputStream = null;

        String str = "zhangyunhao";
        try {
            //追加方式，写入的话是从末尾开始写，而不是覆盖，默认为false(覆盖)
            fileOutputStream = new FileOutputStream(filePath,true);
            //字符串方法,getBytes(),字符串转byte数组,
            fileOutputStream.write(str.getBytes());
            //指定长度
            fileOutputStream.write(str.getBytes(),0,5);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            fileOutputStream.close();
        }
    }
}
