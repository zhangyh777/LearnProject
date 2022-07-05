package com.zyh.demo.junior.IO;

import java.io.File;
import java.io.IOException;

/**
 * Author:zyh
 * Version:1.0
 */
public class CreatFile {
    public static void main(String[] args) {
        creatfile1();
        creatfile02();
        creatfile03();
    }
    //1.文件完整路径
    public static void creatfile1(){
        //File对象
        //File对象既可以表示文件，也可以表示目录。
        // 特别要注意的是，构造一个File对象，即使传入的文件或目录不存在，代码也不会出错，
        // 因为构造一个File对象，并不会导致任何磁盘操作。只有当我们调用File对象的某些方法的时候，才真正进行磁盘操作。
        File file = new File("F:\\JavaProjects\\LearnProject\\src\\com\\zyh\\demo\\junior\\IO\\TestFile\\1.txt");
        File file1 = new File("F:\\A\\");
        try {
            file.createNewFile();
            System.out.println("指定文件完整路径方式创建文件成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //2.父类目录+文件名
    public static void creatfile02(){
        //父类目录
        File parentFilePath = new File("F:\\JavaProjects\\LearnProject\\src\\com\\zyh\\demo\\junior\\IO\\TestFile");
        String name = "2.txt";
        File file = new File(parentFilePath,name);
        try {
            file.createNewFile();
            System.out.println("父类目录+文件名方式创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //3.父类目录+子类目录（+文件名）
    public static void creatfile03(){
        String parentPath = "F:\\JavaProjects\\LearnProject\\src\\com\\zyh\\demo\\junior\\IO\\TestFile\\";
        String childPath1 = "3.txt";
        String childPath2 = "Child\\4.txt";
        File file1 = new File(parentPath,childPath1);
        File file2 = new File(parentPath,childPath2);
        try {
            file1.createNewFile();
            file2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
