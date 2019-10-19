package Interface_And_Extend.Charactor;

/*  Author: 北辰
    日期: 18/10/2019
    功能: 子类APHero_abstract继承AbstractHero类,一定要重写attack()方法
 */

import Interface_And_Extend.AP;

public class APHero_abstract extends AbstractHero implements AP {
    @Override
    public void magicAttack(){
        System.out.println("进行魔法攻击");
    }
    @Override
    public void attack(){
        magicAttack();
    }
}
