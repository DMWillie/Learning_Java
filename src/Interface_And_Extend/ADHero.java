package Interface_And_Extend;

/*  Author: 北辰
    日期: 12/10/2019
    功能: 设计一个英雄类,能够进行物理攻击
 */


public class ADHero extends Hero implements AD,Mortal{
    @Override
    public void physicAttack(){
        System.out.println("进行物理攻击");
    }

    @Override
    //实现Mortal接口
    public void die(){
        System.out.println(this.name+"被杀");
    }
}
