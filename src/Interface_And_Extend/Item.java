package Interface_And_Extend;

/*  Author: 北辰
    日期: 13/10/2019
    功能: 父类Item,物品类
 */

public class Item {
    String name;
    int price;

    public void buy(){
        System.out.println("购买");
    }
    public void effect(){
        System.out.println("物品使用后,可以有效果");
    }

    public static void main(String[] args){
        Item i = new Item();
        i.effect();         //执行父类的effect()方法

        LifePotion lp = new LifePotion();
        lp.effect();        //执行子类重写的effect()方法
    }
}
