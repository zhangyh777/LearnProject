package com.zyh.hsp_datastructure.datastructure.LinkedList_.DoubleLinkedList;

/**
 * 双向链表
 */
public class DoubleLinkedListTest {
    public static void main(String[] args) {
        Node node1 = new Node(2020001, 96.3);
        Node node2 = new Node(2020002, 89.7);
        Node node3 = new Node(2020003, 96);
        Node node4 = new Node(2020004, 97);
        Node node44 = new Node(2020004, 100);

        DoubleLinkedList dll = new DoubleLinkedList();

        dll.addByOrder(node1);

        dll.add(node2);
        dll.add(node3);
        dll.add(node4);
        dll.show();
        dll.delNode(node2);
        dll.delNode(node4);
        dll.show();

    }
}

class DoubleLinkedList {
    Node head = new Node(0, 0);

    //链表尾部插入元素
    public void add(Node node) {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    //链表指定位置插入元素
    public void addByOrder(Node node) {
        Node temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id > node.id) {
                break;
            } else if (temp.id == node.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            throw new RuntimeException("链表中存在相同id的结点，无法重复添加");
        } else {
            node.next = temp.next;
            temp.next = node;
            node.pre = temp;
            temp.next.pre = node;

        }

    }

    //双向链表删除时直接定位到待删除结点（而不是单链表那样定位到前一个结点）
    public void delNode(Node node) {
        if(head.next==null){
            throw new RuntimeException("链表为空，无法删除");
        }
        Node temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.id == node.id) {//temp就是要删除的节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {//删除节点temp，链表结构发生变化
            System.out.println("删除id= " + node.id + " 的节点");
            temp.pre.next = temp.next;
            if(temp.next!=null){//只有要删除的节点不在链表尾部时才需要为temp.next.pre定义新指向
                                //要删除的节点temp在链表尾部的话，temp.next就为null了,不需要再为pre定义指向
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("没有找到id= " + node.id + " 的结点，无法删除指定节点");
        }

    }
    //更新指定属性节点的属性
    public void update(Node node){
        if(head.next==null){
            throw new RuntimeException("链表为空，无法更新");
        }
        Node temp = head.next;
        boolean flag = false;
        while(true){
            if(temp==null){
                break;
            }if(temp.id== node.id){//找到属性为指定值的节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.score= node.score;
        }else{
            System.out.println("无法更新");
        }
    }
    //忽略头节点打印链表
    public void show() {
        Node temp = head.next;//忽略头节点，所以temp初始节点取head.next
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class Node {
    int id;
    double score;
    //两个指针，一个指向下一个节点，一个指向上一个节点
    Node next;
    Node pre;

    public Node(int id, double score) {
        this.id = id;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Node[" + "id:" + id + " ,score:" + score + "]";
    }
}
