package multiplethread;

/*  Author: 北辰
    日期: 18/01/2020
    功能: 多进程章节的英雄类,使用synchronized修饰hero对象和对应的方法,并增加
    wait和notify进行线程交互
 */

public class InteractionHero {
    public String name;
    public float hp;
    public int damage;

    //回血
    //直接在方法前加上修饰符synchronized
    //其所对应的同步对象，就是this
    //和hurt方法达到的效果一样
    public synchronized void recovery(){
        hp = hp + 1;
        System.out.printf("%s 回血1点,增加血后，%s的血量是%.0f%n", name, name, hp);
        // 通知那些等待在this对象上的线程，可以醒过来了，如等待着的减血线程，苏醒过来
        this.notify();
    }
    //掉血
    public synchronized void hurt(){
        if(hp==1){
            try{
                // 让占有this的减血线程，暂时释放对this的占有，并等待
                this.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        hp = hp - 1;
        System.out.printf("%s 减血1点,减少血后，%s的血量是%.0f%n", name, name, hp);
    }
    public void attackHero(InteractionHero h){
        h.hp -= damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);
        if(h.isDead())
            System.out.println(h.name +"死了！");
    }
    public boolean isDead(){
        return 0>=hp?true:false;
    }
}
