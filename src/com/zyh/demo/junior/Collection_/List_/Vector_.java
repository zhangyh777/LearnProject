package com.zyh.demo.junior.Collection_.List_;

import java.util.List;
import java.util.Vector;

/**
 * Vector
 * 线程安全
 * 扩容机制：
 * 1.无参构造器
 *    默认容量为10，需要扩容的时候扩容为2倍
 * 2.有参构造器
 *    每次扩容按2倍来扩
 */
public class Vector_ {

    public static void main(String[] args) {
        List vector = new Vector();
        for (int i = 0; i < 12; i++) {
            vector.add(i);
        }
    }
}
