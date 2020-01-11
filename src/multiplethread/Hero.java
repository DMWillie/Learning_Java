package multiplethread;

/*  Author: 北辰
    日期: 11/01/2020
    功能: 多进程章节的英雄类
 */

public class Hero {

    public String name;
    public float hp;
    public int damage;

    public void attackHero(Hero h){
        try{
            //为了表示攻击需要时间，每次攻击暂停1000毫秒
            Thread.sleep(1000);
        }catch(InterruptedException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        h.hp -= damage;
        System.out.format("%s 正在攻击 %s, %s的血量变成了 %.0f%n",name,h.name,h.name,h.hp);
        if(h.isDead())
            System.out.println(h.name+" 死了!");
    }
    public boolean isDead(){
        return 0>=hp?true:false;
    }
}
