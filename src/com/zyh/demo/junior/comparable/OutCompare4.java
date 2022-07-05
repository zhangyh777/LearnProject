package com.zyh.demo.junior.comparable;

import java.util.Comparator;

public class OutCompare4 implements Comparator<Students> {
    @Override
    public int compare(Students s1,Students s2){
        /*
            先比较s1和s2的score,score相同的话继续比较name,否则直接返回score的比较结果
         */
        if (((Double) s1.getScore()).compareTo((Double) s2.getScore())==0){
            return s1.getName().compareTo(s2.getName());
        }
        return ((Double)s1.getScore()).compareTo((Double)s2.getScore());
    }
}
