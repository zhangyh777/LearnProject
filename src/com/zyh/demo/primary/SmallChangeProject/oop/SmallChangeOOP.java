package com.zyh.demo.primary.SmallChangeProject.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeOOP {
    Scanner scanner = new Scanner(System.in);
    boolean loop = true;
//  退出系统判断符
    String flag = "";
//  操作标识符
    String key = "";

    String deatils = "\n--------账户明细--------\n";
    //账户收益
    double money = 0;
    double sum = 0;
    //消费支出
    String shop = "";
    double out = 0;

    Date date = new Date();
    String strDateFormat = "yyyy-MM-dd HH:mm:ss";
    SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
    String fdate = sdf.format(date);

    public void menu() {
        do{
            System.out.println("\n=====零钱通菜单=====");
            System.out.println("\t1 账户明细");
            System.out.println("\t2 收益入账");
            System.out.println("\t3 消费支出");
            System.out.println("\t4 退出系统");
            System.out.println("请进行操作(1~4):");
            key = scanner.next();

            switch (key) {
                case "1":
                   this.showDetails();
                    break;
                case "2":
                    this.moneyIn();
                    break;
                case "3":
                    this.moneyOut();
                    break;
                case "4":
                    this.outSys();
                    break;
                default:
                    System.out.println("操作错误");
            }
        } while (loop);
    }

    public void showDetails() {
        System.out.println(deatils);
    }

    public void moneyIn() {
        System.out.println("收益入账金额：");
        money = scanner.nextDouble();
        //收入金额合理性判断
        if (this.money <= 0) {
            System.out.println("收入金额错误！");
            return;
        }
        sum += this.money;
        deatils += "收益入账：" + this.money
                + "\t" + fdate + "\t"
                + "账户余额：" + sum
                + "\n";
    }

    public void moneyOut() {
        System.out.println("消费支出缘由：");
        shop = scanner.next();
        System.out.println("消费支出金额(负数形式)：");
        out = scanner.nextDouble();
        if (out >= 0 || out > sum) {
            System.out.println("支出金额错误！");
            return;
        }

        sum += out;
        deatils += this.shop + ":" + "\t"
                + out
                + "\t" + fdate + "\t"
                + "账户余额：" + sum
                + "\n";
    }

    public void outSys() {
        while (true) {
            System.out.println("退出系统(y/n)?");
            flag = scanner.next();
//          如果二次确认信息符合规范，则退出二次确认循环，否则什么也不做(继续循环)
            if (flag.equals("y") || flag.equals("n")) {
                break;
            }
        }
//      如果二次确认信息为y，则 loop=false,退出主循环，否则loop=true不变，执行do语句
        if (flag.equals("y")) {
            System.out.println("退出系统!");
            loop = false;
        }
    }
}
