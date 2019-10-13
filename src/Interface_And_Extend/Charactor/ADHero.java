package Interface_And_Extend.Charactor;

/*  Author: 北辰
    日期: 13/10/2019
    功能: 子类隐藏父类的类方法
 */

import Interface_And_Extend.AD;

public class ADHero extends Hero implements AD {

    @Override
    public void physicAttack(){
        System.out.println("进行物理攻击");
    }

    //隐藏父类的battleWin方法
    public static void battleWin(){
        System.out.println("ad hero battle win");
    }

    public static void main(String[] args){
        Hero.battleWin();       //打印hero battle win
        ADHero.battleWin();     //打印ad hero battle win

        Hero h = new ADHero();
        h.battleWin();          //打印hero battle win
    }
}
