package com.zyh.demo.junior.Collection_.Set_;

/**
 * 模拟
 * 数组+链表+红黑树
 */

public class TestHashSet {
    public static void main(String[] args) {
//      数组
        Node[] table = new Node[16];

        Node tom = new Node("Tom",null);
        Node jerry = new Node("Jerry",null);
        Node satomi = new Node("Satomi",null);
        Node zyh = new Node("Zyh",null);
        table[2] = tom;
//      形成单向链表
//      tom -> jerry -> satomi
        tom.next = jerry;//将jerry节点挂载到tom节点上,
        jerry.next = satomi;//将satomi节点挂载到jerry节点上

        table[3] = zyh;
        System.out.println(table);
        /**     table结构
         *      0   null
         *      1   null
         *      2   tom -> jerry ->satomi -> null
         *      3   zyh -> null
         *      4   null
         *      5   null
         *      ......
         */

    }
}
class Node{
    Object item;
    Node next;
    Node pre;

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }

}
