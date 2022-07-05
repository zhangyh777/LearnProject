package com.zyh.hsp_datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        String math = "(8.8/2)-(2*1)+3";

        List<String> resArrayList = strToArrayList(math);
        fun(resArrayList);



    }

    public static void fun(List<String> resArrayList) {
        Stack<String> numStack = new Stack();
        Stack<String> operateStack = new Stack();

        int index = 0;
        String str = "";
        String temp = "";
        double num1 = 0;
        double num2 = 0;
        String operation = "";
        double res = 0;
        for (String read : resArrayList
        ) {
            if (read.matches("\\d+")||read.matches("\\d+\\.\\d+")) {
                numStack.push(read);
            } else if (read.equals("(")
                    || operateStack.isEmpty()
                    || operateStack.peek().equals("(")
                    || priority(read) > priority(operateStack.peek())) {
                operateStack.push(read);
            } else if (priority(read) <= priority(operateStack.peek())) {//还有括号没去除干净
                num1 = Double.parseDouble(numStack.pop());
                num2 = Double.parseDouble(numStack.pop());
                operation = operateStack.pop();
                res = cal(num1, num2, operation);
                numStack.push("" + res);
                operateStack.push(read);

            } else {
                while (!operateStack.peek().equals("(")) {
                    num1 = Double.parseDouble(numStack.pop());
                    num2 = Double.parseDouble(numStack.pop());
                    operation = operateStack.pop();
                    res = cal(num1, num2, operation);
                    numStack.push("" + res);
                    operateStack.pop();
                }
                operateStack.push(read);
            }
        }

    }

    public static List<String> strToArrayList(String str) {
        List<String> resArrayList = new ArrayList<>();
        int index = 0;
        String s = "";
        String temp = "";
        do {
            s = str.substring(index, index + 1);
            if (isOperate(s)) {
                resArrayList.add(s);
                index++;
            } else {
                while (index < str.length() && ((str.charAt(index) >= '0' && str.charAt(index) <= '9') || '.' == (str.charAt(index)))) {
                    s = str.substring(index, index + 1);
                    temp += s;
                    index++;
                }
                resArrayList.add(temp);
            }
            temp = "";
        } while (index < str.length());
        return resArrayList;
    }

    public static boolean isOperate(String ch) {
        return (ch.equals("+")
                || ch.equals("-")
                || ch.equals("*")
                || ch.equals("/")
                || ch.equals("(")
                || ch.equals(")"));
    }

    public static double cal(double n1, double n2, String operate) {
        double res = 0;
        switch (operate) {
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

    public static int priority(String s) {
        int level = -1;
        switch (s) {
            case "*":
            case "/":
                level = 1;
                break;
            case "+":
            case "-":
                level = 0;
                break;
            default:
                break;
        }
        return level;
    }

}




