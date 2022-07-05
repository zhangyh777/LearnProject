package com.zyh.hsp_datastructure.datastructure.LL;

import java.util.Scanner;

public class SSLT {
    public static void main(String[] args) {
        Node node1 = new Node(1001, 16, 89, "zjh");
        Node node2 = new Node(1002, 18, 99, "zyh");
        Node node3 = new Node(1003, 17, 69, "satomi");
        Node node4 = new Node(1004, 16, 79, "gakki");
        SSL link = new SSL();
        link.addNode(node1);
        link.addNode(node4);
        link.addNode(node2);
        link.show();

        link.addByOrder(node3);
        link.show();

        link.delNode(10000);
        link.show();
        link.delNode(1004);
        link.show();

        Node node33 = new Node(1003, 17, 81, "satomi");
        link.update(node33);
        link.show();

        Node node44 = new Node(1004, 17, 81, "gakki");
        link.update(node44);
        link.show();
//        Scanner scanner = new Scanner(System.in);
//        char key = ' ';
//        SSL link = new SSL();


    }
}

class SSL {
    Node head = new Node(0, 0, 0, "");

    //链表尾部加入新元素
    //目标是找到链表最后的节点
    //再把最后的节点的next指向新节点
    public void addNode(Node newNode) {
        //head结点不能动，用临时结点指代
        Node temp = head;
        while (temp.next != null) {//链表非空的话
            temp = temp.next;//temp指针往后移
        }
        temp.next = newNode;//while循环结束，temp就为链表尾部结点，将新节点放到temp节点后面，新节点变为尾部节点
        newNode.next = null;//新节点为尾部节点，next指向null
    }

    public void addByOrder(Node orderNode) {
        Node temp = head;
        boolean flag = false;
        //找出要插入结点orderNode之前的那个结点temp
        //按id从小到大排
        while (true) {
            if (temp.next == null) {//temp在链表尾部
                break;
            }
            //node1->node2->node4,插入node3的话,应该在node2和node4之间插入
            //新的结点指向：
            //temp就是node2,
            // newNode.next=temp.next (->node4)
            // (node2.next->) temp.next=newNode
            if (temp.next.id > orderNode.id) {//满足这个条件的话，temp就是要找的node2
                break;
            } else if (temp.next.id == orderNode.id) {
                throw new RuntimeException("id为 " + orderNode.id + " 的元素已存在，无法插入");
            }
            temp = temp.next;
        }
        //while循环遍历完的话，temp要么是链表尾部结点(指定插入条件未满足，跑到链表尾部插入)，要么是满足插入条件的结点
        orderNode.next = temp.next;
        temp.next = orderNode;

    }

    //删除属性为指定值的结点
    public void delNode(int id) {
        Node temp = head;
        boolean flag = false;
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        while (true) {
            if (temp.next == null) {//遍历完了链表
                break;
            }
            if (temp.next.id == id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("没有找到id为 " + id + " 的结点，无法进行删除操作");
        }

    }

    public void update(Node updateNode) {
        Node temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {//遍历完了链表
                break;
            }
            if (temp.id == updateNode.id) {//找到某个属性为目标值的结点，temp就是该节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.score = updateNode.score;//更新属性值
        } else {
            throw new RuntimeException("没有找到id为 " + updateNode.id + " 的结点");
        }
    }

    //遍历显示链表，忽略头结点
    public void show() {
        Node temp = head.next;//temp结点为头结点的后一个结点
        System.out.println("链表元素为：");
        while (temp != null) {//链表非空
            System.out.println(temp);
            temp = temp.next;
        }
        System.out.println();
    }
}


class Node {
    public int id;
    public int age;
    public float score;
    public String name;

    public Node next;

    public Node(int id, int age, float score, String name) {
        this.id = id;
        this.age = age;
        this.score = score;
        this.name = name;

    }

    @Override
    public String toString() {
        return "[id:" + id + " age:" + age + " name:" + name + " score:" + score + "]";
    }

}