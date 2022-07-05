package com.zyh.demo.junior.Thread_;
import java.util.Scanner;

/**
 * main线程中创建两个子线程
 * 1.A线程死循环打印100内的整数
 * 2.B线程读到键盘输入Q时终止A线程
 *
 * 分析：线程B能对线程A状态进行控制，
 * 即线程B需要接收一个线程A的对象，这样才能获取线程A的状态
 */
public class Test {
    public static void main(String[] args) {
        AA a = new AA();
        Thread thread_a = new Thread(a);
        thread_a.start();

        BB b = new BB(a);
        Thread thread_b = new Thread(b);
        thread_b.start();
    }

}

class AA implements Runnable {
    private static boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public static boolean isLoop() {
        return loop;
    }

    @Override
    public void run() {
        while(loop){
            System.out.println((int)(Math.random()*100+1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class BB implements Runnable{
    private AA a;

    private Scanner scan = new Scanner(System.in);
    //线程BB接受线程AA的对象
    public BB(AA a){
        this.a = a;
    }

    @Override
    public void run(){
        while(true){
            System.out.println("输入指令（Q表示退出）");
            if(scan.next().charAt(0)=='Q'){//如果键盘输入为Q，则改变线程AA的状态
                a.setLoop(false);
                break;
            }
        }
    }
}
