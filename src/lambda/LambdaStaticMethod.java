package lambda;

/*  Author: 北辰
    日期: 05/01/2020
    功能: 在Lambda表达式中调用及引用静态方法
 */

import character.MyHeroCompare;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LambdaStaticMethod {
    public static void main(String[] args) {
        Random r = new Random();
        List<MyHeroCompare> heros = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            heros.add(new MyHeroCompare("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);

        HeroChecker c = new HeroChecker(){
            @Override
            public boolean test(MyHeroCompare h){
                return h.hp>100&&h.damage<50;
            }
        };
        System.out.println("使用匿名类过滤");
        filter(heros,c);
        System.out.println("使用Lambda表达式");
        filter(heros,h->h.hp>100&&h.damage<50);
        System.out.println("在Lambda表达式中使用静态方法");
        filter(heros,h->LambdaStaticMethod.testHero(h));
        System.out.println("直接引用静态方法");
        filter(heros,LambdaStaticMethod::testHero);

    }

    public static boolean testHero(MyHeroCompare h){
        return h.hp>100&&h.damage<50;
    }

    private static void filter(List<MyHeroCompare> heros,HeroChecker checker){
        for(MyHeroCompare hero:heros){
            if(checker.test(hero))
                System.out.print(hero);
        }
    }
}
