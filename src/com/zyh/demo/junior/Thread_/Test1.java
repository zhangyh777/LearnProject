package com.zyh.demo.junior.Thread_;

import javax.swing.plaf.IconUIResource;

/**
 * 银行卡取钱问题
 * 卡上余额1w，2个人用，每次取1k，
 * 发现余额不足时，禁止取款
 */
public class Test1 {
    public static void main(String[] args) {
        User user1 = new User();
        Thread thread1 = new Thread(user1);
        Thread thread2 = new Thread(user1);

        thread1.start();
        thread2.start();
    }
}

class User implements Runnable {
    public static int count = 0;

    private static int sum = 10000;
    private boolean loop = true;

    public void dec() {
        synchronized (this) {
            if (sum >= 1000) {
                sum -= 1000;
                count += 1;
                System.out.println(Thread.currentThread().getName() + "取钱" + count + "次，还剩(" + sum + ")元");
            } else {
                System.out.println("余额不足");
                loop = false;
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (loop) {
            dec();
        }
    }
}
