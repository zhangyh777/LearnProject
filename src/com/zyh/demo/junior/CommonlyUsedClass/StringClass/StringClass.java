package com.zyh.demo.junior.CommonlyUsedClass.StringClass;

public class StringClass {
    public static void main(String[] args) {
//      1.直接创建String对象
//      指向常量池中的"zyh",如果不存在则创建，如果存在相同字符串，则把这些相同的字符串当作一个对象放入常量池
        String Str = "zyh";
        String Str1 = "zyh";
        System.out.println(Str==Str1);//true

//      2.调用构造器创建String对象（String类有很多构造器）
//      指向堆中对象，只有发生new操作时才产生新的对象
//      Str2指向堆中一个地址0X11，Str3指向新的地址0X22，但其值同时指向常量池中的"satomi"
        String Str2 = new String("satomi");
        String Str3 = new String("satomi");
        String Str4 = Str3;
        System.out.println(Str2==Str3);//引用类型，==运算符比较的是地址，false
        System.out.println(Str2.equals(Str3));//引用类型，equals方法比较的是值，true
        System.out.println(Str4==Str3);//true

        String a = "abc";//指向常量池
        String b = "hello";//指向常量池
//      变量相加，指向堆
        String c = a+b;//指向堆
//      常量相加，指向常量池
        String d = "abc" + "hello";//指向常量池
        String e = "abchello";
        System.out.println(c==(a+b));//false
        System.out.println(d==e);//true
//      str1.compareTo(str2)方法
//      1.str1和str2等长时，逐个比较字符，返回ASCII编码差值
//      2.str1和str2不等长时（假设str1.length > str2.length）
//        2.1 如果前半段字符完全相同，返回两个字符串长度差值
//        2.2 如果前半段字符不完全相同，返回首个不同字符的ASCII编码差值
        System.out.println(d.compareTo(b));//-7
        System.out.println(d.compareTo(e));//0
//      toCharArray(),将字符串转换为字符数组
        char[] arr = a.toCharArray();
        for (char element:arr
             ) {
            System.out.println(element);
        }



//      StringBuffer和StringBuilder
//      当对字符串进行修改的时候，需要使用 StringBuffer 和 StringBuilder 类
//      和 String 类不同的是，StringBuffer 和 StringBuilder 类的对象能够被多次的修改，并且不产生新的未使用对象
//      在使用 StringBuffer 类时，每次都会对 StringBuffer 对象本身进行操作，而不是生成新的对象，
//      所以如果需要对字符串进行修改推荐使用 StringBuffer。
//      StringBuilder是StringBuffer类的简化，
//      但不是线程安全的，无法同步访问，适用于单线程，速度比StringBuffer快

//      StringBuffer常用方法，直接对原StringBuffer对象作用，原对象发生变化
//        1.append
//        2.delete
//        3.replace
//        4.indexOf
//        5.insert
//        6.length
        StringBuilder stringBuilder = new StringBuilder();

        String str = "hahaha";
//      创建一个容量为16的 空 StringBuffer对象
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println(stringBuffer.length());//0
        System.out.println(stringBuffer.capacity());//16
//      创建字符串值为"hhh"的StringBuffer对象，容量为 16+传入字符串长度
        StringBuffer stringBuffer1 = new StringBuffer("hhh");
        System.out.println(stringBuffer1);//hhh
        System.out.println(stringBuffer1.capacity());//19
//      append，末尾追加字符(串)
        stringBuffer1.append("www");
        System.out.println(stringBuffer1);
//      delete(start,end),删除[start,end)区间内的字符
        stringBuffer1.delete(0,2);
        System.out.println(stringBuffer1);
//      insert(offset,xxx),指定索引位置插入元素xxx
        stringBuffer1.insert(2,"AAA");
        System.out.println(stringBuffer1);

        StringBuffer stringBuffer2 = new StringBuffer(str);
        System.out.println(stringBuffer2);//hahaha
        System.out.println(stringBuffer2.capacity());//22

//      StringBuffer -> String
//      1.StringBuffer对象的toString方法
        String str1 = stringBuffer2.toString();
//      2.使用String的构造器，传入StringBuffer对象
        String str2 = new String(stringBuffer1);

//      String -> StringBuffer
//      1.使用StringBuffer构造器
//      对String对象str1本身没有影响
        StringBuffer stringBuffer4 = new StringBuffer(str1);
//      2.StringBuffer对象使用append方法
        StringBuffer stringBuffer5 = stringBuffer.append(str);




    }

}
