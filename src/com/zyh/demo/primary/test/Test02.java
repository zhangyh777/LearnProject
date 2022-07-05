package com.zyh.demo.primary.test;
import java.util.*;
//实现查找某字符串数组中的元素，并返回索引，如果找不到返回-1
public class Test02 {
    public static void main(String[] args){
        Scanner myScan = new Scanner(System.in);

        A02 a02 = new A02();
        String[] arr = a02.setArr(10);

        System.out.println("输入要查找的元素：");
        String target = myScan.nextLine();

        int index = a02.find(arr,target);
        System.out.println(index);


    }

}
class A02 {
    public String[] setArr(int n){
        Scanner myScan = new Scanner(System.in);
        String[] arr = new String[n];
        System.out.printf("输入数组元素(%d个)："+"\n",n);
        for(int i=0;i<n;i++){
            String str = myScan.nextLine();
            arr[i]=str;
        }
        System.out.print("数组：[");
        for (String e: arr
             ) {
            System.out.print(e+"\t");
        }
        System.out.println("]");
        return arr;
    }


    public int find(String[] arr,String s){
        int index = -1;
        for(int i=0;i<arr.length;i++) {
            if (arr[i].equals(s)) {

                System.out.print("找到目标元素，索引为:" );
                return i;

            }

        }
        return index;
    }

}


