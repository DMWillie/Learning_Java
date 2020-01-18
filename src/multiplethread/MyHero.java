package multiplethread;

/*  Author: 北辰
    日期: 18/01/2020
    功能: 多进程章节的英雄类,使用synchronized修饰hero对象和对应的方法,设置英雄最大血量
    为1000,当回血满之后让回血线程等待;当英雄血量为1时,让减血线程等待
 */

public class MyHero {
    public String name;
    public float hp;
    public int damage;

    public MyHero(){
    }
    //加血方法
    public synchronized void recovery(){
        if(hp==1000){
            try{
                //当英雄血量达到最大值后,让占有当前对应的线程临时释放资源并等待
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        hp = hp + 1;
        System.out.printf("%s 回血1点, 回血后 %s 的血量变为%.0f%n",name,name,hp);
        //通知等待当前对象的线程,并临时释放当前对象
        this.notify();
    }
    //减血方法
    public synchronized void hurt(){
        if(hp==1){
            //当英雄血量为1时,让占有当前对象的线程等待,临时释放当前对象
            try{
                this.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        hp = hp - 1;
        System.out.printf("%s 减血1点, 减血后 %s 的血量变为:%.0f%n",name,name,hp);
        //通知等待当前对象的线程,并临时释放资源
        this.notify();
    }
    public void attackHero(MyHero h){
        h.hp -= damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);
        if(h.isDead())
            System.out.println(h.name +"死了！");
    }
    public boolean isDead(){
        return 0>=hp?true:false;
    }
}
