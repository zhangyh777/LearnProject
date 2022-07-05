package com.zyh.hsp_datastructure;

import java.util.Scanner;

public class HashTest {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable(5);
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        while (true) {
            System.out.println("输入指令");
            System.out.println("a:添加数据");
            System.out.println("s:显示内容");
            System.out.println("f: id查找");
            System.out.println("e:退出系统");
            key = scanner.next().charAt(0);
            switch (key) {
                case 'a':
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入name");
                    String name = scanner.next();
                    Node node = new Node(id, name);
                    hashtable.add(node);
                    break;
                case 's':
                    hashtable.show();
                    break;
                case 'f':
                    System.out.println("输入查找的id");
                    id = scanner.nextInt();
                    hashtable.findByid(id);
                    break;
                case 'e':
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}

//节点,链表的最小组成部分
class Node {
    public int id;//属性
    public String name;//属性
    public Node next;//next节点,指向下一个节点

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

//链表,由节点组成,add,show,findByid,
class LinkedList {
    //头节点
    public Node head;

    //向链表添加节点（在链表尾部添加）
    public void add(Node node) {
        if (head == null) {//链表为空的情况
            head = node;
            return;
        }
        //临时节点,为了定位最后的节点
        Node cur = head;
        while (true) {//遍历链表查找最后的节点
            if (cur.next == null) {//此时cur就是最后的节点,跳出循环停止查找
                break;
            }
            cur = cur.next;//如果此时cur不是最后的节点的话继续向下查找
        }
        cur.next = node;
    }

    //显示链表内容
    public void show(int No) {
        if (head == null) {
            System.out.println("第 " + (No + 1) + "条链表为空");
            return;
        }
        System.out.print("第 " + (No + 1) + " 条链表内容为");
        Node cur = head;
        while (true) {
            System.out.print("-> id= " + cur.id + " name= " + cur.name + " ");
            if (cur.next == null) {
                break;
            }
            cur = cur.next;
        }
        System.out.println();
    }

    //根据节点id查找节点
    public Node findByid(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }

        Node cur = head;
        while (true) {
            if (cur.id == id) {//找到了
                break;
            }
            if (cur.next == null) {//链表遍历完了也没找到
                cur = null;
                break;
            }
            cur = cur.next;
        }
        return cur;
    }

}

//哈希表,数组链表
class Hashtable {
    //数组链表
    public LinkedList[] LinkedListArray;
    //大小
    public int size;

    //构造器
    public Hashtable(int size) {
        this.size = size;
        LinkedListArray = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            LinkedListArray[i] = new LinkedList();
        }
    }

    //散列值,确定id不同的节点该放到哪个链表里
    public int hashNo(int id) {
        return (id % size);
    }

    //向哈希表里添加节点
    public void add(Node node) {
        //先确定放到哪条链表
        int No = hashNo(node.id);
        LinkedListArray[No].add(node);
    }

    //显示哈希表内容
    public void show() {
        for (int i = 0; i < size; i++) {
            LinkedListArray[i].show(i);
        }
    }

    //根据id在哈希表里查找节点
    //先确定要在哪条链表查找,这样更快,不用查找整个哈希表
    public void findByid(int id) {
        int No = hashNo(id);
        Node cur = LinkedListArray[No].findByid(id);
        if (cur.id == id) {
            System.out.println("在第 " + (No + 1) + " 条链表找到id= " + id + " 的节点");
            return;
        } else {
            System.out.println("没找到id= " + id + " 的节点");
        }
    }
}

