package lambda;

/*  Author: 北辰
    日期: 11/01/2020
    功能: 首选准备10个Hero对象，hp和damage都是随机数。
分别用传统方式和聚合操作的方式，把hp第三高的英雄名称打印出来
}
 */

import character.MyHeroCompare;

import java.util.*;

public class Exercise_Lambda {
    public static void main(String[] args) {
        List<MyHeroCompare> heroList = new ArrayList<>();
        //拷贝一份副本
        List<MyHeroCompare> copyHeroList = heroList;
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            MyHeroCompare h = new MyHeroCompare("hero " + i,
                    r.nextInt(1000), r.nextInt(100));
            heroList.add(h);
        }
        System.out.println("初始化后的英雄集合为: ");
        System.out.println(heroList);
        System.out.println("使用传统方法查找hp第三高的英雄为: "
        +getHeroName(heroList,3,"hp"));
        //System.out.println(heroList);
        System.out.print("使用聚合操作找出hp第三高的英雄为: ");
        copyHeroList
                .stream()      //按照hp倒排序
                .sorted((h1,h2)->h1.hp>=h2.hp?-1:1)
                .skip(2)      //跳过前2个
                .limit(1)       //保留第一个(即原来的第三个)
                .forEach(h->System.out.println(h.getName()));
    }

    private static String getHeroName(List<MyHeroCompare> heros, int k,String property) {
        /**heros: 英雄集合类
         * k:     要查的第几高的英雄次序
         * property:  查询的属性
         */
        Comparator<MyHeroCompare> c = new Comparator<MyHeroCompare>() {
            @Override
            public int compare(MyHeroCompare h1, MyHeroCompare h2) {
                if(property.equals("hp")){      //按照hp进行排序
                    if(h1.getHp()>=h2.getHp()){ //hp大的排在前面
                        return -1;
                    }else
                        return 1;
                }else{          //按照damage进行排序
                    if(h1.getDamage()>=h2.getDamage()){ //damage大的排在前面
                        return -1;
                    }else
                        return 1;
                }
            }
        };
        //对集合进行排序
        Collections.sort(heros,c);      //按照属性property从大到小排序
        //找出property第k高的英雄的名字
        return heros.get(k-1).getName();
    }
}
