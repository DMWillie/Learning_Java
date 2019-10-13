package Interface_And_Extend;

/*  Author: 北辰
    日期: 12/10/2019
    功能: 设计一个英雄类,既能够进行物理攻击,又能够进行魔法攻击
 */


public class ADAPHero extends Hero implements AD,AP,Mortal {
    @Override
    public void physicAttack(){
        System.out.println("进行物理攻击");
    }
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
