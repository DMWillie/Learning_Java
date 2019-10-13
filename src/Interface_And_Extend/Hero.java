package Interface_And_Extend;

/*  Author: 北辰
    日期: 13/10/2019
    功能: Hero类有使用各种物品的方法,如useLifePotion,useMagicPotion等(不使用多态实现)
 */

public class Hero {
    public String name;
    protected float hp;

    public void useLifePotion(LifePotion lp){
        lp.effect();
    }
    public void useMagicPotion(MagicPotion mp){
        mp.effect();
    }

    public static void main(String[] args) {
        Hero garen =  new Hero();
        garen.name = "盖伦";

        LifePotion lp =new LifePotion();
        MagicPotion mp =new MagicPotion();

        garen.useLifePotion(lp);
        garen.useMagicPotion(mp);
    }
}