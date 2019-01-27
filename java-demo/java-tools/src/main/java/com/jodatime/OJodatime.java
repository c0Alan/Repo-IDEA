package com.jodatime;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.HashMap;
import java.util.Map;

public class OJodatime {

    private static Logger logger = Logger.getLogger(OJodatime.class);

    @SuppressWarnings("unused")
    public void test() {

        /** 创建任意时间对象 *//*
        DateTime dateTime = new DateTime(2012, 12, 15, 18, 23, 55);

        *//** 计算两日期相差的天数 *//*
        LocalDate start = new LocalDate(2012, 12, 14);
        LocalDate end = new LocalDate(2012, 12, 15);
        int days = Days.daysBetween(start, end).getDays();

        *//** 获取18天之后的某天在下个月的当前周的第一天日期 *//*
        String dateStr = new DateTime().plusDays(18).plusMonths(1).dayOfWeek().withMinimumValue()
                .toString("yyyy-MM-dd HH:mm:ss");

        *//** 时间格式化 *//*
        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime dateTime2 = DateTime.parse("2012-12-21 23:22:45", format); //时间解析    
        String string_u = dateTime2.toString("yyyy/MM/dd HH:mm:ss EE"); //时间格式化，输出==> 2012/12/21 23:22:45 Fri  
        String string_c = dateTime2.toString("yyyy年MM月dd日 HH:mm:ss EE", Locale.ENGLISH); //格式化带Locale，输出==> 2012年12月21日 23:22:45 星期五 

        *//** 与JDK互操作 *//*
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
        
        logger.info("finished...");*/
    }

    public static void main(String[] args) {
        /*DateTime dtKssj = new DateTime("2018-02-05");
        String kssj = dtKssj.toString("yyyy-MM-dd");
        Double a = Math.pow(Double.valueOf(10), Double.valueOf(-6));
        System.out.println(a);
        System.out.println(getWorkDays2("2018-02-05", "2018-03-05"));*/
//        DateTime dateTime = new DateTime("190116185355095");
        /*DateTime dateTime = DateTime.parse("190116185355095", DateTimeFormat.forPattern("yyMMddHHmmssSSS"));
        DateTime dateTime2 = DateTime.parse("190116185356095", DateTimeFormat.forPattern("yyMMddHHmmssSSS"));*/

        /*DateTimeFormatter df = DateTimeFormat.forPattern("yyMMddHHmmssSSS");
        df.parseDateTime("190116185355095");
        DateTime dateTime = df.parseDateTime("190116185355095");
        DateTime dateTime2 =df.parseDateTime("190116185356095");
        System.out.println(dateTime);
        System.out.println(dateTime2);
        System.out.println(Seconds.secondsBetween(dateTime, dateTime2).getSeconds());

*//*        Map hourStatisticMap = new HashMap();
        Integer max_delay_second = (Integer) hourStatisticMap.get("max_delay_second");
        System.out.println(Integer.valueOf(2).compareTo(Integer.valueOf(3)));*//*
        String recvCaptureTime = "19011815057369";
        String newRecvCaptureTime = recvCaptureTime.substring(0, 10) + "0" + recvCaptureTime.substring(10);
        System.out.println(newRecvCaptureTime);
        System.out.println(new DateTime().toString("yyMMdd-HHmmss-SSS"));

        Integer i = 0;

        try {
            i = i + 2;
            i = 1 / 0;
            i++;
        } catch (Exception e) {

        }
        System.out.println(i);

        Map dataStatisticData = new HashMap();
        dataStatisticData.put("class", "com.suntek.flume.translate.impl.analysis.FaceFeatureExtractTranReqDataImpl");
        System.out.println(JSONObject.toJSON(dataStatisticData).toString());*/

        /*String str = "{\"aa\":\"bb\"}";
        Map m = JSONObject.parseObject(str);
        System.out.println(m.get("aa"));*/

        DateTime curDateTime = new DateTime();

        String threeOClock = curDateTime.toString("yyMMdd") + "03";
        DateTimeFormatter df = DateTimeFormat.forPattern("yyMMddHH");
        DateTime dateTime = df.parseDateTime("19012702");
        DateTime threeOClockDateTime = df.parseDateTime(threeOClock);
        System.out.println(threeOClockDateTime);
        System.out.println(curDateTime);
        System.out.println(dateTime);
        System.out.println(threeOClockDateTime.compareTo(dateTime));
        System.out.println(threeOClockDateTime.compareTo(curDateTime));

    }

    /**
     * key: 工作日 "2018-04-07", value: 工时
     * @return
     * @date 2018-3-7 @time 下午2:52:07
     */
    public Map<String, String> getGzrGsMap(String kssj, String jssj){
        Map<String, String> gzrGsMap = new HashMap<String, String>();
        int weekdays = 0;
        DateTime dtKssj = new DateTime(kssj);
        DateTime dtJssj = new DateTime(jssj);
        int days = Days.daysBetween(dtKssj, dtJssj).getDays();
        for(int i=0; i<=days; i++){
            if(dtKssj.plusDays(i).getDayOfWeek() < 6){
                weekdays++;
            }
        }
        return null;
    }

    /**
     * 获取工作日
     * @param kssj
     * @param jssj
     * @return
     */
    public static int getWorkDays2(String kssj, String jssj){
        int weekdays = 0;
        DateTime dtKssj = new DateTime(kssj);
        DateTime dtJssj = new DateTime(jssj);
        int days = Days.daysBetween(dtKssj, dtJssj).getDays();
        for(int i=0; i<=days; i++){
            if(dtKssj.plusDays(i).getDayOfWeek() < 6){
                weekdays++;
            }
        }
        return weekdays;
    }

    public static int getWorkDays(String kssj, String jssj){
        DateTime dtKssj = new DateTime(kssj);
        DateTime dtJssj = new DateTime(jssj);
        int days = Days.daysBetween(dtKssj, dtJssj).getDays() + 1;
        int weeks = days / 7;
        DateTime dtJssj2 = dtJssj.minusDays(weeks * 7);
        int weekens = weeks * 2 + getWeekenDays(dtKssj.getDayOfWeek(), dtJssj2.getDayOfWeek());
        int workDays = days + 1 - weekens;
        return workDays;
    }

    /**
     * 输入 1-7 的两个数, 判断多少个 6 和 7, 这里有问题
     * @param weekDay1
     * @param weekDay2
     * @return
     */
    public static int getWeekenDays(int weekDay1, int weekDay2){
        int smallDay = weekDay1 < weekDay2 ? weekDay1 : weekDay2;
        int bigDay = weekDay1 > weekDay2 ? weekDay1 : weekDay2;
        int[] weekens = {6, 7};
        return containsNum(smallDay, bigDay, weekens);
    }

    /**
     * 计算包含的数字数量
     * @param smallNum
     * @param bigNum
     * @param numArr
     * @return
     */
    public static int containsNum(int smallNum, int bigNum, int[] numArr){
        int cnt = 0;
        for(int num : numArr){
            if(num >= smallNum && num <= bigNum){
                cnt++;
            }
        }
        return cnt;
    }
}
