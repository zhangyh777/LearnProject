package com.zyh.hsp_datastructure.datastructure.LinkedList_.SinglgCircleLinkedList;

import java.util.Random;

/**
 * 单向循环链表
 */
public class SingleCircleLinkedListTest {
    public static void main(String[] args) {
        SingleCircleLinkedList scll = new SingleCircleLinkedList();
        scll.addNode(5);
        scll.show();
        scll.outCircle(1, 2, 5);
    }
}

class SingleCircleLinkedList {
    private Node first = null;
    Random random = new Random();

    //新创建nums个节点
    public void addNode(int nums) {
        //代表当前节点
        Node cur = null;
        if (nums < 1) {
            throw new RuntimeException("节点数不能少于1");
        }
        for (int i = 1; i <= nums; i++) {
            //新添加的节点
            Node nodeX = new Node(i, random.nextInt(100));
            if (i == 1) {//第一个节点,自己构成环
                first = nodeX;
                first.next = first;
                cur = first;
            } else {//第一个节点之后的节点,和前面的节点构成环
                cur.next = nodeX;
                nodeX.next = first;
                cur = nodeX;//cur=cur.next,cur后移
            }
        }
    }

    public void show() {
        if (first == null) {
            throw new RuntimeException("链表为空");
        }
        Node cur = first;
        while (true) {
            System.out.println(cur);
            if (cur.next == first) {
                System.out.println("遍历完毕");
                break;
            }
            cur = cur.next;
        }
        /**
         do {
         System.out.println(cur);
         if (cur.next == first) {
         System.out.println("遍历完毕");
         break;
         }
         cur = cur.next;
         } while (cur.next != null);
         */
    }

    /**
     * @param startNo 从第几个节点数
     * @param count   数多少次
     * @param nums    链表总节点数
     *                从第startNo个数开始数1，之后第count个节点抛出
     */
    public void outCircle(int startNo, int count, int nums) {
        if (startNo < 1 || count < 0 || startNo > nums) {
            throw new RuntimeException("参数错误");
        }
        Node helper = first;
        while (true) {//定位链表最后一个节点helper
            if (helper.next == first) {//只有一个节点
                break;
            }
            helper = helper.next;//后移
        }
        //从第startNo个数开始数
        //正式数之前，first和helper要 前移 startNo-1 个位置，定位到开始数数的位置
        for (int i = 0; i < startNo - 1; i++) {
            first = first.next;
            helper = helper.next;
        }
        //正式开始数数
        while (true) {
            if (helper == first) {//只有一个节点
                break;
            }
            {   //这里只是查找出要抛出的节点，链表结构还没改变
                //总计数count次
                // first和helper要往前移count-1个位置
                for (int i = 0; i < count - 1; i++) {
                    first = first.next;//first前移
                    helper = helper.next;//helper前移
                }
                System.out.println(first);//数完之后,此时first就是要抛出的节点
            }
            {   //找到要抛出的节点后，重新定义指向，抛出的节点随之被回收
                first = first.next;
                helper.next = first;
            }
        }
        System.out.println("链表还留有最后一个节点：" + first);
    }
}

class Node {
    public int id;
    public int score;
    public Node next;

    public Node(int id, int score) {
        this.id = id;
        this.score = score;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node[" + "id:" + id + ",score:" + score + "]";
    }
}
