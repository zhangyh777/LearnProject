package com.zyh.hsp_datastructure.datastructure.LinkedList_.SingleLinkedList;

/**
 * 单向链表
 */
public class SingleLinkedListTest {
    public static void main(String[] args) {
        Node node1 = new Node(1,"唐僧","师父");
        Node node2 = new Node(2,"孙悟空","大师兄");
        Node node3 = new Node(3,"猪八戒","二师兄");
        Node node4 = new Node(4,"沙悟净","沙和尚");
        Node node5 = new Node(5,"如来佛主","佛主");
        Node node6 = new Node(6,"哪吒","三太子");
        Node node66 = new Node(6,"哪吒","哪托");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addNode(node1);
        singleLinkedList.addNode(node2);
        singleLinkedList.addNode(node6);
        singleLinkedList.addNode(node3);
        singleLinkedList.show();
        System.out.println();
        singleLinkedList.addByOrder(node4);
        singleLinkedList.show();
        singleLinkedList.update(node66);
        singleLinkedList.show();
        singleLinkedList.delNode(5);
    }
}

class SingleLinkedList{
    //头节点
    private Node head = new Node(0,"","");
    //添加节点
    //1.找到当前链表的最后节点
    //2.将当前最后节点的next指向新节点
    public void addNode(Node newNode){
        //头节点不能动，创建临时节点temp来遍历链表
        Node temp = head;
        //死循环遍历链表寻找最后节点
        while(true){
            //当前链表已满
            if(temp.next==null){
                break;
            }
            //temp后移
            temp=temp.next;

        }
        //while循环结束时，temp变为链表的最后节点
        //新节点添加在链表最后
        temp.next = newNode;
    }
    //根据节点某个属性来顺序添加（此处按照val大小顺序添加）
    public void addByOrder(Node orderNode){
        boolean flag = false;//准备添加的元素是否已经存在的标志
        Node temp = head;
        //死循环遍历链表找最后一个元素
        while(true){
            //链表满，跳出循环，temp（head）就为最后一个元素
            if(temp.next==null){
                break;
            }
            //新节点的val小于当前节点的val，准备在这里插入新节点
            if(temp.next.val>orderNode.val){
                break;
            }
            //新节点的val和当前节点val相同，不让插入
            else if(temp.next.val== orderNode.val){
                flag = true;
                break;
            }
            //上述条件都不满足，temp后移继续查找
            //退出while循环时，temp此时就是链表最后一个元素
            temp = temp.next;
        }
        if(flag){
            throw new RuntimeException("链表中已存在相同val的元素");
        }else{
            /**
             指向顺序很重要，语句不能颠倒
             */
            orderNode.next=temp.next;
            temp.next=orderNode;
        }


    }
    //传入属性不完全相同的新的节点，更新节点
    public void update(Node newNode){
        if(head.next==null){//链表为空
            throw new RuntimeException("链表为空，无法更新");
        }
        Node temp = head.next;
        boolean flag = false;
        while(true){
            if(temp==null){//链表为满，不往下继续遍历
                break;
            }
            if(temp.val== newNode.val){//找到目标节点（val属性值相同的节点）
                flag=true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.name = newNode.name;
            temp.nickname = newNode.nickname;
        }else{
            throw new RuntimeException("没有找到val为 "+newNode.val+" 的节点");
        }

    }
    //删除指定节点（要定位到待删除结点的前一个结点）
    public void delNode(int val){
        Node temp = head;
        boolean flag = false;
        //1.先找到待删除结点q的前一个结点p
        //2.待删除结点的前一个结点的next指向待删除结点的下一个节点
        // p.next=q.next=p.next.next
        while(true){//查找待删除结点
            if(temp.next==null){//链表为满，跳出循环，不往下遍历
                break;
            }
            if(temp.next.val==val){//找到指定要删除的节点的前一个结点temp（指定val属性值）
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            //待删除结点的前一个结点的next 指向 待删除结点的下一个节点
            temp.next = temp.next.next;

        }else{
            System.out.println("链表中没有val="+val+"的元素");
        }

    }

    //遍历显示链表
    public void show(){
        //链表为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //链表不为空
        Node temp = head.next;
        while(true){
            if(temp==null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

}
class Node{
    public int val;
    public String name;
    public String nickname;
    public Node next;

    public Node(int val, String name, String nickname) {
        this.val = val;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "name:"+name+" nickname:"+nickname+" val:"+val;
    }
}
