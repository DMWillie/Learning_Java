package lambda;

/*  Author: 北辰
    日期: 06/01/2020
    功能: 要了解聚合操作，首先要建立Stream和管道的概念
Stream 和Collection结构化的数据不一样，Stream是一系列的元素，就像是生产线上的罐头一样，一串串的出来。
管道指的是一系列的聚合操作。
管道又分3个部分
管道源：   在这个例子里，源是一个List
中间操作： 每个中间操作，又会返回一个Stream，比如.filter()又返回一个Stream, 中间操作是“懒”操作，
         并不会真正进行遍历。
结束操作： 当这个操作执行后，流就被使用“光”了，无法再被操作。所以这必定是流的最后一个操作。
        结束操作不会返回Stream，但是会返回int、float、String、 Collection或者像forEach，什么都不返回,
        结束操作才进行真正的遍历行为，在遍历的时候，才会去进行中间操作的相关判断
 */

import character.MyHeroCompare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestAggregate {
    public static void main(String[] args) {
        Random r = new Random();
        List<MyHeroCompare> heros = new ArrayList<>();
        for(int i=0;i<5;i++){
            heros.add(new MyHeroCompare("hero "+i,
                    r.nextInt(1000),r.nextInt(100)));
        }
        //管道源是集合
        heros
                .stream()
                .forEach(h->System.out.println(h.name));
        System.out.println("-----------------------------");
        //管道源是数组
        MyHeroCompare hs[] = heros.toArray(new MyHeroCompare[heros.size()]);
        Arrays.stream(hs)
                .forEach(h->System.out.println(h.name));
        System.out.println("-----------------------------");
        //制造一个重复数据
        heros.add(heros.get(0));
        System.out.println("初始化集合后的数据 (最后一个数据重复)：");
        System.out.println(heros);
        /**中间操作*/
        System.out.println("-----------中间操作---------------");
        System.out.println("满足条件hp>100&&damage<50的数据");
        heros
                .stream()
                .filter(h->h.hp>100&&h.damage<50)
                .forEach(h->System.out.print(h));
        System.out.println("去除重复的数据，去除标准是看equals");
        heros
                .stream()
                .distinct()
                .forEach(h->System.out.print(h));
        System.out.println("按照血量排序");
        heros
                .stream()
                .sorted((h1,h2)->h1.hp>=h2.hp?1:-1)
                .forEach(h->System.out.print(h));
        System.out.println("保留3个");
        heros
                .stream()
                .limit(3)
                .forEach(h->System.out.print(h));
        System.out.println("忽略前3个");
        heros
                .stream()
                .skip(3)
                .forEach(h->System.out.print(h));
        System.out.println("转换为double的Stream");
        heros
                .stream()
                .mapToDouble(MyHeroCompare::getHp)
                .forEach(h->System.out.println(h));
        System.out.println("转换任意类型的Stream");
        heros
                .stream()
                .map((h)->h.name+"-"+h.hp+"-"+h.damage)
                .forEach(h->System.out.println(h));
    }
}
