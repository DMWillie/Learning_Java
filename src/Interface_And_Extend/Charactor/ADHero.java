package Interface_And_Extend.Charactor;

/*  Author: 北辰
    日期: 13/10/2019
    功能: 子类隐藏父类的类方法
 */

import Interface_And_Extend.AD;
import Interface_And_Extend.Item;
import Interface_And_Extend.LifePotion;

public class ADHero extends Hero implements AD {

    int moveSpeed = 400;        //移动速度

    @Override
    public void physicAttack(){
        System.out.println("进行物理攻击");
    }

    //使用super关键字显示调用父类带参的构造方法
    public ADHero(String name){
        super(name);
        System.out.println("ADHero 的构造方法");
    }

    //隐藏父类的battleWin方法
    public static void battleWin(){
        System.out.println("ad hero battle win");
    }

    public int getMoveSpeed(){
        return this.moveSpeed;          //调用自身属性moveSpeed
    }

    public int getMoveSpeed2(){
        return super.moveSpeed;         //调用父类属性moveSpeed
    }

    //子类重写useItem,并在其中调用父类的useItem方法
    public void useItem(Item i){
        System.out.println("adhero use item");
        super.useItem(i);
    }

    public static void main(String[] args){
        Hero.battleWin();       //打印hero battle win
        ADHero.battleWin();     //打印ad hero battle win
        System.out.println();

        Hero h = new ADHero("德莱文");
        System.out.println();
        h.battleWin();          //打印hero battle win
        System.out.println();
        ADHero h2 = new ADHero("寒冰");
        System.out.println(h2.getMoveSpeed());
        System.out.println(h2.getMoveSpeed2());
        LifePotion lp = new LifePotion();
        h2.useItem(lp);
    }
}
