package generic;

/*  Author: 北辰
    日期: 04/01/2020
    功能: ArrayList heroList<? extends Hero> 表示这是一个Hero泛型或者其子类泛型
heroList 的泛型可能是Hero
heroList 的泛型可能是APHero
heroList 的泛型可能是ADHero
所以 可以确凿的是，从heroList取出来的对象，一定是可以转型成Hero的
但是，不能往里面放东西，因为
放APHero就不满足<ADHero>
放ADHero又不满足<APHero>
 */

import Interface_And_Extend.ADHero;
import Interface_And_Extend.APHero;
import Interface_And_Extend.Hero;

import java.util.ArrayList;

public class TestExtends {
    public static void main(String[] args){
        ArrayList<APHero> apHeroList = new ArrayList<APHero>();
        apHeroList.add(new APHero());

        ArrayList<? extends Hero> heroList = apHeroList;
        //? extends Hero 表示这是一个Hero泛型的子类泛型
        //heroList 的泛型可以是Hero
        //heroList 的泛型可以是APHero
        //heroList 的泛型可以是ADHero
        //可以确凿的是，从heroList取出来的对象，一定是可以转型成Hero的
        Hero h = heroList.get(0);
        System.out.println(h);
        //但是，不能往里面放东西
        //heroList.add(new APHero());  //编译错误，因为heroList的泛型 有可能是ADHero
        //heroList.add(new ADHero());  //编译错误，因为heroList的泛型 有可能是APHero
    }
}
