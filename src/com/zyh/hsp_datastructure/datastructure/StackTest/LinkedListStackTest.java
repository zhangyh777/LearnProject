package com.zyh.hsp_datastructure.datastructure.StackTest;

public class LinkedListStackTest {
    public static void main(String[] args) {
        LinkedListStack lls = new LinkedListStack();
        lls.add(new Node(1001));
        lls.add(new Node(1002));
        lls.add(new Node(1003));
        lls.add(new Node(1004));
        lls.add(new Node(1005));
        lls.add(new Node(1006));

        System.out.println(lls.isEmpty());

        System.out.println(lls.pop());
        System.out.println(lls.pop());
        System.out.println(lls.pop());


    }
}

class LinkedListStack {
    public Node top = new Node(999);

    public boolean isEmpty() {
        return top.next == null;
    }

    public void add(Node node) {
        if (isEmpty()) {
            top.next = node;
            return;
        }
        Node temp = top.next;
        node.next = temp;
        top.next = node;

    }

    public Node pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空，无法出栈");
        }
        Node temp = top.next;//临时存储出栈的节点
        top.next = top.next.next;
        return temp;//出栈
    }

}

class Node {
    public int id;
    public Node next;

    public Node(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Node[" + "id= " + id + "]";
    }
}
