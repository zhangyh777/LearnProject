package com.zyh.demo.primary.encap;

public class TestAccount {
    public static void main(String[] args) {
        Account account = new Account("zyh",25,"satomi");
        System.out.println(account.name);
        int m = account.getMoney();
        System.out.println(m);
        account.info();
//        System.out.println();

        Account account1 = new Account("satomi",15,"zyh1224");
        account1.info();

    }

}
