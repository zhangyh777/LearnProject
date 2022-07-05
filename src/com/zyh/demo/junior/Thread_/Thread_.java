package com.zyh.demo.junior.Thread_;

import java.time.LocalTime;

/**
 * 创建线程的两种方法
 *
 * run方法是Runnable接口的方法，Thread里的run方法是重写Runnable接口的run方法得来的
 *
 * 1.继承Thread类，重写run方法（自己的代码运行的逻辑）
 *   start方法启动线程A，自动调用A的run方法，
 *   如果不先start方法启动线程A，而是直接在线程B里调用run方法，此时线程不是线程A，而是线程B
 *   继承Thread类的新类，就可以当作线程使用
 *   因为java单继承机制，某个类可能继承了别的类，就不能再继承Thread类，想创建线程的话就要实现Runnable接口来完成
 * 2.实现Runnable接口，重写run方法
 *   避免了单继承限制
 *   没有start方法,只有run方法,创建线程需要静态代理
 *   适合于：多个线程共享一个资源或，
 *
 *
 *   yield和join
 *   yield:静态方法，Thread.yield(),线程的”礼让“,让出cpu,让其他线程先执行,但不一定礼让成功
 *   join:线程的插队,A{B.join()},先执行插队进来的线程B,插队线程执行完毕后再往下执行线程A
 *
 *
 *
 *  synchronized,线程同步
 *  synchronized可以修饰方法,也可以修饰代码块
 *  synchronized(同步操作的对象){//业务代码}
 *
 *  通过加锁和解锁的操作，就能保证多条指令总是在一个线程执行期间，不会有其他线程会进入此指令区间。
 *  即使在执行期线程被操作系统中断执行，其他线程也会因为无法获得锁导致无法进入此指令区间。
 *  只有执行线程将锁释放后，其他线程才有机会获得锁并执行。
 *  这种加锁和解锁之间的代码块我们称之为临界区（Critical Section），任何时候临界区最多只有一个线程能执行。
 *  释放锁的情况：
 *  1.同步方法，同步代码块执行结束之后
 *  2.同步方法，同步代码块中出现break，return之后
 *  3.同步方法，同步代码块中出现未解决的异常，导致异常结束
 *  4.同步方法，同步代码块中执行了线程对象的wait()方法，当前线程暂停
 *    sleep,yield两种方法不会释放锁
 */
@SuppressWarnings("all")
public class Thread_ {
    //主线程main
    public static void main(String[] args) {
        Cat cat = new Cat();//创建线程Cat
        cat.start();//开启线程Cat,自动调用线程Cat的run方法

        //main线程启动子线程时,主线程不会阻塞，而是继续往下执行
        /*
            进程{
                主线程main（如果主线程里只有子线程的东西,那么主线程在创建完子线程之后就结束了）
                子线程Thread-0
                    子线程Thread-i里面还可以再开线程
                子线程Thread-1
                    ...
                ...
            }
            主线程结束时，没结束的子线程并不会强制结束，进程也不会结束，而是等到所有的线程结束，进程才断开
            守护线程：Daemon Thread,守护线程是为其他线程服务的线程
            如果想要在主线程结束时某个子线程也自动结束,可以把该子线程设置为守护线程,调用start()方法前，调用setDaemon(true)把该线程标记为守护线程
            thread_a.setDaemon(true);
            thread.start();
            启动线程之前把线程设置为守护线程
            守护线程不能持有任何需要关闭的资源，例如打开文件等，因为虚拟机退出时，守护线程没有任何机会来关闭文件，这会导致数据丢失。
         */
        for(int i=0;i<100;i++){
            System.out.println("主线程没有被阻塞 "+ i + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //直接调用run方法，不会创建新线程
        //不调用start方法,而是直接调用某个子线程的run方法
        //相当于调用普通方法run,即没有创建新线程
        Dog dog = new Dog();//创建线程，此时线程Dog还没有开启
        dog.run();//没有调用start开启线程,此时还在main线程里,而不是Dog线程


        //A类实现了Runnable接口
        A a = new A();
        //Runnable接口只有run方法，但run方法不会开辟新线程
        a.run();//run方法结束才继续往下执行
        //Thread对象有start方法
        //,创建Thread对象，把实现Runnable接口的类对象传给Thread对象
        A a1 = new A();
        //”静态代理“
        Thread thread_1 = new Thread(a1);
        thread_1.start();

        B b = new B();
        Thread thread_2 = new Thread(b);
        //将thread_2设置为守护线程,本来为死循环，但设置为守护线程之后，主线程一旦结束，该死循环子线程也结束
        thread_2.setDaemon(true);
        thread_2.start();
        //多个线程共享一个资源，没有synchronized同步的话，会出现数据不一致的问题
//        Thread thread_3 = new Thread(b);
//        thread_3.start();




    }

}
@SuppressWarnings("all")
//继承Thread类
class Cat extends Thread{
    int times = 0;
    //重写run方法，放上自己的业务代码
    @Override
    public void run(){
        while(true){
            System.out.println("我是小猫咪"
                                +(times++)+" "
                                +LocalTime.now().getHour()+":"
                                +LocalTime.now().getMinute()+":"
                                +LocalTime.now().getSecond()+" "
                                +"线程名："+Thread.currentThread().getName());
            try {
                Thread.sleep(100);//休眠2s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(times==100){
                break;
            }
        }

    }
}
@SuppressWarnings("all")
class Dog extends Thread{
    int times = 0;
    @Override
    public void run(){
        //Thread.currentThread().getName(),获取线程名字
        while(true){
            System.out.println("我是狗 "+(times++)+" 线程名："+Thread.currentThread().getName());
            if(times==100){
                break;
            }
        }
    }
}
@SuppressWarnings("all")
//实现Runnable接口创建线程
class A implements Runnable{
    int count = 0;
    @Override
    public void run() {
        System.out.println("线程名："+Thread.currentThread().getName());
        while(true){
            System.out.println("hello,world "+(count++));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count==100){
                break;
            }
        }

    }
}
@SuppressWarnings("all")
class B implements Runnable{
    int num = 0;
    @Override
    public void run(){
        System.out.println("线程名："+Thread.currentThread().getName());
        //死循环
        while(true){
            System.out.println("hi "+(num));
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            num++;
        }
    }
}
