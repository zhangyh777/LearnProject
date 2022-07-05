package com.zyh.demo.primary.override;

public class Student  extends Person{
    private int id;
    private double score;

    public Student(String name, int age,int id,double score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }

    @Override
    // 非必须，加上@Override可以让编译器帮助检查是否进行了正确的覆写。
    // 希望进行覆写，但是不小心写错了方法签名，编译器会报错。
    public String say(){
        return super.say()+"\tid:"+id+"\t"+"score:"+score;
    }
}
