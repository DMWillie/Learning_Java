package Interface_And_Extend.Charactor;

/*  Author: 北辰
    日期: 13/10/2019
    功能: Hero类,有一个kill方法,可以杀死不同的英雄
 */

import Interface_And_Extend.ADAPHero;
import Interface_And_Extend.ADHero;
import Interface_And_Extend.APHero;
import Interface_And_Extend.Mortal;

public class Hero {
    public String name;
    protected float hp;

    public void kill(Mortal m){
        m.die();
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
