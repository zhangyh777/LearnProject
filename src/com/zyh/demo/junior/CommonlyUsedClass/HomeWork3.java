package com.zyh.demo.junior.CommonlyUsedClass;

/**
 * 输入形式为：Zhang Yun Hao的人名
 * 以 Hao,Zhang .Y 的形式打印出来，Y是中间单词的首字母大写
 */

public class HomeWork3 {
    public static void main(String[] args) {
        inputName("Zhang Yun Hao");

    }
    public static void inputName(String str){

        if(str==null){
            System.out.println("名字不能为空");
            return;
        }
        String[] strings = str.split(" ");

        if(!(strings.length==3)){
            throw new RuntimeException("名字长度不对，应该为三位");
        }
        String str1 = strings[0];
        String str2 = strings[1];
        String str3 = strings[2];


//      首字符都要大写
        if (!(str1.charAt(0)>=65&&str1.charAt(0)<=90
                && str2.charAt(0)>=65&&str2.charAt(0)<=90
                && str3.charAt(0)>=65&&str3.charAt(0)<=90)){
            throw new RuntimeException("首字符应该大写");
        }
//      其余字符都要小写
        for (int i = 1; i < str1.length(); i++) {
            if(!(str1.charAt(i)>=97&&str1.charAt(i)<=122)) {
                throw new RuntimeException("首字符外的字符都要小写");
            }
        }
        for (int i = 1; i < str2.length(); i++) {
            if(!(str2.charAt(i)>=97&&str2.charAt(i)<=122)) {
                throw new RuntimeException("首字符外的字符都要小写");
            }
        }
        for (int i = 1; i < str3.length(); i++) {
            if(!(str3.charAt(i)>=97&&str3.charAt(i)<=122)) {
                throw new RuntimeException("首字符外的字符都要小写");
            }
        }
//      格式化字符串
        String format = String.format("%s,%s .%c",str3,str1,str2.charAt(0));
        System.out.println(format);
    }
}
