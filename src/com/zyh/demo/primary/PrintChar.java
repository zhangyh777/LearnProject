package com.zyh.demo.primary;

public class PrintChar {
    public static void main(String[] args){
        A a = new A();
        a.Print(4,5,'*');
    }
}
class A{
//    public A(){} 无参构造器，可有可无，没有的话系统会默认生成一个无参构造器
        public void Print(int row,int col,char c){
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    System.out.print(c);
                }System.out.println();
            }
    }
}