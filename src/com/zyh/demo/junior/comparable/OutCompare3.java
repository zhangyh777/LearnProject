package com.zyh.demo.junior.comparable;

import java.util.Comparator;

/*
    外部比较器3,比较Students对象的score大小
 */
public class OutCompare3 implements Comparator<Students> {
    @Override
    public int compare(Students s1,Students s2){
        //调用Double的compareTo方法
        return ((Double) s1.getScore()).compareTo((Double) s2.getScore());
    }

}
