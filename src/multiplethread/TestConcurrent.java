package multiplethread;

/*  Author: 北辰
    日期: 26/01/2020
    功能:分别使用基本变量的非原子性的++运算符和 原子性的AtomicInteger对象的 incrementAndGet
        来进行多线程测试
    对运行几次,会看到value的值并不等于number;但是atomicValue的值等于number
 */

import java.util.concurrent.atomic.AtomicInteger;

public class TestConcurrent {
    private static int value = 0;
    private static AtomicInteger atomicValue = new AtomicInteger();

    public static void main(String[] args) {
        int number = 10000;
        Thread[] ts1 = new Thread[number];
        System.out.println("value的初始值为: "+value);
        for(int i=0;i<number;i++){
            Thread t = new Thread(){
                public void run(){
                    value++;
                }
            };
            t.start();
            ts1[i] = t;
        }
        //等待这些线程全部结束
        for(Thread t:ts1){
            try{
                t.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.printf("%d个线程进行value++后，value的值变成:%d%n",number,value);
        Thread[] ts2 = new Thread[number];
        System.out.println("atomicValue的初始值为: "+atomicValue);
        for(int i=0;i<number;i++){
            Thread t = new Thread(){
                public void run(){
                    atomicValue.incrementAndGet();
                }
            };
            t.start();
            ts2[i] = t;
        }
        //等待这些线程全部结束
        for (Thread t:ts2) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.printf("%d个线程进行atomicValue.incrementAndGet后," +
                "atomicValue的值变成:%d%n", number,atomicValue.intValue());
    }
}
