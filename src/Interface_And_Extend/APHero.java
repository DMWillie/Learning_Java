package Interface_And_Extend;

/*  Author: 北辰
    日期: 12/10/2019
    功能: 设计一个英雄类,能够进行魔法攻击
 */


public class APHero extends Hero implements AP,Mortal {
    @Override
    public void magicAttack(){
        System.out.println("进行魔法攻击");
    }

    //实现Mortal接口
    @Override
    public void die(){
        System.out.println(this.name+"被杀");
    }
}
