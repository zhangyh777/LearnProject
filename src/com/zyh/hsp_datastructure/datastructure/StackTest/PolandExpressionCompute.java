package com.zyh.hsp_datastructure.datastructure.StackTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给出后缀表达式，计算结果，不含小数
 */
public class PolandExpressionCompute {
    public static void main(String[] args) {
        //后缀表达式，数字和运算符用空格隔开
        String PolandString = "4 5 * 8 - 60 + 8 2 / +";
        //1.将字符串放到ArrayList中
        //2.将ArrayList传给一个方法，遍历ArrayList
        List<String> arrayList = getListString(PolandString);
        System.out.println(arrayList);
        int res = cal(arrayList);
        System.out.println(res);
    }
    public static List<String> getListString(String polandString){
        ArrayList<String> arrayList = new ArrayList();
        String[] str = polandString.split(" ");
        for (String s:str
             ) {
            arrayList.add(s);
        }

        return arrayList;
    }
    public static int cal(List<String> ls){
        Stack<String> numStack = new Stack();
        int res = 0;
        for (String s:ls
             ) {
            if(s.matches("\\d+")){//如果遍历得到的是数字（个位数或多位数），就入栈
                numStack.push(s);
            }else{//如果匹配到的不是数字（只能是运算符）
                  //从数栈里pop出两个数和运算符进行运算
                int num2 = Integer.parseInt(numStack.pop());//先出栈的数，实际是表达式右边的数
                int num1 = Integer.parseInt(numStack.pop());//后出栈的数，实际是表达式左边的数
                switch (s){
                    case "+":
                        res = num1+num2;
                        break;
                    case "-":
                        res = num1-num2;
                        break;
                    case "*":
                        res = num1*num2;
                        break;
                    case "/":
                        res = num1/num2;
                        break;
                    default:
                        break;
                }
                numStack.push(res+"");
            }
        }
        return res;
    }
}

