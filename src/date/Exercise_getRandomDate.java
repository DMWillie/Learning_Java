package date;

/*  Author: 北辰
    日期: 02/11/2019
    功能: 借助随机数，创建一个从1995.1.1 00:00:00 到 1995.12.31 23:59:59 之间的随机日期
 */

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise_getRandomDate {
    public static void main(String[] args){
        Exercise_getRandomDate solution = new Exercise_getRandomDate();
        Scanner input = new Scanner(System.in);
        HashMap<String,Integer> startDate =
                new HashMap<>();        //存储开始日期
        HashMap<String, Integer> endDate =
                new HashMap<>();        //存储结束日期
        System.out.println("请输入一个开始的日期(1900年之后):");
        System.out.print("year: ");
        startDate.put("year",input.nextInt());
        System.out.print("month: ");
        startDate.put("month",input.nextInt());
        System.out.print("day: ");
        startDate.put("day",input.nextInt());
        System.out.print("hour: ");
        startDate.put("hour",input.nextInt());
        System.out.print("minute: ");
        startDate.put("minute",input.nextInt());
        System.out.print("second: ");
        startDate.put("second",input.nextInt());
        System.out.println("请输入一个结束的日期(1900年之后):");
        System.out.print("year: ");
        endDate.put("year",input.nextInt());
        System.out.print("month: ");
        endDate.put("month",input.nextInt());
        System.out.print("day: ");
        endDate.put("day",input.nextInt());
        System.out.print("hour: ");
        endDate.put("hour",input.nextInt());
        System.out.print("minute: ");
        endDate.put("minute",input.nextInt());
        System.out.print("second: ");
        endDate.put("second",input.nextInt());
        System.out.println("这两个日期之间的随机日期为: ");
        System.out.println(solution.getRandomDate(startDate,endDate));
    }

    public Date getRandomDate(HashMap<String,Integer> startMap,HashMap<String,Integer> endMap){
        //JDK中year的起点为1900年,month的范围为0-11
        Date start = new Date(startMap.get("year")-1900,startMap.get("month")-1,
                startMap.get("day"),startMap.get("hour"),startMap.get("minute"),startMap.get("second"));
        long startTimeMills = start.getTime();
        Date end = new Date(endMap.get("year")-1900,endMap.get("month")-1,
                endMap.get("day"),endMap.get("hour"),endMap.get("minute"),endMap.get("second"));
        long endTimeMills = end.getTime();
        long randomTimeMills =(long)(Math.random()*(endTimeMills-startTimeMills+1)
                + startTimeMills);
        return new Date(randomTimeMills);
    }
}
