package com.zyh.demo.junior.Collection_;

import java.util.HashMap;
import java.util.Objects;

public class HashAdd {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i <= 11; i++) {
            hashMap.put(new A(i),"hello");
        }
    }
}
class A{
    private int id;

    public A(int id) {
        this.id = id;
    }

//  确保每个A对象的hash值都是一样的，以便放到数组的同一个链表中
    @Override
    public int hashCode() {
        return 100;
    }
}