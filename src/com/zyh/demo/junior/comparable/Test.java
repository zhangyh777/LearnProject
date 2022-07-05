package com.zyh.demo.junior.comparable;
/*
    内部比较器的compareTo方法写法固定,只能比较一个属性,不方便
    外部比较器的话,虽然也只能比较一个属性,但可以写多个外部比较器,每个都负责不同的属性比较,方便
 */
public class Test {
    public static void main(String[] args) {
        Students s1 = new Students("aabbcc",18,86.5);
        Students s2 = new Students("aaabcc",18,86.5);
        Students s3 = new Students("aabbcc",16,86.5);
        Students s4 = new Students("abbbcc",18,86.7);
        //内部比较器
        System.out.println("内部比较器:String的compareTo,比较字符串,不一样长的话比较长度,一样长的话逐个比较字符");
        System.out.println(s1.compareTo(s2));

        //外部比较器
        OutCompare1 outCompare1 = new OutCompare1();
        OutCompare2 outCompare2 = new OutCompare2();
        OutCompare3 outCompare3 = new OutCompare3();
        OutCompare4 outCompare4 = new OutCompare4();

        System.out.println("外部比较器1：String的compareTo,比较字符串,不一样长的话比较长度,一样长的话逐个比较字符");
        int res1 = outCompare1.compare(s1,s2);
        System.out.println(res1);

        System.out.println("外部比较器2：比较age大小");
        int res2 = outCompare2.compare(s1,s3);
        System.out.println(res2);

        System.out.println("外部比较器3：比较score大小");
        int res3 = outCompare3.compare(s1,s4);
        System.out.println(res3);
        System.out.println("外部比较器4：先比较score,不相同的话直接返回结果,相同的话继续比较name");
        int res4 = outCompare4.compare(s1,s3);
        System.out.println(res4);//0
        int res5 = outCompare4.compare(s1,s2);
        System.out.println(res5);//1

    }
}
