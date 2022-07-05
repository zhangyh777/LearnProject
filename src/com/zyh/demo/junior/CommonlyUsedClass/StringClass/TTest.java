package com.zyh.demo.junior.CommonlyUsedClass.StringClass;

public class TTest {
    public static void main(String[] args) {
        Test test = new Test();
        test.change(test.str,test.ch);
        System.out.println(test.str);//ZYH
        System.out.println(test.ch);//hava

//      取 [min,max)之间的数
//      (int)(min + Math.randon * (max - min))
        for (int i = 0; i < 5; i++) {
            System.out.println((int)(2+Math.random()*3));
        }
//      取 [min,max] 之间的数
//      (int)(min + Math.random * (max - min + 1))
        for (int i = 0; i < 5; i++) {
            System.out.println((int)(3+Math.random()*4));
        }

    }
}
class Test{
    String str = new String("ZYH");
    final char[] ch = {'j','a','v','a'};
    public void change(String s,char[] c){
        s = "java";
        c[0] = 'h';
    }
}