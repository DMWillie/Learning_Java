package generic;

/*  Author: 北辰
    日期: 04/01/2020
    功能: 将子类泛型转为父类泛型?
    假设可以转型成功
引用hs指向了ADHero泛型的容器
作为Hero泛型的引用hs, 看上去是可以往里面加一个APHero的。
但是hs这个引用，实际上是指向的一个ADHero泛型的容器
如果能加进去，就变成了ADHero泛型的容器里放进了APHero，这就矛盾了
所以子类泛型不可以转换为父类泛型
 */

import Interface_And_Extend.ADHero;
import Interface_And_Extend.APHero;
import Interface_And_Extend.Hero;

import java.util.ArrayList;

public class TestUpTransform {
    public static void main(String[] args){
        ArrayList<Hero> hs = new ArrayList<>();//Hero泛型
        ArrayList<ADHero> adhs = new ArrayList<>(); //ADHero泛型
        //假设能转换成功
        /**hs = adhs;
        作为Hero泛型的hs,是可以向其中加入APHero的
        但是hs这个引用，实际上是指向的一个ADHero泛型的容器
        如果能加进去，就变成了ADHero泛型的容器里放进了APHero，这就矛盾了
        hs.add(new APHero());
        */
        /**同理,父类泛型也不能转换为子类泛型
         * 如果父类泛型中放了APHero类型的对应,那么adhs(子类泛型)调用get方法得到的就是一个APHero
         * 而APHero是不能强制转换为ADHero的
        adhs = hs;
        adhs.add(new APHero());
         */
    }
}
