package Interface_And_Extend;

/*  Author: 北辰
    日期: 13/10/2019
    功能: 子类MagicPotion(蓝瓶)继承父类Item,并重写effect方法
 */

public class MagicPotion extends Item{

    @Override
    public void effect(){
        System.out.println("蓝瓶使用后,可以回魔法");
    }
}
