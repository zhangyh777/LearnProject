package com.zyh.demo.junior.CommonlyUsedClass;

public class JudgeNum {
    public static void main(String[] args) {
        judge("asdcFG34e;;./");
    }
    public static void judge(String str){
        int numCount = 0;
        int upperCount = 0;
        int lowerCount = 0;
        int num4 = 0;
        if(str==null){
            System.out.println("字符串不能为空");
            return;
        }
        char[] charArr = str.toCharArray();
        for(int i =0;i<charArr.length;i++){
            if(charArr[i]>='0'&&charArr[i]<='9'){
                numCount++;
            }else if(charArr[i]>='A'&&charArr[i]<='Z'){
                upperCount++;
            }else if(charArr[i]>='a'&&charArr[i]<='z'){
                lowerCount++;
            }else{
                num4++;
            }
        }
        System.out.println("数字个数："+numCount);

        System.out.println("大写字母个数："+upperCount);
        System.out.println("小写字母个数："+lowerCount);
        System.out.println("其它字符个数："+num4);
    }


}
