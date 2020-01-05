package lambda;

/*  Author: 北辰
    日期: 05/01/2020
    功能: 使用传统方式与聚合操作方式遍历数据
}
 */

import character.MyHeroCompare;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LambdaAggregate {
    public static void main(String[] args) {
        Random r = new Random();
        List<MyHeroCompare> heros = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            heros.add(new MyHeroCompare("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);
        System.out.println("查询条件：hp>100 && damage<50");
        System.out.println("通过传统操作方式找出满足条件的数据：");
        for(MyHeroCompare h:heros){
            if(h.hp>100&&h.damage<50)
                System.out.println(h.name);
        }
        System.out.println("通过聚合操作方式找出满足条件的数据：");
        heros.
                stream()
                .filter(h->h.hp>100&&h.damage<50)
                .forEach(h->System.out.println(h.name));
    }

}
