package com.zyh.demo.primary.SmallChangeProject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


/**
 * 1.完成操作界面，并能根据输入进行操作
 * 2.完成账户明细
 * 3.完成收益入账
 *  3.1 入账金额money，余额sum，时间date
 *  3.2 账户明细发生变化
 * 4.完成消费支出
 *  4.1 消费金额out
 *  4.2 账户明细发生变化
 * 5.退出系统
 *  5.1 二次确认是否退出系统
 */
public class SmallChange {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
//      二次确认是否退出系统
        String flag = "";
//      操作标识符
        String key = "";
        String deatils = "\n--------账户明细--------\n";
//      收益，余额，时间
        double money = 0;
        double sum = 0;

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat();
        String fdata = sdf.format(date);
//      消费支出详情
        String shop = "";
        double out = 0;

        do {
            System.out.println("\n=====零钱通菜单=====");
            System.out.println("\t1 账户明细");
            System.out.println("\t2 收益入账");
            System.out.println("\t3 消费支出");
            System.out.println("\t4 退出系统");
            System.out.println("请进行操作(1~4):");
            key = scanner.next();

            switch (key){
                case "1":
                    System.out.println(deatils);
                    break;
                case "2":
                    System.out.println("收益入账金额：");
                    money = scanner.nextDouble();

//                  收入金额合理性判断
                    if(money<=0){
                        System.out.println("收入金额错误！");
                        break;
                    }
                    sum += money;
                    deatils += "收益入账："+money
                            +"\t"+fdata+"\t"
                            +"账户余额："+sum
                            +"\n";

                    break;
                case "3":
                    System.out.println("消费支出缘由：");
                    shop = scanner.next();
                    System.out.println("消费支出金额(负数形式)：");
                    out = scanner.nextDouble();
//                  支出金额合理性判断
                    if(out>=0||out>sum){
                        System.out.printf("支出金额错误,应该在0~%.2f之间.",sum);
                        break;
                    }
                    sum += out;
                    deatils += shop + ":"+"\t"
                            +out
                            +"\t"+fdata+"\t"
                            +"账户余额："+sum
                            +"\n";

                    break;
                case "4":
//                  收到退出指令时，二次确认是否退出
                    while(true){
                        System.out.println("退出系统(y/n)?");
                        flag = scanner.next();
//                      如果二次确认信息符合规范，则退出二次确认循环，否则什么也不做(继续循环)
                        if(flag.equals("y")||flag.equals("n")){
                            break;
                        }
                    }
//                  如果二次确认信息为y，则 loop=false,退出主循环，否则loop=true不变，执行do语句
                    if(flag.equals("y")){
                        System.out.println("退出系统!");
                        loop = false;
                    }
                    break;

                default:
                    System.out.println("操作错误");
            }
        }while (loop);
        System.out.println("!!!!!!!");
    }
}
