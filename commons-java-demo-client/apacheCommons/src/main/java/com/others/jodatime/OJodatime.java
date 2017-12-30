package com.others.jodatime;

import java.util.Date;
import java.util.Calendar;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class OJodatime {

    private static Logger logger = Logger.getLogger(OJodatime.class);

    @SuppressWarnings("unused")
    public void test() {

        /** 创建任意时间对象 */
        DateTime dateTime = new DateTime(2012, 12, 15, 18, 23, 55);

        /** 计算两日期相差的天数 */
        LocalDate start = new LocalDate(2012, 12, 14);
        LocalDate end = new LocalDate(2012, 12, 15);
        int days = Days.daysBetween(start, end).getDays();

        /** 获取18天之后的某天在下个月的当前周的第一天日期 */
        String dateStr = new DateTime().plusDays(18).plusMonths(1).dayOfWeek().withMinimumValue()
                .toString("yyyy-MM-dd HH:mm:ss");

        /** 时间格式化 */
        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime dateTime2 = DateTime.parse("2012-12-21 23:22:45", format); //时间解析    
        String string_u = dateTime2.toString("yyyy/MM/dd HH:mm:ss EE"); //时间格式化，输出==> 2012/12/21 23:22:45 Fri  
        String string_c = dateTime2.toString("yyyy年MM月dd日 HH:mm:ss EE", Locale.ENGLISH); //格式化带Locale，输出==> 2012年12月21日 23:22:45 星期五 

        /** 与JDK互操作 */
        Date date = new Date(); //通过jdk时间对象构造  
        DateTime dateTime3 = new DateTime(date);
        Calendar calendar = Calendar.getInstance();
        dateTime3 = new DateTime(calendar);

        // Joda-time 各种操作.....  
        dateTime3 = dateTime3.plusDays(1) // 增加天  
                .plusYears(1)// 增加年  
                .plusMonths(1)// 增加月  
                .plusWeeks(1)// 增加星期  
                .minusMillis(1)// 减分钟  
                .minusHours(1)// 减小时  
                .minusSeconds(1);// 减秒数  

        Date date2 = dateTime3.toDate(); // 计算完转换成jdk 对象  
        Calendar calendar2 = dateTime3.toCalendar(Locale.CHINA);
        
        logger.info(calendar2);
        
        logger.info("finished...");
    }

}
