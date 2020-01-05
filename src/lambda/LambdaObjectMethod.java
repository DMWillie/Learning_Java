package lambda;

/*  Author: 北辰
    日期: 05/01/2020
    功能: 在Lambda表达式中引用对象方法
 */

import character.MyHeroCompare;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LambdaObjectMethod {

    public static void main(String[] args) {
        Random r = new Random();
        List<MyHeroCompare> heros = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            heros.add(new MyHeroCompare("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);
        System.out.println("使用引用对象方法  的过滤结果: ");
        //使用类的对象方法
        LambdaObjectMethod testLambda = new LambdaObjectMethod();
        filter(heros,testLambda::testHero);
    }
    public boolean testHero(MyHeroCompare h){
        return h.hp>100&&h.damage<50;
    }

    private static void filter(List<MyHeroCompare> heros,HeroChecker checker){
        for(MyHeroCompare hero:heros){
            if(checker.test(hero))
                System.out.print(hero);
        }
    }
}
