package com.zyh.demo.junior.CommonlyUsedClass.Date_;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
//import java.sql.Date;
public class TestDate {
    public static void main(String[] args) {
//      获取当前时间
//      java.util.Date，而不是java.sql.Date
        Date date = new Date();
        System.out.println(date);
//      SimpleDateFormat
//      将时间格式化为 年-月-日 时:分:秒
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatDate1 = sdf1.format(date);
//      格式化为 月-日-年 时:分:秒
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        String formatData2 = sdf2.format(date);
        System.out.println(formatDate1);
        System.out.println(formatData2);

//      Calendar
//      抽象类，且构造器访问权限为protected
//      提供大量字段和方法来操作日期
//      getInstance获取实例
        Calendar c = Calendar.getInstance();
        System.out.println(c);
        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH)+1);//返回值为0~11，换算月份要 +1
        System.out.println(c.get(Calendar.DATE));
        System.out.println(c.get(Calendar.HOUR));//十二小时制
        System.out.println(c.get(Calendar.HOUR_OF_DAY));//二十四小时制
        System.out.println(c.get(Calendar.MINUTE));
        System.out.println(c.get(Calendar.SECOND));

//      LocalDate   日期/年月日
//      LocalTime   时间/时分秒
//      LocalDateTime   日期时间/年月日时分秒
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("年="+ldt.getYear());
        System.out.println("月(英文)="+ldt.getMonth());
        System.out.println("月(数字)="+ldt.getMonthValue());
        System.out.println("日="+ldt.getDayOfMonth());
        System.out.println("时="+ldt.getHour());
        System.out.println("分="+ldt.getMinute());
        System.out.println("秒="+ldt.getSecond());
        System.out.println("======");

        LocalDate ld = LocalDate.now();
        System.out.println("年="+ldt.getYear());
        System.out.println("月="+ldt.getMonthValue());
        System.out.println("日="+ldt.getDayOfMonth());
        System.out.println("======");

        LocalTime lt = LocalTime.now();
        System.out.println("时="+ldt.getHour());
        System.out.println("分="+ldt.getMinute());
        System.out.println("秒="+ldt.getSecond());


    }
}
