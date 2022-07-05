package com.zyh.demo.junior.CommonlyUsedClass;

import java.util.Scanner;
public class Register {
    public static void main(String[] args) {
        register("zyh","123098","18039658245@163.com");

    }
    public static void register(String name,String pswd,String mail){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("输入用户名（2~4位）：");
//        String name = scanner.next();
        if(!(name.length()>=2&&name.length()<=4)){//出错
            throw new RuntimeException("用户名长度不对，要求2~4位");
        }

//        System.out.println("输入密码（6位纯数字）：");
//        String pswd = scanner.next();
        char[] pswdArr = pswd.toCharArray();
        if(!(pswdArr.length==6)){//长度规范
            throw new RuntimeException("密码长度不对，要求6位");
        }
//          格式规范，纯数字
        for (char c : pswdArr) {
//          字符ASCII编码不在'0'~'9'之内，即不是数字
            if (c < '0' || c > '9') {
                throw new RuntimeException("密码格式错误，要求纯数字");
            }
        }
//        System.out.println("输入邮箱（包含 @和.,且@在.前面）：");
//        String mail = scanner.next();
        char[] arr = mail.toCharArray();
        int i = mail.indexOf("@");
        int j = mail.indexOf(".");
        if(!(i>0&&j>i)){//首位不为@，且@在.前面为正确情况，取反为错误情况
            throw new RuntimeException("邮箱格式错误，要求存在@和.  且@在.前面");
        }
        System.out.println("注册成功");
    }
}
