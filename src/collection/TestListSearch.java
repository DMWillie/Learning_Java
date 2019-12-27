package collection;

/*  Author: 北辰
    日期: 27/12/2019
    功能: 假设在List中存放着无重复名称，没有顺序的2000000个Hero
要把名字叫做“hero 1000000”的对象找出来
List的做法是对每一个进行挨个遍历，直到找到名字叫做“hero 1000000”的英雄。
最差的情况下，需要遍历和比较2000000次，才能找到对应的英雄。
测试逻辑：
1. 初始化2000000个对象到ArrayList中
2. 打乱容器中的数据顺序
3. 进行10次查询，统计每一次消耗的时间
不同计算机的配置情况下，所花的时间是有区别的
 */

import character.Hero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestListSearch {
    public static void main(String[] args){
        List<Hero> heros = new ArrayList<>();
        //初始化heros
        for(int i=0;i<2000000;i++){
            Hero h = new Hero("hero "+i);
            heros.add(h);
        }
        //进行10次查找，观察大体的平均值
        for(int i=0;i<10;i++){
            // 打乱heros中元素的顺序
            Collections.shuffle(heros);

            long start = System.currentTimeMillis();
            String target = "hero 1000000";
            for(Hero h:heros){
                if(h.name.equals(target)){
                    System.out.println("找到了 hero!" );
                    break;
                }
            }
            long end = System.currentTimeMillis();
            long elapsed = end - start;
            System.out.printf("第%d次查找,一共花了%d毫秒%n",i+1,elapsed);
        }
    }
}
