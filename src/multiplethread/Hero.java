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
    //英雄发动波动拳技能(第k发)
    public void launchSkill(int k){
        System.out.printf("%s发动第%d次冲击拳%n",name,k);
    }
    //英雄充能(充能t秒)
    public void charge(int t){
        System.out.printf("%s开始为时%d秒的充能%n",name,t);
    }
}
