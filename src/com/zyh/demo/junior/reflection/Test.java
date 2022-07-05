package com.zyh.demo.junior.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        //1.获取Class对象
        Class<privateTest> privateTestClass = privateTest.class;
        //2.通过Class对象创建实例
        //newInstance方法过时,用getDecalredConstructor().newInstance()
        privateTest privateTestObj = privateTestClass.getDeclaredConstructor().newInstance();
        //3.获取指定属性,
        Field name = privateTestClass.getDeclaredField("name");
        //4.修改指定属性（如果是private属性的话要暴力破解）
        name.setAccessible(true);//暴力破解
        name.set(privateTestObj,"zhangyh");
        //5.获取方法（如果是private方法的话要暴力破解）
        Method getName = privateTestClass.getDeclaredMethod("getName");
        //6.通过反射调用方法
        Object methodReturn = getName.invoke(privateTestObj);
        System.out.println(methodReturn);

    }
}

class privateTest{
    private String name="hellokitty";

    public String getName() {
        return name;
    }
}
