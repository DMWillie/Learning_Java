package lambda;

/*  Author: 北辰
    日期: 04/01/2020
    功能: 假设一个情景： 找出满足条件的Hero
        我们将从使用普通方法，匿名类，以及Lambda这几种方式，逐渐的引入Lambda的概念
 */

import character.MyHeroCompare;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestLambda {

    public static void main(String[] args){
        Random r = new Random();
        List<MyHeroCompare> heros = new ArrayList<>();
        for(int i=0;i<10;i++){
            heros.add(new MyHeroCompare("hero "+i,r.nextInt(1000),
                    r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);
        System.out.println("使用普通方式筛选出 hp>100 && damage<50的英雄");
        filterGeneral(heros);
        System.out.println("使用匿名类的方式，筛选出 hp>100 && damage<50的英雄");
        HeroChecker checker = new HeroChecker() {
            @Override
            public boolean test(MyHeroCompare h) {
                return (h.hp>100&&h.damage<50);
            }
        };
        filterAnonymous(heros,checker);
        /**使用Lambda方式筛选出数据
         * 同样是调用filter方法，从上一步的传递匿名类对象，变成了传递一个Lambda表达式进去
         */
        System.out.println("使用Lambda的方式，筛选出 hp>100 && damage<50的英雄");
        filterAnonymous(heros,h->h.hp>100&&h.damage<50);
    }

    /**第一种方式
     * 使用一个普通方法，在for循环遍历中进行条件判断，筛选出满足条件的数据
    hp>100 && damage<50
     */
    private static void filterGeneral(List<MyHeroCompare> heros){
        for(MyHeroCompare hero:heros){
            if(hero.hp>100&&hero.damage<50)
                System.out.print(hero);
        }
    }

    /**第二种方式
     * 匿名类方式,首先准备一个接口HeroChecker，提供一个test(Hero)方法
     * 然后通过匿名类的方式，实现这个接口.接着调用filter，传递这个checker进去进行判断，
     * 这种方式就很像通过Collections.sort在对一个Hero集合排序，需要传一个Comparator的匿名类对象进去一样
     */
    private static void filterAnonymous(List<MyHeroCompare> heros,HeroChecker checker){
        for(MyHeroCompare hero:heros){
            if(checker.test(hero))
                System.out.print(hero);
        }
    }
}

