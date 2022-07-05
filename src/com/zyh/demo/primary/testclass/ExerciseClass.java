package com.zyh.demo.primary.testclass;
public class ExerciseClass{
    public static void main(String[] args){
        Students zyh = new Students("zyh");

        zyh.Study(3);
    }
}
//自定义类
class Students{
    // 成员变量
    String name;
    // 构造器
    public Students(String name){
        this.name=name;
    }
    // 成员方法
    public void Study(int times){
        System.out.printf("学习%d个小时",times);
    }
}