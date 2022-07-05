package com.zyh.demo.junior.InnerClass;

public class TestInnerClass {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.alarmClock(new Bell(){
            @Override
            public void ring(){
                System.out.println("懒猪起床了");
            }
        });
        f(new Bell(){
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });
    }
    public static void f(Bell bell){
        bell.ring();
    }
}
interface Bell{
    void ring();
}
class Phone{
    public void alarmClock(Bell b){
        b.ring();
    }
}
