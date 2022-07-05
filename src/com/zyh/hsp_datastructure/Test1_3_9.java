package com.zyh.hsp_datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static com.zyh.hsp_datastructure.datastructure.StackTest.Demo3.isOperate;

/**
 * 给出缺少左括号的中缀表达式，返回补全括号的中缀表达式
 */
public class Test1_3_9 {
    public static void main(String[] args) {
        String str = "15.5+2.5)*3-2)-1+5))";
        List<String> strList = toArrayList(str);
        List<String> resList = fullBracket(strList);


    }

    public static List<String> fullBracket(List<String> strList){
        String temp = "";
        Stack<String> stack = new Stack<>();
        List<String> tempList = new ArrayList<>();
        List<String> resList = new ArrayList<>();
        for (String read:strList
        ) {
            if(read.matches("\\d+")||read.matches("\\d+\\.\\d+")||isOperate(read)){
                stack.push(read);
            }else{
                if(read.equals(")")){//先将右括号入栈
                    stack.push(read);
                }
                //  2+5)  ->  (2+5)
                //将右括号入栈之后
                //,出栈4个元素（栈顶的右括号,两个数字,一个运算符）进行括号补全
                //,再将结果（补全括号的运算式片段）入栈
                for (int i = 0; i < 4; i++) {
                    temp = stack.pop()+temp;
                }
                temp ="("+temp;//补全左括号
                stack.push(temp);//补全之后的结果入栈
                temp = "";
            }
        }
        while(!stack.isEmpty()){
            tempList.add(stack.pop());
        }
        for (int i = resList.size()-1; i >=0 ; i--) {
            resList.add(tempList.get(i));
        }
        return resList;
    }
    //字符串转数组
    public static List<String> toArrayList(String str){
        List<String> resList = new ArrayList<>();
        int index = 0;
        String read;
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
        } while (index < str.length());
        return resList;
    }
}
