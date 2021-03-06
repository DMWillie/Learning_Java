package multiplethread;

/*  Author: 北辰
    日期: 11/01/2020
    功能: 设计一个类KillThread 继承Thread，并且重写run方法
 */

public class KillThread extends Thread{
    private Hero h1;
    private Hero h2;

    public KillThread(Hero h1,Hero h2){
        this.h1 = h1;
        this.h2 = h2;
    }
    public void run(){
        while(!h2.isDead()){
            h1.attackHero(h2);
        }
    }
}
