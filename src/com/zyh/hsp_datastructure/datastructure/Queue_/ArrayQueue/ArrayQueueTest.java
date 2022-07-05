package com.zyh.hsp_datastructure.datastructure.Queue_.ArrayQueue;

import java.util.Scanner;

public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        char key = ' ';
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while(loop){
            System.out.println("输入命令：");
            System.out.println("a(add):添加元素到队列");
            System.out.println("s(show):显示队列");
            System.out.println("h(head):显示队列头部元素");
            System.out.println("g(get):获取队列元素");
            System.out.println("e(exit:退出系统");
            key = scanner.next().charAt(0);
            switch (key){
                case 'a':
                    System.out.println("输入添加的元素");
                    int num = scanner.nextInt();
                    try{
                        arrayQueue.enQueue(num);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 's':
                    try{
                        arrayQueue.showQueue();
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int head = arrayQueue.headQueue();
                        System.out.printf("队列头部元素为%d",head);
                        System.out.println();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'g':
                    try{
                        int res = arrayQueue.deQueue();
                        System.out.printf("取出的元素为%d",res);
                        System.out.println();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'e':
                    loop = false;
                    break;
            }

        }
    }
}
