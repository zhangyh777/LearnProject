package com.zyh.demo.junior.Thread_;

import java.time.LocalDateTime;

/**
 * 线程完成业务代码后会自动退出
 * 也可以使用变量来控制run方法提前结束，即通知方式
 */
public class Thread_Notification {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();//死循环
        Thread.sleep(5000);
        //通知线程结束
        t.setFlag(false);


    }
}

class T extends Thread {
    private boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        //死循环
        while (flag) {
            System.out.println("线程工作中 "
                    + LocalDateTime.now().getHour() + ":"
                    + LocalDateTime.now().getMinute() + ":"
                    + LocalDateTime.now().getSecond());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (flag == false) {
                System.out.println("线程终止");
            }
        }
    }
}
