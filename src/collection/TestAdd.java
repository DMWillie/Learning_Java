package collection;

/*  Author: 北辰
    日期: 24/11/2019
    功能: 测试集合类ArrayList的add方法
 */

import character.Hero;

import java.util.ArrayList;

public class TestAdd {
    public static void main(String[] args){
        ArrayList heros = new ArrayList();
        //把5个对象加入到ArrayList中
        for(int i=0;i<5;i++){
            heros.add(new Hero("hero "+i));
        }
        System.out.println(heros);
        //在指定位置增加对象
        Hero specialHero = new Hero("Special Hero");
        heros.add(3,specialHero);       //在第3个位置(索引)增加
        System.out.println(heros);
    }
}
