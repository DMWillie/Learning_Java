package collection;

/*  Author: 北辰
    日期: 01/12/2019
    功能: 采用三种方式对ArrayList进行遍历
 */

import character.Hero;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class TestTraverse {
    public static void main(String[] args){
        List<Hero> heros = new ArrayList<>();
        //放5个hero进入容器
        for(int i=0;i<5;i++){
            heros.add(new Hero("hero name "+i));
        }
        /**第一种遍历 for循环*/
        System.out.println("----------for循环------------");
        for(int i=0;i<heros.size();i++){
            Hero h = heros.get(i);
            System.out.println(h);
        }
        /**第二种遍历 使用迭代器*/
        System.out.println("---------使用while的iterator----------");
        Iterator<Hero> it = heros.iterator();
        //从最开始的位置判断"下一个"位置是否有数据
        //如果有就通过next取出来，并且把指针向下移动
        //直到"下一个"位置没有数据
        while(it.hasNext()){
            Hero h = it.next();
            System.out.println(h);
        }
        //迭代器的for写法
        System.out.println("----------使用for的iterator----------");
        for(Iterator<Hero> iterator=heros.iterator();iterator.hasNext();){
            Hero hero = iterator.next();
            System.out.println(hero);
        }
        /**第三种,增强型for循环
         * 不过增强型for循环也有不足：
         * 无法用来进行ArrayList的初始化
         * 无法得知当前是第几个元素了，当需要只打印单数元素的时候，就做不到了。 必须再自定下标变量。
         */
        System.out.println("----------增强型for循环------------");
        for(Hero h:heros){
            System.out.println(h);
        }
    }
}
