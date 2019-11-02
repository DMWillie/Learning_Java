package date;

/*  Author: 北辰
    日期: 02/11/2019
    功能: 准备一个长度是9的日期数组
        使用1970年-2000年之间的随机日期初始化该数组
        按照这些日期的时间进行升序排序
        比如 1988-1-21 12:33:22 就会排在 1978-4-21 19:07:23 前面，因为它的时间更小，虽然日期更大
 */

import java.util.Date;
import java.text.SimpleDateFormat;

public class Exercise_sortRandomDate {

    public static void main(String[] args){
        Exercise_sortRandomDate solution = new Exercise_sortRandomDate();
        int k = 9;
        Date[] dates = new Date[k];  //日期数组
        solution.getRandomDateArray(k,dates);
        System.out.println("得到的随机日期数组: ");
        solution.printRandomDateArray(dates);
        System.out.println();
        System.out.println("按照时间排序后的随机日期数组为: ");
        solution.sortDate(dates);
        solution.printRandomDateArray(dates);
    }

    //对日期数组排序(按时间大小)***,选择排序
    public void sortDate(Date[] d){
        for(int i=1;i<d.length;i++){
            for(int j=i;j<d.length;j++){
                //minTime作为哨兵
                //将时间提取出来并变成6位整数
                int minTime = Integer.parseInt(toString(d[i-1],"HHmmss"));
                int timeJ = Integer.parseInt(toString(d[j],"HHmmss"));
                if(timeJ<minTime){  //时间靠后的整数值一定大
                    Date temp = d[i-1];
                    d[i-1] = d[j];
                    d[j] = temp;
                }
            }
        }

    }

    //将日期解析为相应的字符串***
    private static String toString(Date d,String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(d);
    }

    //生成随机日期数组
    public void getRandomDateArray(int n,Date[] d){
        /** param: n为要产生的随机日期数组中的随机日期数
         */
        Exercise_getRandomDate e = new Exercise_getRandomDate();
        e.getDateInterval();  //生成一个日期的区间
        for(int i=0;i<n;i++){
            d[i] = e.getRandomDate(e.startDate,e.endDate);
        }
    }

    //打印随机日期数组
    public void printRandomDateArray(Date[] dates){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(int i=0;i<dates.length;i++){
            if(i%3==0){
                System.out.println();
            }
            String str = sdf.format(dates[i]);
            System.out.print(str+"\t");
        }
    }
}
