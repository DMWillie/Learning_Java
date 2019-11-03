package date;

/*  Author: 北辰
    日期: 03/11/2019
    功能: 测试Java中Calendar(日历)类的用法
 */

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class TestCalendar {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args){
        //采用单例模式获取日历对象Calendar.getInstance()
        Calendar c = Calendar.getInstance();
        //通过日历对象得到日期对象
        Date now = c.getTime();
        //当前日期
        System.out.println("当前日期: \t"+format(c.getTime()));

        Date d2 = new Date(0);
        c.setTime(d2);      //把这个日历调成日期： 1970.1.1 08:00:00

        //下个月的今天
        c.setTime(now);
        c.add(Calendar.MONTH,1);
        System.out.println("下个月的今天: \t"+format(c.getTime()));

        //去年的今天
        c.setTime(now);
        c.add(Calendar.YEAR,-1);
        System.out.println("去年的今天: \t"+format(c.getTime()));

        //上个月的第三天
        c.setTime(now);
        c.add(Calendar.MONTH,-1);
        //c.add(Calendar.DATE,3);   这里是上个月的今天往后推3天
        c.set(Calendar.DATE,3);
        System.out.println("上个月的第三天: \t"+format(c.getTime()));

        //下个月的倒数第三天
        c.setTime(now);
        //System.out.println(format(c.getTime()));
        c.add(Calendar.MONTH,2);        //因为要求倒数,所以将日历设置为下下个月
        //System.out.println(format(c.getTime()));
        /**或者可以这么写
        c.set(Calendar.DATE,1);
        c.add(Calendar.DATE,-3);
         */
        c.set(Calendar.DATE,-2);        //0表示倒数第一天
        System.out.println("下个月的倒数第三天: \t"+format(c.getTime()));
    }

    private static String format(Date time){
        return sdf.format(time);
    }
}
