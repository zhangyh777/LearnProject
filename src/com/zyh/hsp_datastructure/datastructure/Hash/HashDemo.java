package com.zyh.hsp_datastructure.datastructure.Hash;

import java.util.Scanner;

/**
 * 数组+链表 模拟哈希表
 */
public class HashDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(5);
        Scanner scanner = new Scanner(System.in);
        String key = "";
        while (true) {
            System.out.println("输入指令");
            System.out.println("add:添加元素");
            System.out.println("show:显示链表内容");
            System.out.println("find:查找元素");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入name");
                    String name = scanner.next();
                    Employee emp = new Employee(id, name);
                    hashTable.add(emp);
                    break;
                case "show":
                    hashTable.show();
                    break;
                case "find":
                    System.out.println("输入要查找的id");
                    id = scanner.nextInt();
                    hashTable.find(id);
                    break;
                default:
                    break;
            }

        }
    }
}

//哈希表
class HashTable {
    //数组,存放的是链表
    public EmployeeLinkedList[] employeeLinkedListArray;
    public int size;
    
    public HashTable(int size) {
        this.size = size;
        employeeLinkedListArray = new EmployeeLinkedList[size];//数组的大小,即有多少个EmployeeLinkedList链表
        for (int i = 0; i < employeeLinkedListArray.length; i++) {
            employeeLinkedListArray[i] = new EmployeeLinkedList();
        }
    }


    //由id来指定存到哈希表的哪个链表
    public int hashNo(int id) {
        return id % size;
    }

    public void add(Employee emp) {
        int empLinkedListNo = hashNo(emp.id);
        employeeLinkedListArray[empLinkedListNo].add(emp);
    }

    public void show() {
        for (int i = 0; i < employeeLinkedListArray.length; i++) {
            employeeLinkedListArray[i].show(i);
        }
    }

    public void find(int id) {
        int No = hashNo(id);
        Employee cur = employeeLinkedListArray[No].find(id);
        if (cur != null) {
            System.out.printf("在第 %d 条链表找到 id=%d 的元素", No, id);
        } else {
            System.out.println("没有找到id=" + id + " 的元素");
        }
    }
}


//链表
class EmployeeLinkedList {
    public Employee head;
    public void add(Employee emp) {
        //如果链表为空,就直接将元素放到头节点
        if (head == null) {
            head = emp;
            return;
        }
        //如果链表不为空
        //临时节点,用来定位最后的节点
        Employee cur = head;
        //遍历链表找到最后的节点
        while (true) {
            if (cur.next == null) {//cur就是最后的节点,跳出循环
                break;
            }
            cur = cur.next;//cur不是最后的节点,继续往后查找
        }//while循环结束之后cur就定位到了链表最后的节点
        cur.next = emp;
    }

    public void show(int No) {
        if (head == null) {
            System.out.println("第 "+(No+1)+" 条链表为空");
            return;
        }
        System.out.print("第 "+(No+1)+" 条链表内容为：");
        Employee cur = head;
        while (true) {
            System.out.print("=> id=" + cur.id + " name:" + cur.name + " ");
            if (cur.next == null) {
                break;
            }
            cur = cur.next;
        }
        System.out.println();
    }

    public Employee find(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Employee cur = head;
        while (true) {
            if (cur.id == id) {//找到指定id的节点,退出查找
                break;
            }
            if (cur.next == null) {//链表遍历完也没找到指定id的节点
                //bug,当前cur为最后节点(不为空),和指定id的节点不是一个节点,但主动将cur置空,改变了cur的值
                cur = null;
                break;
            }
            cur = cur.next;
        }//while循环走完,要么找到指定id的节点,要么没找到(返回null)
        return cur;
    }
}

//节点
class Employee {
    public int id;
    public String name;
    public Employee next;


    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}