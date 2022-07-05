package com.zyh.hsp_datastructure.datastructure.LinkedList_.Interview.test1;

import java.util.Stack;

/**
 * 1.求单链表中有效结点的个数
 * 2.单链表的反转
 */
public class Test1 {
    public static void main(String[] args) {
        Node node1 = new Node(1001, "zyh");
        Node node3 = new Node(1003, "satomi");
        Node node5 = new Node(1005, "gakki");

        Node node2 = new Node(1002, "aaa");
        Node node4 = new Node(1004, "bbb");
        Node node6 = new Node(1006, "ccc");


        SingleLinkedList sll1 = new SingleLinkedList();
        sll1.head = new Node(1, "sll1");
        sll1.addNode(node1);
        sll1.addNode(node3);
        sll1.addNode(node5);
        sll1.show();

        int count = sll1.getSize(node2);
        System.out.println(count);

        Node n = sll1.getLastKNode(sll1.head, 3);
        System.out.println(n);

        sll1.ReverseLL(sll1.head);
        sll1.show();

        sll1.printReverse(sll1.head);

        SingleLinkedList sll2 = new SingleLinkedList();
        sll2.head = new Node(2, "sll2");
        sll2.addByOrder(node4);
        sll2.addByOrder(node2);
        sll2.addByOrder(node6);
        sll2.show();


    }
}

class SingleLinkedList {
    Node head = new Node(0, "");

    public void addNode(Node node) {
        System.out.println("添加节点 " + node);
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    public void addByOrder(Node orderNode) {
        boolean flag = false;//准备添加的元素是否已经存在的标志
        Node temp = head;
        //死循环遍历链表找最后一个元素
        while (true) {
            //链表满，跳出循环，temp（head）就为最后一个元素
            if (temp.next == null) {
                break;
            }
            //新节点的id小于当前节点的后一个节点的id，准备在这里插入新节点
            if (temp.next.id > orderNode.id) {
                break;
            }
            //新节点的id和当前节点id相同，不让插入
            else if (temp.next.id == orderNode.id) {
                flag = true;
                break;
            }
            //上述条件都不满足，temp后移继续查找
            //退出while循环时，temp此时就是链表最后一个元素
            temp = temp.next;
        }
        if (flag) {
            throw new RuntimeException("链表中已存在相同val的元素");
        } else {
            /**
             指向顺序很重要，语句不能颠倒
             */
            orderNode.next = temp.next;
            temp.next = orderNode;
        }


    }

    public void show() {
        Node temp = head.next;
        if (head.next == null) {
            throw new RuntimeException("链表为空");
        }
        System.out.println("链表 " + head.name + " 结构：");
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }

    //传入链表中的任意节点，获取链表中有效节点个数
    public int getSize(Node head) {
        Node temp = head.next;
        int count = 0;
        if (head.next == null) {
            return 0;
        }
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    //查找链表中倒数第k个节点
    public Node getLastKNode(Node head, int k) {//查找链表中倒数第k个节点
        int sum = getSize(head);
        int headNum = sum + 1 - k;//正着数第几个

        Node temp = head;
        if (head.next == null) {
            return null;
        }
        if (k > sum || k <= 0) {
            return null;
        }
        /* 等效for循环
        for (int i = 0; i < sum-k; i++) {
            temp = temp.next
        }
        */
        while (headNum > 0) {
            temp = temp.next;
            headNum--;
        }
        System.out.println("链表 " + head.name + " 倒数第 " + k + " 个节点为：");
        return temp;
    }

    //链表反转（遍历头插法），原链表的结构随之改变
    public void ReverseLL(Node head) {
        if (head.next == null || head.next.next == null) {//链表为空或者只有一个节点
            return;
        }
        System.out.println("反转后的链表为：");

        Node tempHead = new Node(0, "");//新链表的头结点，同样不存放数据，只是用来存放指针
        Node cur = head.next;
        Node next = null;//存放旧链表当前节点的下一个节点
        while (cur != null) {
            next = cur.next;//存放旧链表的当前节点的下一个节点
            //头插法，将旧链表里从头遍历的节点依次从头插入新链表
            cur.next = tempHead.next;//将当前节点的下一个节点插入到新链表的头节点
            tempHead.next = cur;//新链表头节点的next指向就链表的当前节点temp
            cur = next;
        }
        head.next = tempHead.next;

    }

    //反向打印链表（用栈来实现，原链表的结构不发生变化）
    public void printReverse(Node head) {
        if (head.next == null) {//链表为空
            System.out.println("链表为空");
            return;
        }
        Stack<Node> stack = new Stack();
        Node temp = head;
        while (temp.next != null) {
            stack.add(temp.next);
            temp = temp.next;
        }
        System.out.println("逆序打印链表：");
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    //合并两个有序的单链表，使合并之后的链表依然有序

}


class Node {
    public int id;
    public String name;
    public Node next;

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" + "id=" + id + ", name= '" + name + "\'" + '}';
    }
}
