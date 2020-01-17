package multiplethread;

/*  Author: 北辰
    日期: 16/01/2020
    功能: 在recovery前，直接加上synchronized ，其所对应的同步对象，就是this
    和hurt方法达到的效果是一样
    外部线程访问gareen的方法，就不需要额外使用synchronized 了
 */

public class TestSynchronizedHero {
    public static void main(String[] args) {

        final SynchronizedHero gareen = new SynchronizedHero();
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
                    //recover自带synchronized
                    gareen.recovery();
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
                    //hurt自带synchronized
                    gareen.hurt();
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
