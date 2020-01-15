package multiplethread;

/*  Author: 北辰
    日期: 15/01/2020
    功能: 使用synchronized 解决同步问题
    所有需要修改hp的地方，必须建立在占有someObject的基础上。
而对象 someObject在同一时间，只能被一个线程占有。 间接地，导致同一时间，hp只能被一个线程修改。
 */

public class UseSynchronized {
    public static void main(String[] args) {
        final Object someObject = new Object();

        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 10000;
        System.out.printf("盖伦的初始血量是: %.0f%n",gareen.hp);
        //多线程同步问题指的是多个线程同时修改一个数据的时候，导致的问题
        //假设盖伦有10000滴血，并且在基地里，同时又被对方多个英雄攻击
        //用JAVA代码来表示，就是有多个线程在减少盖伦的hp
        //同时又有多个线程在恢复盖伦的hp

        //n个线程增加盖伦的hp
        int n = 10000;
        Thread[] addThreads = new Thread[n];
        Thread[] reduceThreads = new Thread[n];
        for(int i=0;i<n;i++){
            Thread t = new Thread(){
                public void run(){
                    //任何线程要修改hp的值，必须先占有someObject
                    synchronized(someObject){
                        gareen.recovery();
                    }
                    try{
                        Thread.sleep(100);
                    }catch(InterruptedException e){
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThreads[i] = t;
        }
        //n个线程减少盖伦的hp
        for(int i=0;i<n;i++){
            Thread t = new Thread(){
                public void run(){
                    //任何线程要修改hp的值，必须先占有someObject
                    synchronized(someObject){
                        gareen.hurt();
                    }
                    try{
                        Thread.sleep(100);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reduceThreads[i] = t;
        }
        //等待所有增加线程结束
        for(Thread t:addThreads){
            try{
                t.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        //等待所有减少线程结束
        for(Thread t:reduceThreads){
            try{
                t.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        //代码执行到这里，所有增加和减少线程都结束了
        //增加和减少线程的数量是一样的，每次都增加，减少1.
        //那么所有线程都结束后，盖伦的hp应该还是初始值
        //增加了synchronized来保证同步正常
        System.out.printf("%d个增加线程和%d个减少线程结束后%n盖伦的血量是 %.0f%n",
                n,n,gareen.hp);
    }
}
