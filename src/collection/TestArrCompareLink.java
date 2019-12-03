package collection;

/*  Author: 北辰
    日期: 01/12/2019
    修改: 03/12/2019,增加在任意位置插入数据的方法
    功能: 对比ArrayList和LinkedList的区别,比较它们插入数据和定位数据的时间
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestArrCompareLink {
    public static void main(String[] args){
        List<Integer> l;
        //在最前面插入
        l = new ArrayList<>();
        insertFirst(l,"ArrayList");

        l = new LinkedList<>();
        insertFirst(l,"LinkedList");
        //定位最中间的数据
        l = new ArrayList<>();
        modify(l,"ArrayList");

        l = new LinkedList<>();
        modify(l,"LinkedList");;
        //在最后面插入
        l = new ArrayList<>();
        insert(l,"ArrayList",1.0);

        l = new LinkedList<>();
        insert(l,"LinkedList",1.0);
        //在最中间插入数据
        l = new ArrayList<>();
        insert(l,"ArrayList",0.5);

        l = new LinkedList<>();
        insert(l,"LinkedList",0.5);
    }
    //插入数据
    private static void insertFirst(List<Integer> l,String type){
        int total = 1000*100;
        final int number = 5;
        long start = System.currentTimeMillis();
        for(int i=0;i<total;i++){
            l.add(0,number);
        }
        long end = System.currentTimeMillis();
        System.out.printf("在%s 最前面插入%d条数据，总共耗时%d 毫秒 %n",type,
                total,end-start);
    }
    //定位数据
    private static void modify(List<Integer> l,String type){
        int total = 1000*100;
        int index = total/2;
        final int number = 5;
        //初始化
        for(int i=0;i<total;i++){
            l.add(number);
        }
        long start = System.currentTimeMillis();
        for(int i=0;i<total;i++){
            int n = l.get(index);   //获取索引值为index的那个数
            n++;
            l.set(index,n);         //让索引为index的数加1
        }
        long end = System.currentTimeMillis();
        System.out.printf("%s总长度是%d,定位到第%d个数据,取出来,加1,再放回去%n,重复%d遍," +
                "总共耗时%d 毫秒 %n",type,total,index,total,end-start);
        System.out.println();
    }
    //在任意位置插入数据
    private static void insert(List<Integer> l,String type,double rate){
        int total = 1000*100;
        final int num = 5;
        long start = System.currentTimeMillis();
        for(int i=0;i<total;i++){
            int pos = (int)(l.size()*rate);        //要插入的位置
            l.add(pos,num+i);
        }
        long end = System.currentTimeMillis();
        if(rate==0.5) {
            System.out.printf("在%s 的最中间位置插入数字%d %d次,耗时%s 毫秒%n",
                    type, num, total, end - start);
        }
        else if(rate==1.0){
            System.out.printf("在%s 的最后面插入数字%d %d次,耗时%s 毫秒%n",
                    type, num, total, end - start);
        }else{
            System.out.printf("在%s 的百分之%d的位置插入数字%d %d次,耗时%s 毫秒%n",
                    type, rate*100,num, total, end - start);
        }
    }
}
