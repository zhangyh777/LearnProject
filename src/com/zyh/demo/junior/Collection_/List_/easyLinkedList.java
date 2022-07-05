package com.zyh.demo.junior.Collection_.List_;

/**
 * LinkedList（链表）
 * 1.底层实现了双向链表和双端队列的特点
 * 2.可以添加任何元素，可以重复，可以为null
 * 3.线程不安全，没有实现同步
 *
 */
public class easyLinkedList {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        Node Tom = new Node("tom");
        Node Jerry = new Node("jerry");
        Node Zyh = new Node("zyh");


//      链接三个节点，组成双向链表
//      正向，Tom -> Jerry -> Zyh
        Tom.next = Jerry;
        Jerry.next = Zyh;
//      反向，Zyh -> Jerry -> Tom
        Zyh.pre = Jerry;
        Jerry.pre = Tom;
//      链表 首,尾
        Node firstN = Tom;
        Node lastN = Zyh;
//      遍历（从头到尾）
        System.out.println("===从头到尾遍历===");
        while (true){
            if(firstN==null){//如果第一个元素为空
                break;
            }
            System.out.println(firstN);
            firstN = firstN.next;//往下走
        }
//      遍历（从尾到头）
        System.out.println("===从尾到头遍历===");
        while (true){
            if(lastN==null){
                break;
            }
            System.out.println(lastN);
            lastN = lastN.pre;
        }
//      链表增删元素
//      1.要增加的对象
        Node Satomi = new Node("satomi");
//      2.链表操作（顺序根据要求改动）
        Jerry.next = Satomi;//4
        Satomi.next = Zyh;//1
        Zyh.pre = Satomi;//3

        Satomi.pre = Jerry;//2

//      上面做过一次正向遍历,结束之后firstN==null,重新定义firstN指向
        firstN = Tom;
        System.out.println("===在Jerry和Zyh之间插入Satomi===");
        while(true){
            if(firstN==null){
                System.out.println("遍历结束");
                break;
            }
            System.out.println(firstN);
            firstN = firstN.next;
        }
    }
}
class Node{
//  属性
    public Object item;
//  向后的节点链接
    public Node pre;
//  向前的节点链接
    public Node next;

    public Node(Object name){
        this.item = name;
    }

    @Override
    public String toString() {
        return "Node Name= "+ item;
    }
}