package com.zyh.demo.junior.CommonlyUsedClass;

public class StringReverse {
    public static void main(String[] args) {
        String str = new String("abcdefghijklm");
        Reverse(str,0,9);
    }
    public static void Reverse(String arr,int start,int end){
//      先找出正确的情况，取反即为错误的情况
        if(!(arr!=null&&start>=0&&end<=arr.length())){
            throw new RuntimeException("参数不正确");
        }
        char[] charArr = arr.toCharArray();
        for(int i=start,j=end;i<j;i++,j--){
            char temp = charArr[i];
            charArr[i] = charArr[j];
            charArr[j] = temp;
        }
        for (char e : charArr
        ) {
            System.out.print(e);
        }

    }
}
