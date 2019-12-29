package collection;

/*  Author: 北辰
    日期: 29/12/2019
    功能: 使Hero类实现Comparable接口
在类里面提供比较算法
Collections.sort就有足够的信息进行排序了，也无需额外提供比较器Comparator
注： 如果返回-1, 就表示当前的更小，否则就是更大
 */

import character.MyHeroCompare;

import java.util.*;

public class TestComparable {
    public static void main(String[] args){
        Random r = new Random();
        List<MyHeroCompare> heros = new ArrayList<MyHeroCompare>();
        for(int i=0;i<10;i++){
            //通过随机值实例化hero的hp和damage
            heros.add(new MyHeroCompare("hero "+i,
                    r.nextInt(100),r.nextInt(100)));
        }
        System.out.println("初始化后的集合: ");
        System.out.println(heros);
        //MyHeroCompare类实现了接口Comparable，即自带比较信息。
        //Collections直接进行排序，无需额外的Comparator
        Collections.sort(heros);
        System.out.println("按照伤害高低排序后的集合: ");
        System.out.println(heros);
    }
}
