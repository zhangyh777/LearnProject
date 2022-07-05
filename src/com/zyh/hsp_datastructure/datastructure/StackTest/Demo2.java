package com.zyh.hsp_datastructure.datastructure.StackTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 可用于多位数算术表达式（但不能是小数，也不能有括号）
 */
public class Demo2 {
    public static void main(String[] args) {
        String expression = "14+2*8-25";
        List<String> resList = toArrayList(expression);
        int res = calMath(resList);
        System.out.println(res);




    }

    public static int calMath(List<String> resList){
        Stack<String> numStack = new Stack();
        Stack<String> operateStack = new Stack();
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        String operation = "";

        //遍历表达式数组
        for (String s:resList
        ) {
            if(s.matches("\\d+")){//如果是数字的话直接入栈，包括多位数，但不能是小数
                numStack.push(s);
            }else if(operateStack.isEmpty()||(priority(s))>priority(operateStack.peek())){
                operateStack.push(s);
            }else{
                num1 = Integer.parseInt(numStack.pop());
                num2 = Integer.parseInt(numStack.pop());
                operation = operateStack.pop();
                res = cal(num1,num2,operation);
                numStack.push(""+res);
                operateStack.push(s);
            }
        }
        while (operateStack.size() > 0) {
            num1 = Integer.parseInt(numStack.pop());
            num2 = Integer.parseInt(numStack.pop());
            operation = operateStack.pop();
            res = cal(num1, num2, operation);
            numStack.push("" + res);
        }
       return Integer.parseInt(numStack.peek());
    }


    //将字符串类型的表达式转为字符串数组
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
                } while (index < str.length() && str.charAt(index)>= '0' && str.charAt(index) <= '9');
                resList.add(temp);
                temp = "";
            }
        }
        while (index < str.length());

        return resList;
    }

    //运算符判断
    public static boolean isOperate(String s) {
        return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
    }
    //运算规则
    public static int cal(int n1,int n2,String operation){
        int res = 0;
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
    //优先级判断
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
}
