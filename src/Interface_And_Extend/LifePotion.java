package Interface_And_Extend;

/*  Author: 北辰
    日期: 13/10/2019
    功能: 子类LifePotion(血瓶)继承父类Item,并重写effect方法
 */

public class LifePotion extends Item{

    @Override
    public void effect(){
        System.out.println("血瓶使用后,可以回血");
    }
}
