package com.zyh.demo.junior.enumerate;

/**
 * 枚举类：enum，类的实例个数是声明时就固定的，无法再新建实例
 *       枚举跟普通类一样可以用自己的变量、方法和构造函数，
 *       构造函数只能使用 private 访问修饰符
 *       要在枚举类的最前面定义枚举值，所有的枚举值都是 public static final 的，后面再放属性，构造器，方法等
 *       使用enum关键字的时候，会隐式的继承Enum类，因此可以使用Enum类的相关方法
 *       使用enum关键字之后就不能再使用extends继承别的类了（已经继承Enum类）
 *       可以使用接口，enum E implements InterfaceA{...}
 *       1.values() 返回值为 枚举类中所有的枚举值组成的数组
 *       2.ordinal()方法可以找到每个枚举常量的索引，就像数组索引一样
 *       3.valueOf()方法返回指定字符串值的枚举常量
 *       4.compareTo(),比较两个枚举常量值，比较的是索引，return self.ordinal - other.ordinal;
 *
 */
public class TestEnum {
    public static void main(String[] args) {
//      枚举类的values()方法，返回值为数组
        Season[] season = Season.values();
        for (Season e: season
             ) {
            System.out.println(e);
        }
//      compareTo(),返回两个枚举常量索引的差值
        System.out.println(Season.AUTUMN.compareTo(Season.SPRING));//3-1=2
//      name(),返回枚举常量的名字
        System.out.println(Season.SPRING.name());
//      ordinal(),返回枚举常量的索引
        System.out.println(Season.WINTER.ordinal());
//      valueof(),返回指定字符串对应的枚举常量，不存在的话会报错
        Season winter = Season.valueOf("WINTER");
        System.out.println(winter);
        Season s1 = Season.valueOf("S");
        System.out.println(s1);//报错

    }
}

enum Season{
//  在枚举类的最前面定义实例，每个实例后用逗隔开，最后一个用分号收尾
//  调用无参构造器创建实例，括号可以省略
    WHAT,
//  调用有参构造器创建实例
    SPRING("春天"),SUMMER("夏天"),AUTUMN("秋天"),WINTER("冬天");

//  枚举跟普通类一样可以用自己的变量、方法和构造函数，构造函数只能使用 private 访问修饰符
    private String name;
//  无参构造器
    Season() {
        System.out.println("无参构造器");
    }
//  有参构造器
    Season(String name) {
        System.out.println("有参构造器");
        this.name = name;
    }
//  重写枚举类Season的toString方法
    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                '}';
    }
}

