package com.zyh.hsp_datastructure.datastructure.Queue_.CircleArrayQueue;

import java.util.Scanner;

public class CircleArrayQueueTest {
    public static void main(String[] args) {
        boolean loop = true;
        char key = ' ';
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(5);
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("输入命令");
            System.out.println("a(add):添加元素到队列");
            System.out.println("s(show):显示队列元素");
            System.out.println("g(get):获取队列元素");
            System.out.println("e(exit):退出系统");
            key = scanner.next().charAt(0);
            switch (key) {
                case 'a':
                    System.out.println("输入要添加的元素：");
                    int num = scanner.nextInt();
                    try{
                        circleArrayQueue.enQueue(num);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 's':
                    System.out.println("队列所有元素为：");
                    try {
                        circleArrayQueue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        int res = circleArrayQueue.getQueue();
                        System.out.println(res);
                    } catch (Exception e) {
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
