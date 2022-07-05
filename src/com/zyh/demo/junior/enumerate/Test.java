package com.zyh.demo.junior.enumerate;

public class Test {
    public static void main(String[] args) {
        Week[] week = Week.values();
        for (Week e:week
             ) {
            System.out.println(e.toString());
        }

    }
}
enum Week{
    MONDAY("星期一"),TUESDAY("星期二"),WEDNESDAY("星期三"),THURSDAY("星期四"),FRIDAY("星期五"),SATURDAY("星期六"),SUNDAY("星期天");
    private String name;
    Week(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
