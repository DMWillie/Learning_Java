package multiplethread;
/*  Author: 北辰
    日期: 12/01/2020
    功能: 守护线程,当一个进程里，所有的线程都是守护线程的时候，结束当前进程
    守护线程通常会被用来做日志，性能统计等工作
 */
public class TestThreadDaemon {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            public void run(){
                int seconds = 0;
                while(true){
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.printf("已经玩了LOL %d 秒%n", seconds++);
                }
            }
        };
        t1.setDaemon(true); //将t1设置为守护线程
        t1.start();     //因为当前进程只有t1线程(除了主线程),当t1被设置为守护线程时,当前进程(程序)也就结束了
                        //因此不会执行t1线程的方法
    }
}
