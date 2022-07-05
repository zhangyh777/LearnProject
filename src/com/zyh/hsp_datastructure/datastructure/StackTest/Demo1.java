package com.zyh.hsp_datastructure.datastructure.StackTest;

import java.util.Stack;

/**
 * 个位数且不带括号的算术表达式
 */
public class Demo1 {
    public static void main(String[] args) {
        String expression = "4+2*8-2";
        Stack<String> numStack = new Stack<>();
        Stack<String> operateStack = new Stack();
        int index = 0;
        String read = "";
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        String operation = "";
        while (index < expression.length()) {
            //从字符串里一次读取一个字符（局限于个位数）
            //可改进从字符串数组里面读取多个字符（适用于多位数或者小数）
            read = expression.substring(index, index + 1);
            if (read.matches("\\d")) {
                numStack.push(read);
                index++;
            } else if (isOperate(read)) {
                if (operateStack.isEmpty() || priority(read) >= priority(operateStack.peek())) {
                    operateStack.push(read);
                    index++;
                } else {
                    num1 = Integer.parseInt(numStack.pop());
                    num2 = Integer.parseInt(numStack.pop());
                    operation = operateStack.pop();
                    res = cal(num1, num2, operation);
                    numStack.push("" + res);
                    operateStack.push(read);
                    index++;
                }
            }
        }
        while (operateStack.size() > 0) {
            num1 = Integer.parseInt(numStack.pop());
            num2 = Integer.parseInt(numStack.pop());
            operation = operateStack.pop();
            res = cal(num1, num2, operation);
            numStack.push("" + res);
        }
        System.out.println(numStack.peek());

    }

    public static boolean isOperate(String s) {
        return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
    }

    public static int cal(int n1, int n2, String operation) {
        int res = 0;
        switch (operation) {
            case "+":
                res = n2 + n1;
                break;
            case "-":
                res = n2 - n1;
                break;
            case "*":
                res = n2 * n1;
                break;
            case "/":
                res = n2 / n1;
                break;
            default:
                break;
        }
        return res;
    }

    public static int priority(String operation) {
        int level = -1;
        switch (operation) {
            case "*":
            case "/":
                level = 1;
                break;
            case "+":
            case "-":
                level = 0;
                break;
            default:
                throw new RuntimeException("没有该运算符");
        }
        return level;
    }
}

