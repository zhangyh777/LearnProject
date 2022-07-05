package com.zyh.demo.junior.IO;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;

/**
 * Author:zyh
 * Version:1.0
 * 1.根据流向分为输入流和输出流：
 *
 * 2.根据传输数据单位分为字节流和字符流；
 *  * | 抽象基类  | 字节流        | 字符流  |
 *  * | --------| ------------ | ------ |
 *  * | 输入流   | InputStream  | Reader |
 *  * | 输出流   | OutputStream | Writer |
 *  上面的也是 Java IO流中的四大基流。这四大基流都是抽象类，其他流都是继承于这四大基流的。
 *  FileInputStream,FileOutputStream,ByteArrayInputStream,ByteArrayOutputStream,,,
 *  FileReader,FileWriter,CharArrayReader,CharArrayWriter,StringReader,StringWriter,,,
 * 3.根据功能分为节点流和包装流；
 * 节点流：从或向一个特定的地方读或写数据,FileReader,FileWriter,FileInputStream,FileOutputStream
 * 包装流：是对一个已存在的流的连接和封装，通过所封装的流的功能调用实现数据读写。
 *        如BufferedReader.处理流的构造方法总是要带一个其他的流对象做参数。一个流对象经过其他流的多次包装，称为流的链接。
 *
 *  操作 IO 流的模板：
 * 　　①、创建源或目标对象
 * 　　　　输入：把文件中的数据流向到程序中，此时文件是 源，程序是目标
 * 　　　　输出：把程序中的数据流向到文件中，此时文件是目标，程序是源
 * 　　②、创建 IO 流对象
 * 　　　　输入：创建输入流对象
 * 　　　　输出：创建输出流对象
 * 　　③、具体的 IO 操作
 * 　　④、关闭资源
 * 　　　　输入：输入流的 close() 方法
 * 　　　　输出：输出流的 close() 方法
 *
 */
public class io {
    public static void main(String[] args) {

    }
}
