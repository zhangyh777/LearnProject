package com.zyh.demo.junior.IO;

import java.io.*;

/**
 * Author:zyh
 * Version:1.0
 *
 * 转换流：InputStreamReader和OutputStreamWriter
 * InputStreamReader:Reader的子类，可以将InputStream(字节流)包装转换成Reader(字符流)
 * InputStreamReader(InputStream,Charset),指定字符编码
 * OutputStreamWriter:Writer的子类，可以将OutputStream(字节流)包装转换成Writer(字符流)
 * OutputStreamWriter(OutputStream,Charset),指定字符编码
 *
 *
 */
public class transferStream {
    public static void main(String[] args) throws IOException {
        //源文件编码格式为utf-8,中文输出乱码
        String filePath = "F:\\JavaProjects\\LearnProject\\src\\com\\zyh\\demo\\junior\\IO\\TestFile\\InputStreamReader.txt";
        BufferedReader br = new BufferedReader(
                                    new InputStreamReader(
                                            new FileInputStream(filePath),"gbk"));
        String line;
        while((line = br.readLine())!=null){
            System.out.println(line);
        }
        br.close();

        String filePath2 = "F:\\JavaProjects\\LearnProject\\src\\com\\zyh\\demo\\junior\\IO\\TestFile\\OutputStreamWriter.txt";
        String charset = "gbk";
        OutputStreamWriter osw = new OutputStreamWriter(
                                            new FileOutputStream(filePath2),charset);
        osw.write("zhangyunhao张云浩");
        System.out.println("文件按照"+charset+"格式保存成功");
        osw.close();



    }
}
