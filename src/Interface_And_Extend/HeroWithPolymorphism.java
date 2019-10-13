package Interface_And_Extend;

/*  Author: 北辰
    日期: 13/10/2019
    功能: Hero类有使用各种物品的方法,如useLifePotion,useMagicPotion等(使用多态实现)
 */

public class HeroWithPolymorphism {
    public String name;
    protected float hp;

    public void useItem(Item i){
        /*参数为i,类型为Item
        如果是使用血瓶，调用该方法
        如果是使用魔瓶，还是调用该方法
        无论英雄要使用什么样的物品，只需要一个方法即可
         */
        i.effect();
    }

    public static void main(String[] args) {
        HeroWithPolymorphism garen =  new HeroWithPolymorphism();
        garen.name = "盖伦";

        LifePotion lp =new LifePotion();
        MagicPotion mp =new MagicPotion();

        garen.useItem(lp);
        garen.useItem(mp);
    }
}
