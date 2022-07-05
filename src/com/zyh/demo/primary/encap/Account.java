package com.zyh.demo.primary.encap;

public class Account {
    String name;
    private int money;
    private String pswd;

    public Account(String name, int money, String pswd) {
        setName(name);
        setMoney(money);
        setPswd(pswd);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 2 || name.length() > 4) {
            System.out.println("名字长度错误(1<name<5)，设置为默认值(null)！");
            this.name = null;
        } else {
            this.name = name;
        }
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if (money > 20) {
            this.money = money;
        } else {
            System.out.println("余额错误(必须大于20),设置为默认值(0)！");
            this.money = 20;
        }
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        if (pswd.length() == 6) {
            this.pswd = pswd;
        } else {
            System.out.println("密码长度错误(必须为6位),设置为默认值(zyhzyh)！");
            this.pswd = "zyhzyh";

        }
    }

    public void info() {
        System.out.print("name:" + name + "\t" + "money:" + money + "\t" + "pswd:" + pswd);
        System.out.println();
    }
}
