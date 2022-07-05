package com.zyh.demo.junior.IO;

import java.io.File;
import java.io.IOException;

/**
 * Author:zyh
 * Version:1.0
 *
 * boolean mkdir()：创建当前File对象表示的目录；只能创建一次单层目录，必须指定上层的父类目录
 * boolean mkdirs()：创建当前File对象表示的目录，多级目录，并在必要时将不存在的父目录也创建出来；
 * boolean delete()：删除当前File对象表示的目录，当前目录必须为空才能删除成功。
 *
 */

public class DirOperation {
    public static void main(String[] args) {
        make();
    }
    public static void make(){
        File file = new File("F:\\A\\aa\\aaa");
        if(file.exists()){
            System.out.println("目录已存在");
            if(file.delete()){
                System.out.println("删除成功");
            }else{
                System.out.println("目录不为空，无法删除");
            }
        }else{
            if(file.mkdir()){
                System.out.println("创建成功");
            } else{
                System.out.println("创建失败");
            }
        }
    }
}

