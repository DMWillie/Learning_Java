package multiplethread;

/*  Author: 北辰
    日期: 11/01/2020
    功能: 不使用多线程的情况：
只有在盖伦杀掉提莫后，赏金猎人才开始杀盲僧
 */

public class TestNoThread {
    public static void main(String[] args) {
        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;

        //盖伦攻击提莫
        while(!teemo.isDead())
            gareen.attackHero(teemo);

        //赏金猎人攻击盲僧
        while(!leesin.isDead())
            bh.attackHero(leesin);
    }
}
