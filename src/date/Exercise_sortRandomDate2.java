package date;

/*  Author: 北辰
    日期: 02/11/2019
    功能: 准备一个长度是9的日期数组
        使用1970年-2000年之间的随机日期初始化该数组
        按照这些日期的时间进行升序排序
        比如 1988-1-21 12:33:22 就会排在 1978-4-21 19:07:23 前面，因为它的时间更小，虽然日期更大
   改进版本,
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class Exercise_sortRandomDate2 {
    public static void main(String[] args){
        int yearStart = 1970;       //起始年份
        int yearEnd = 2000;         //结束年份

        Date[] ds = new Date[9];
        for(int i=0;i<ds.length;i++){
            ds[i] = getRandomDate(yearStart,yearEnd);
        }

        System.out.println("得到的随机日期数组为: ");
        for(int i=0;i<ds.length;i++){
            System.out.print(toString(ds[i])+"\t");
            if(i%3==2)
                System.out.println();
        }

        //利用选择排序算法对日期按照时间从小到大排序
        for(int i=0;i<ds.length-1;i++){
            for(int j=i+1;j<ds.length;j++){
                String strTimeI = toString(ds[i],"HHmmss");
                String strTimeJ = toString(ds[j],"HHmmss");

                int timeI = Integer.parseInt(strTimeI);
                int timeJ = Integer.parseInt(strTimeJ);
                if(timeJ<timeI){
                    Date temp = ds[i];
                    ds[i] = ds[j];
                    ds[j] = temp;
                }
            }
        }

        System.out.println("排序后的日期时间数组为: ");
        for(int i=0;i<ds.length;i++){
            System.out.print(toString(ds[i])+"\t");
            if(i%3==2)
                System.out.println();
        }
    }

    public static String toString(Date d){
        return toString(d,"yyyy-MM-dd HH:mm:ss");
    }

    public static String toString(Date d,String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(d);
    }

    //产生一个指定范围内的随机日期
    private static Date getRandomDate(int yearStart,int yearEnd){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        try{
            //开始日期:1970,如果没有月份小时等,默认为1月1日00:00:00
            Date dStart = sdf.parse(String.valueOf(yearStart));
            //结束日期为:2000年最后一天,但是只传年份的话我们就传2001,与2000年最后一刻相差1ms
            Date dEnd = sdf.parse(String.valueOf(yearEnd+1));
            long timeStart = dStart.getTime();
            long timeEnd = dEnd.getTime()-1;
            long timeRandom = (long)((timeEnd-timeStart)*Math.random()+timeStart);
            return new Date(timeRandom);
        }catch(ParseException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
