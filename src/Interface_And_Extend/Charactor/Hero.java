package Interface_And_Extend.Charactor;

/*  Author: 北辰
    日期: 13/10/2019
    功能: Hero类,有一个kill方法,可以杀死不同的英雄
 */

import Interface_And_Extend.*;
import Interface_And_Extend.ADHero;

public class Hero {
    public String name;                 //姓名
    protected float hp;                 //血量
    float armor;                        //护甲
    int moveSpeed;                      //移动速度

    //类方法,静态方法
    //通过类就可以直接调用
    public static void battleWin(){
        System.out.println("hero battle win");
    }

    public void kill(Mortal m){
        m.die();
    }

    //无参构造方法
    public Hero(){
        System.out.println("Hero的无参构造方法 ");
    }
    //有参构造方法
    public Hero(String name){
        System.out.println("Hero的有一个参数的构造方法");
        this.name = name;
    }

    public void useItem(Item i){
        System.out.println("hero use item");
        i.effect();
    }

    public static void main(String[] args){
        Hero garen = new Hero();
        garen.name = "盖伦";

        //初始化三个不同的英雄,分别为ADHero,APHero,ADAPHero
        ADHero vn = new ADHero();
        vn.name = "薇恩";
        APHero ruiz = new APHero();
        ruiz.name = "瑞兹";
        ADAPHero yize = new ADAPHero();
        yize.name = "伊泽瑞尔";

        System.out.println(garen.name+"使: ");
        garen.kill(vn);
        garen.kill(ruiz);
        garen.kill(yize);
    }
}
