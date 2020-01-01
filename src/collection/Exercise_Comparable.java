package collection;

/*  Author: 北辰
    日期: 01/01/2020
    功能: 借助Comparable接口，使Item具备按照价格从高到低排序。
初始化10个Item,并且用Collections.sort进行排序，查看排序结果
 */

import property.Item;

import java.util.ArrayList;
import java.util.Collections;

public class Exercise_Comparable {
    public static void main(String[] args){
        ArrayList<Item> items = new ArrayList<>();
        //初始化items
        for(int i=0;i<10;i++){
            items.add(new Item("item "+i));
            items.get(i).price =(int)(Math.random()*100+1);
        }
        System.out.println("初始化之后的items为: ");
        System.out.println(items);

        System.out.println();
        //对items按照价格从高到底排序
        Collections.sort(items);
        System.out.println("按照价格从高到低排序的items为: ");
        System.out.println(items);
    }
}
