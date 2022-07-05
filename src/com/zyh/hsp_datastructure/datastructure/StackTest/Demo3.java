package com.zyh.hsp_datastructure.datastructure.StackTest;

/**
 * 用于多位数算术表达式计算（包含小数，但不能有括号）
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 可用于多位数算术表达式，可以有小数，但不能有括号
 */
public class Demo3 {
    public static void main(String[] args) {
        String expression = "14.5+2*8-4.5";//算数表达式
        List<String> resList = toArrayList(expression);//表达式里的数字和符号组成的数组
        double res = calMath(resList);
        System.out.println(res);

    }
    public static double calMath(List<String> resList){
        Stack<String> numStack = new Stack();
        Stack<String> operateStack = new Stack();
        double num1 = 0;
        double num2 = 0;
        double res = 0;
        String operation = "";

        //遍历表达式数组
        for (String s:resList
        ) {
            if(s.matches("\\d+")||s.matches("\\d+\\.\\d+")){//1.如果是数字的话直接入栈，可匹配多位数或者小数
                numStack.push(s);
            }else if(operateStack.isEmpty()||(priority(s))>priority(operateStack.peek())){//2.如果不是数字，那就是符号(+-*/)，如果符号栈为空或者当前符号优先级大于栈顶优先级
                operateStack.push(s);
            }else{//3.当前符号优先级小于等于栈顶优先级，出栈两个数，一个符号，进行算术运算，结果入数栈，然后将当前符号入符号栈
                num1 = Double.parseDouble(numStack.pop());
                num2 = Double.parseDouble(numStack.pop());
                operation = operateStack.pop();
                res = cal(num1,num2,operation);
                numStack.push(""+res);
                operateStack.push(s);
            }
        }
        //数栈里出两个数，符号栈出一个符号，进行算术运算
        //符号栈为空时，运算就结束了，此时数栈里还剩一个数，就是结果
        while (operateStack.size() > 0) {
            num1 = Double.parseDouble(numStack.pop());
            num2 = Double.parseDouble(numStack.pop());
            operation = operateStack.pop();
            res = cal(num1, num2, operation);
            numStack.push("" + res);
        }
       return Double.parseDouble(numStack.peek());
    }

    public static double cal(double n1,double n2,String operation){
        double res = 0;
        switch (operation){
            case "+":
                res = n2+n1;
                break;
            case "-":
                res = n2-n1;
                break;
            case "*":
                res = n2*n1;
                break;
            case "/":
                res = n2/n1;
                break;
            default:
                break;
        }
        return res;
    }
    public static int priority(String operation){
        int res = -1;
        switch (operation){
            case "+":
            case "-":
                res = 0;
                break;
            case "*":
            case "/":
                res = 1;
                break;
            default:
                break;
        }
        return res;
    }
    //将字符串转为字符串数组
    public static List<String> toArrayList(String str) {
        List<String> resList = new ArrayList<>();
        int index = 0;
        String read = "";
        String temp = "";
        do {
            read = str.substring(index, index + 1);
            if (isOperate(read)) {//运算符直接加入数组
                resList.add(read);
                index++;
            } else {//如果读到数字
                do {
                    read = str.substring(index, index + 1);
                    temp += read;
                    index++;
                } while (index < str.length()
                        && ((str.charAt(index)>= '0' && str.charAt(index) <= '9')
                                ||'.'==str.charAt(index)));
                resList.add(temp);
                temp = "";
            }
        }
        while (index < str.length());

        return resList;
    }

    public static boolean isOperate(String s) {
        return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
    }
}

