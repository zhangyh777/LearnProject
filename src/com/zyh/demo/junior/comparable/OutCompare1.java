package com.zyh.demo.junior.comparable;

import java.util.Comparator;

/*
    外部比较器,实现Comparator接口,重写compare方法
    外部比较器1,比较Students对象的name（按字符顺序）
 */
public class OutCompare1 implements Comparator<Students> {
    @Override
    public int compare(Students s1,Students s2) {
        //调用String的compareTo方法
        return s1.getName().compareTo(s2.getName());
    }
}
