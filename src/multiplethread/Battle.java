package multiplethread;

/*  Author: 北辰
    日期: 11/01/2020
    功能: 创建类Battle，实现Runnable接口
 */

public class Battle implements Runnable{
    private Hero h1;
    private Hero h2;

    public Battle(Hero h1,Hero h2){
        this.h1 = h1;
        this.h2 = h2;
    }
    @Override
    public void run(){
        while(!h2.isDead())
            h1.attackHero(h2);
    }
}
