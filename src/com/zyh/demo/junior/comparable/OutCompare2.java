package com.zyh.demo.junior.comparable;

import java.util.Comparator;

/*
    外部比较器2,比较Students对象的age大小
 */
public class OutCompare2 implements Comparator<Students> {
    @Override
    public int compare(Students s1,Students s2){
        //直接比较两个age的大小,返回差值
        return s1.getAge()-s2.getAge();
    }
}
