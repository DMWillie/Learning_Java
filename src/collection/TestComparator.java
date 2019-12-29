package collection;

/*  Author: 北辰
    日期: 29/12/2019
    功能: 假设MyHero有三个属性 name,hp,damage
一个集合中放存放10个MyHero,通过Collections.sort对这10个进行排序
那么到底是hp小的放前面？还是damage小的放前面？Collections.sort也无法确定
所以要指定到底按照哪种属性进行排序
这里就需要提供一个Comparator给定如何进行两个对象之间的大小比较
 */

import character.MyHero;

import java.util.*;

public class TestComparator {
    public static void main(String[] args){
        Random r = new Random();
        List<MyHero> heros = new ArrayList<MyHero>();
        for(int i=0;i<10;i++){
            //通过随机值实例化hero的hp和damage
            heros.add(new MyHero("hero "+i,r.nextInt(100),r.nextInt(100)));
        }
        System.out.println("初始化后的集合: ");
        System.out.println(heros);
        //直接调用sort会出现编译错误，因为Hero有各种属性
        //到底按照哪种属性进行比较，Collections也不知道，不确定，所以没法排
        //Collections.sort(heros);

        //引入Comparator，指定比较的算法
        Comparator<MyHero> c = new Comparator<MyHero>() {
            @Override
            public int compare(MyHero h1, MyHero h2) {
                //按照hp进行排序
                if(h1.hp>=h2.hp)
                    return 1;       //正数表示h1比h2要大
                else
                    return -1;
            }
        };
        Collections.sort(heros,c);
        System.out.println("按照血量排序后的集合: ");
        System.out.println(heros);
    }
}
