package multiplethread;
/*  Author: 北辰
    日期: 12/01/2020
    功能: 当前线程，临时暂停，使得其他线程可以有更多的机会占用CPU资源
 */
public class TestThreadYield {
    public static void main(String[] args) {
        final PriorityHero gareen = new PriorityHero();
        gareen.name = "盖伦";
        gareen.hp = 6160;
        gareen.damage = 1;

        final PriorityHero teemo = new PriorityHero();
        teemo.name = "提莫";
        teemo.hp = 3000;
        teemo.damage = 1;

        final PriorityHero bh = new PriorityHero();
        bh.name = "赏金猎人";
        bh.hp = 5000;
        bh.damage = 1;

        final PriorityHero leesin = new PriorityHero();
        leesin.name = "盲僧";
        leesin.hp = 4505;
        leesin.damage = 1;

        Thread t1 = new Thread(){
            public void run(){
                while(!teemo.isDead())
                    gareen.attackHero(teemo);
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                while(!leesin.isDead()){
                    //临时暂停，使得t1可以占用CPU资源
                    Thread.yield();
                    bh.attackHero(leesin);
                }
            }
        };
        t1.setPriority(5);    //t1设置为普通优先级
        t2.setPriority(5);    //t2也设置为普通优先级
        t1.start();
        t2.start();
    }
}
