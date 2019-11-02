package date;

/*  Author: 北辰
    日期: 02/11/2019
    功能: 测试Java中的日期类Date的用法
 */

import java.util.Date;

public class TestDate {
    public static void main(String[] args){
        //当前时间
        Date d1 = new Date();
        System.out.println("当前时间: ");
        System.out.println(d1);
        //从1970年1月1日 早上8点0分0秒 开始经历的毫秒数
        Date d2 = new Date(15000);
        System.out.println("从1970年1月1日 早上8点0分0秒 经过15秒后的时间为:");
        System.out.println(d2);

        Date now = new Date();
        //打印当前时间
        System.out.println("当前时间:"+now.toString());
        //getTime()得到一个long型的整数
        //这个整数代表 1970.1.1 08:00:00:000，每经历一毫秒，增加1
        System.out.println("当前时间getTime()返回的值是:\t\t\t\t\t\t"+now.getTime());
        //通过System.currentTimeMills()获取当前日期的毫秒数
        System.out.println("当前时间System.currentTimeMills()返回的值是:\t\t"+System.currentTimeMillis());

        Date zero = new Date(0);
        System.out.println("用0做构造方法,得到的日期是:"+zero);
    }
}
