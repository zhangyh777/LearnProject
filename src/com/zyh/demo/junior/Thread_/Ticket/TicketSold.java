package com.zyh.demo.junior.Thread_.Ticket;

/**
 * 模拟多线程
 * 三个窗口售票,一共100张票
 * 继承Thread类 或者 实现Runnable接口 来完成
 */
@SuppressWarnings("all")
public class TicketSold {
    public static void main(String[] args) {
        SellTicketA sellTicket1 = new SellTicketA();
//        SellTicketA sellTicket2 = new SellTicketA();
//        SellTicketA sellTicket3 = new SellTicketA();
        sellTicket1.start();
//        sellTicket2.start();
//        sellTicket3.start();

//        SellTicketB b = new SellTicketB();
//
//        Thread thread_1 = new Thread(b);
//        thread_1.start();
//        Thread thread_2 = new Thread(b);
//        thread_2.start();
//        Thread thread_3 = new Thread(b);
//        thread_3.start();

        SellTicketC c = new SellTicketC();
        Thread thread_11 = new Thread(c);
        thread_11.start();
//        Thread thread_22 = new Thread(c);
//        thread_22.start();
//        Thread thread_33 = new Thread(c);
//        thread_33.start();
    }
}

class Ticket {
    public static int ticket = 100;
    public static int num = 0;
    public static Object obj = new Object();
}

@SuppressWarnings("all")
//继承Thread类
class SellTicketA extends Thread {

    @Override
    public void run() {
        while (true) {
            //锁对象,同步的线程要保证操作的是同一个锁对象
            synchronized (Ticket.obj) {
                if (Ticket.ticket <= 0) {
                    System.out.println("票已卖完");
                    break;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("窗口 " + Thread.currentThread().getName()
                        + "卖出第" + (++Ticket.num) + "张票,剩余 " + (--Ticket.ticket) + "张票");
            }

        }
    }
}

@SuppressWarnings("all")
class SellTicketB implements Runnable {

    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            if (Ticket.ticket > 0) {
                System.out.println("窗口 " + Thread.currentThread().getName()
                        + "卖出第" + (++Ticket.num) + "张票,剩余 " + (--Ticket.ticket) + "张票");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("票已卖完");
                loop = false;
            }
        }
    }
}

@SuppressWarnings("all")
class SellTicketC extends Thread {

    private static boolean loop = true;

    //同步方法
    //同步方法如果没有static修饰，默认锁对象为 this;
    //同步方法如果有static修饰，默认锁对象为 当前类.class;
    public static void sell() {
        //要同步的代码，可以单独提出去放到同步代码块，不再用同步方法
        synchronized (SellTicketC.class) {
            if (Ticket.ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("窗口 " + Thread.currentThread().getName()
                        + "卖出第" + (++Ticket.num) + "张票,剩余 " + (--Ticket.ticket) + "张票");
            } else {
                System.out.println("票已卖完");
                loop = false;
            }
        }
    }

    @Override
    public void run() {
        while (loop) {
            //sell();
            //同步代码块
            //synchronized(锁对象){//同步代码...}
            synchronized (Ticket.obj) {//要同步的代码
                if (Ticket.ticket > 0) {
                    System.out.println("窗口 " + Thread.currentThread().getName()
                            + "卖出第" + (++Ticket.num) + "张票,剩余 " + (--Ticket.ticket) + "张票");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("票已卖完");
                    loop = false;
                }
            }
        }
    }
}
