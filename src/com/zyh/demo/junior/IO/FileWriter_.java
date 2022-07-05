package com.zyh.demo.junior.IO;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Author:zyh
 * Version:1.0
 */
public class FileWriter_ {
    public static void main(String[] args) throws IOException {
//        WriterFile();
        WriterFileCharArr();
    }
    public static void WriterFile() throws IOException {
        //文件路径
        String filePath = "F:\\JavaProjects\\LearnProject\\src\\com\\zyh\\demo\\junior\\IO\\TestFile\\3.txt";
        //FileWriter对象
        FileWriter fileWriter = null;
        try {
            //追加方式
            fileWriter = new FileWriter(filePath,true);
            //写入单个字节
            fileWriter.write('a');
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            //FileWriter对象必须要有flush或者close操作，否则就相当于没保存
//            fileWriter.flush();
            fileWriter.close();
        }
    }
    public static void WriterFileCharArr() throws IOException {
        //文件路径
        String filePath = "F:\\JavaProjects\\LearnProject\\src\\com\\zyh\\demo\\junior\\IO\\TestFile\\3.txt";
        FileWriter fileWriter = null;
        String str = "zhangyunhao";
        try {
            fileWriter = new FileWriter(filePath);
            fileWriter.write(str);
            //指定长度
            fileWriter.write(str,0,5);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            fileWriter.close();
        }
    }
}
