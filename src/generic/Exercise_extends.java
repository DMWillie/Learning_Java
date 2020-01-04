package generic;

/*  Author: 北辰
    日期: 04/01/2020
    功能: 如代码所示，为了遍历不同泛型的3种集合，需要设计3个方法
借助? extends， 把代码减肥到只是用一种方法
 */

import Interface_And_Extend.ADHero;
import Interface_And_Extend.APHero;
import Interface_And_Extend.Hero;

import java.util.ArrayList;

public class Exercise_extends {
    public static void iterate(ArrayList<Hero> list) {
        for (Hero hero : list) {
            System.out.println(hero.name);
        }
    }

    public static void iterateAP(ArrayList<APHero> list) {
        for (Hero hero : list) {
            System.out.println(hero.name);
        }
    }

    public static void iterateAD(ArrayList<ADHero> list) {
        for (Hero hero : list) {
            System.out.println(hero.name);
        }
    }

    public static void iterateGeneral(ArrayList<? extends Hero> list){
        for(Hero h:list){
            System.out.println(h.name);
        }
    }

    public static void main(String[] args) {
        Hero h1 = new Hero();
        h1.name = "gareen";
        Hero h2 = new Hero();
        h2.name = "teemo";

        ADHero adh1 = new ADHero();
        adh1.name = "伊泽瑞尔";
        ADHero adh2 = new ADHero();
        adh2.name = "霞";

        APHero aph1 = new APHero();
        aph1.name = "瑞兹";
        APHero aph2 = new APHero();
        aph2.name = "卡牌大师";

        ArrayList<Hero> hs = new ArrayList<>();
        hs.add(h1);
        hs.add(h2);
        ArrayList<APHero> aphs = new ArrayList<>();
        aphs.add(aph1);
        aphs.add(aph2);
        ArrayList<ADHero> adhs = new ArrayList<>();
        adhs.add(adh1);
        adhs.add(adh2);
        System.out.println("-----------第一种方式,使用三种方法迭代三个集合------------");
        System.out.println("迭代Hero集合: ");
        iterate(hs);
        System.out.println("迭代APHero集合: ");
        iterateAP(aphs);
        System.out.println("迭代ADHero集合: ");
        iterateAD(adhs);
        System.out.println("-----------第二种方式,使用一种方法迭代三个集合------------");
        System.out.println("迭代Hero集合: ");
        iterateGeneral(hs);
        System.out.println("迭代APHero集合: ");
        iterateGeneral(aphs);
        System.out.println("迭代ADHero集合: ");
        iterateGeneral(adhs);
    }
}
