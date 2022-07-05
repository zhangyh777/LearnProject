package com.zyh.hsp_datastructure.algorithm.leetcodePrimary.doubleLinkedlist;

public class Test {
    public static void main(String[] args) {
        MyLinkedList mll = new MyLinkedList();
        mll.addAtHead(1);
        mll.addAtTail(3);
        mll.addAtIndex(1, 2);
        mll.show();
        mll.deleteAtIndex(3);
        mll.show();


    }
}

/*

 */
class MyLinkedList {
    //链表大小,便于后续索引操作
    int size;
    //伪头和伪尾
    ListNode dummyHead, dummyTail;

    public MyLinkedList() {
        size = 0;
        dummyHead = new ListNode(0);
        dummyTail = new ListNode(0);
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }
    public void show(){
        ListNode cur = dummyHead.next;
        while (cur!=null&&cur.next!=null){
            System.out.println(cur);
            cur=cur.next;
        }
        System.out.println("======");
    }

    /**
     * get(index)：获取链表中第index个节点的值。如果索引无效，则返回-1
     * @param index
     * @return
     */
    public int get(int index) {

        if (index < 0 || index >= size) {
            return -1;
        }

        //看索引的相对位置,决定从头找还是从尾找
        ListNode cur = dummyHead;
        //从头找
        if (index + 1 < size - index) {
            for (int i = 0; i < index + 1; ++i) {
                cur = cur.next;
            }

        } else {//从尾找
            cur = dummyTail;
            for (int i = 0; i < size - index; ++i) {
                cur = cur.pre;
            }
        }
        return cur.val;
    }

    /**
     * addAtHead(val)：在链表的第一个元素之前添加一个值为val的节点。插入后，新节点将成为链表的第一个节点。
     * @param val
     */
    public void addAtHead(int val) {
        ListNode cur = dummyHead;

        ++size;
        ListNode toAdd = new ListNode(val);
        toAdd.next = cur.next;
        cur.next.pre = toAdd;
        cur.next = toAdd;
        toAdd.pre = cur;
    }

    /**
     * addAtTail(val)：将值为val 的节点追加到链表的最后一个元素。
     * @param val
     */
    public void addAtTail(int val) {
        ListNode cur = dummyTail;

        ++size;
        ListNode toAdd = new ListNode(val);
        ListNode pre = cur.pre;

        toAdd.next=dummyHead;
        toAdd.pre=cur.pre;
        cur.pre.next=toAdd;
        cur.pre=toAdd;
    }


    /**
     * addAtIndex(index,val)：在链表中的第index个节点之前添加值为val 的节点。
     * 如果index等于链表的长度，则该节点将附加到链表的末尾。
     * 如果 index 大于链表长度，则不会插入节点。
     * 如果index小于0，则在头部插入节点。
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {

        if (index > size) {
            return;
        }

        if (index < 0) {
            index = 0;
        }

        ListNode pred, succ;
        //插入位置距离链表头比较近
        if (index < size - index) {
            pred = dummyHead;
            for (int i = 0; i < index; ++i) {
                pred = pred.next;
            }
            succ = pred.next;
        } else {//插入位置距离链表尾比较近
            succ = dummyTail;
            for (int i = 0; i < size - index; ++i) {
                succ = succ.pre;
            }
            pred = succ.pre;
        }

        ++size;
        ListNode toAdd = new ListNode(val);
        toAdd.pre = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.pre = toAdd;
    }

    /**
     * deleteAtIndex(index)：如果索引index 有效，则删除链表中的第index 个节点。
     * @param index
     */
    public void deleteAtIndex(int index) {

        if (index < 0 || index >= size) {
            return;
        }

        ListNode pred, succ;
        if (index < size - index) {
            pred = dummyHead;
            for (int i = 0; i < index; ++i) {
                pred = pred.next;
            }
            succ = pred.next.next;
        } else {
            succ = dummyTail;
            for (int i = 0; i < size - index - 1; ++i) {
                succ = succ.pre;
            }
            pred = succ.pre.pre;
        }

        --size;
        pred.next = succ;
        succ.pre = pred;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode pre;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode [val="+val+"]";
    }
}

