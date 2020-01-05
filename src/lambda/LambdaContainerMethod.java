package lambda;

/*  Author: 北辰
    日期: 05/01/2020
    功能: 引用容器中的对象的方法
 */

import character.MyHeroCompare;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LambdaContainerMethod {
    public static void main(String[] args) {
        Random r = new Random();
        List<MyHeroCompare> heros = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            heros.add(new MyHeroCompare("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);

        System.out.println("Lambda表达式：");
        filter(heros,h -> h.hp>100&&h.damage<50);

        System.out.println("Lambda表达式中调用容器中的对象的matched方法：");
        filter(heros,h->h.matched());

        System.out.println("引用容器中对象的方法 之过滤结果：");
        filter(heros,MyHeroCompare::matched);
    }

    private static void filter(List<MyHeroCompare> heros, HeroChecker checker) {
        for (MyHeroCompare hero : heros) {
            if (checker.test(hero))
                System.out.print(hero);
        }
    }
}
