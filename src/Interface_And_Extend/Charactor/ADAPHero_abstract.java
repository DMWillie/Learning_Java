package Interface_And_Extend.Charactor;

/*  Author: 北辰
    日期: 18/10/2019
    功能: 子类ADAPHero_abstract继承AbstractHero类,一定要重写attack()方法
 */

import Interface_And_Extend.AD;
import Interface_And_Extend.AP;

public class ADAPHero_abstract extends AbstractHero implements AD, AP {
    @Override
    public void physicAttack(){
        System.out.println("进行物理攻击");
    }
    @Override
    public void magicAttack(){
        System.out.println("进行物理攻击");
    }
    @Override
    public void attack(){
        System.out.println("既可以进行物理攻击,又可以进行魔法攻击");
    }
}
