package com.example.demo.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {
    private static void getWeekByDate(Date time) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期
        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, 6);
        LocalDateTime endtime = LocalDateTime.of(LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(), cal.getTime().getDate(),23,59,59 );
        LocalDateTime startTime = LocalDateTime.of(LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(), cal.getTime().getDate()-6,0,0,0 );
        System.out.println(startTime+"---------"+endtime);
    }

    public static Date getThisWeekMonday() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        // 获得当前日期是一个星期的第几天 使用cal.get(Calendar.DAY_OF_WEEK);
        //获取的数表示的是每个星期的第几天，不能改变，其中星期日为第一天
        // 如果是星期日则获取天数时获取到的数字为1 在后面进行相减的时候出错
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        //  cal.getFirstDayOfWeek()根据前面的设置 来动态的改变此值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        System.out.println(cal.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
        System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期
        return cal.getTime();
    }

    public static void main(String[] args) {

        System.out.println(getThisWeekMonday().getDate());

        System.out.println(LocalDateTime.now().getDayOfWeek().getValue());

        Object asd = null;
        Integer as = (Integer) asd;
        System.out.println(as);

    }

}
