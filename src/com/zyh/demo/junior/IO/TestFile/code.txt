package com.zyh.demo.junior.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Author:zyh
 * Version:1.0
 * 文件拷贝：
 *  1.读取文件，
 *  2.将读取到的内容写到另一个文件中
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {
        String srcfilePath = "C:\\Users\\zyh\\Desktop\\3.png";
        String destfilePath = "C:\\Users\\zyh\\Desktop\\4.png";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        //一次读取1024个字节
        byte[] arr = new byte[1024];
        int n = 0;
        try {
            fileInputStream = new FileInputStream(srcfilePath);
            fileOutputStream = new FileOutputStream(destfilePath);
            n = fileInputStream.read(arr);
            while (n != -1) {
                //写入文件,每次写入实际读到的字节数，而不是写入指定长度的字节，避免写入空白
                fileOutputStream.write(arr,0,n);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            fileInputStream.close();
            fileOutputStream.close();
        }

    }
}
