package multiplethread;
/*  Author: 北辰
    日期: 12/01/2020
    功能: 为了演示线程优先级的关系,将英雄类的暂停时间去掉
 */
public class PriorityHero {
    public String name;
    public float hp;
    public int damage;

    public void attackHero(PriorityHero h){
        //把暂停时间去掉，多条线程各自会尽力去占有CPU资源
        //线程的优先级效果才可以看得出来
//        try{
//            Thread.sleep(0);
//        }catch(InterruptedException e){
//            e.printStackTrace();
//        }
        h.hp -= damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);
        if(h.isDead())
            System.out.println(h.name +"死了！");
    }
    public boolean isDead(){
        return hp>0?false:true;
    }
}
