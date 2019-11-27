package collection;

/*  Author: 北辰
    日期: 27/11/2019
    功能: 测试集合类ArrayList的get方法，获取指定位置的对象
 */

import character.Hero;

import java.util.ArrayList;

public class TestGet {
    public static void main(String[] args){
        ArrayList heros = new ArrayList();
        //初始化5个对象
        for(int i=0;i<5;i++){
            heros.add(new Hero("hero "+i));
        }
        Hero specialHero = new Hero("special hero");
        heros.add(specialHero);
        //获取指定位置的对象
        System.out.println(heros.get(5));
        //如果超过了范围,依然会报错
        System.out.println(heros.get(6));

    }
}
