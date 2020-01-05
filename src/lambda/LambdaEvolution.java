package lambda;

/*  Author: 北辰
    日期: 05/01/2020
    功能: Lambda表达式可以看成是匿名类一点点演变过来
    与匿名类 概念相比较，
    Lambda 其实就是匿名方法，这是一种把方法作为参数进行传递的编程思想。
    但是，Java会在背后，悄悄的，把这些都还原成匿名类方式。
    引入Lambda表达式，会使得代码更加紧凑，而不是各种接口和匿名类到处飞
 */

import character.MyHeroCompare;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LambdaEvolution {
    public static void main(String[] args) {
        Random r = new Random();
        List<MyHeroCompare> heros = new ArrayList<>();
        for(int i=0;i<5;i++){
            heros.add(new MyHeroCompare("hero "+i,
                    r.nextInt(1000),r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);
        System.out.println("使用匿名类的方式，筛选出 hp>100 && damage<50的英雄");
        //匿名类的正常写法
        HeroChecker c1 = new HeroChecker(){
            @Override
            public boolean test(MyHeroCompare h){
                return (h.hp>100&&h.damage<50);
            }
        };
        // 把new HeroChecker，方法名，方法返回类型信息去掉
        // 只保留方法参数和方法体
        // 参数和方法体之间加上符号 ->
        HeroChecker c2 = (MyHeroCompare h)->{
            return (h.hp>100&&h.damage<50);
        };
        // 把return和{}去掉
        HeroChecker c3 = (MyHeroCompare h)->(h.hp>100&&h.damage<50);
        // 把 参数类型和圆括号去掉
        HeroChecker c4 = h->h.hp>100&&h.damage<50;
        // 把c4作为参数传递进去
        filter(heros,c4);
        // 直接把表达式传递进去
        System.out.println("使用Lambda的方式，筛选出 hp>100 && damage<50的英雄");
        filter(heros,h->h.hp>100&&h.damage<50);
    }

    private static void filter(List<MyHeroCompare> heros,HeroChecker checker){
        for(MyHeroCompare hero:heros){
            if(checker.test(hero)){
                System.out.print(hero);
            }
        }
    }
}
