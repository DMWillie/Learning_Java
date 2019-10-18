package Interface_And_Extend.Charactor;

import Interface_And_Extend.AD;

/*  Author: 北辰
    日期: 18/10/2019
    功能: 子类ADHero_abstract继承AbstractHero类,一定要重写attack()方法
 */

public class ADHero_abstract extends AbstractHero implements AD {
    @Override
    public void physicAttack(){
        System.out.println("进行物理攻击");
    }
    @Override
    public void attack(){
        physicAttack();;
    }
}
