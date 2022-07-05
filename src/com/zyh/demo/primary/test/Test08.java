package com.zyh.demo.primary.test;

public class Test08 {
    public static void main(String[] args){
//      匿名对象，只使用一次，之后自动销毁
        new Test().count01();

        Test t1 = new Test();
        t1.count02();
        t1.count02();

        Test t2 = new Test();
        t2.count03();
        t2.count03();
    }
}
class Test{
    int count = 9;
    public void count01(){
        count = 10;
        System.out.println("count1="+count);
    }
    public void count02(){
        System.out.println("count1="+(++count));
    }
    public void count03(){
        System.out.println("count1="+count++);
    }

}