package com.zyh.demo.junior.IO;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Author:zyh
 * Version:1.0
 * 打印流：PrintStream,字节打印
 *       PrintWriter,字符打印
 *       只有输出流,没有输入流
 */
public class printStream {
    public static void main(String[] args) throws IOException {
        //字节打印流
        PrintStream out = System.out;//显示器输出
        //print方法底层调用的还是write,因此可以直接调用write
        //write(int n),write(byte[] b),write(byte[],offset,len)
        out.print("hello");
        out.write(99);
        out.write("张云浩".getBytes());
        //修改打印位置,默认是在屏幕打印
        //在文件里打印
        System.setOut(new PrintStream("F:\\JavaProjects\\LearnProject\\src\\com\\zyh\\demo\\junior\\IO\\TestFile\\printStream.txt"));
        System.out.print("修改打印位置为文件内");
        out.close();

        //字符打印流
        //输出到显示器
//        PrintWriter printWriter = new PrintWriter(System.out);
        //输出到文件内
        PrintWriter printWriter = new PrintWriter("F:\\JavaProjects\\LearnProject\\src\\com\\zyh\\demo\\junior\\IO\\TestFile\\printWriter.txt");
        printWriter.print(1224);
        printWriter.close();//打印到文件内时，必须要close，不然不会保存




    }
}
