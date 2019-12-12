package collection;

/*  Author: 北辰
    日期: 10/12/2019
    功能: 设计一个Hero二叉树，HeroNode.
可以向这个英雄二叉树插入不同的Hero对象，并且按照Hero的血量倒排序。
随机生成10个Hero对象，每个Hero对象都有不同的血量值，插入这个HeroNode后，把排序结果打印出来。
 */


import character.Hero;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HeroNode {
    //左子节点
    public HeroNode leftNode;
    //右子节点
    public HeroNode rightNode;
    //节点值
    public Object value;

    //插入数据(根据英雄血量的大小,小的插入到左边,大的插入到右边)
    public void add(Hero h){
        if(null==value)     //当前结点值为空
            value = h;
        else{       //当前节点不为空
            if(h.hp-((Hero)value).hp<=0){   //插入到最左边
                if(leftNode==null)      //左子节点为空
                    leftNode = new HeroNode();
                leftNode.add(h);
            }else{          //插入到最右边
                if(rightNode==null)     //右子节点为空
                    rightNode = new HeroNode();
                rightNode.add(h);
            }
        }
    }
    //按照RVL的顺序遍历(这样就是从大到小的顺序)
    public List<Hero> values(){
        List<Hero> values = new ArrayList<>();
        //if(rightNode.value!=null)       //遍历右子树
        if(rightNode!=null)       //遍历右子树
            values.addAll(rightNode.values());
        values.add((Hero)value);      //添加当前节点
        //if(leftNode.value!=null)        //遍历左子树
        if(leftNode!=null)        //遍历左子树
            values.addAll(leftNode.values());
        return values;
    }

    //输出英雄数组
    public static void printHeroArrays(List<Hero> values){
        List<String> arr = new ArrayList<>();
        Iterator<Hero> it = values.iterator();  //迭代器
        while(it.hasNext()){        //遍历
            Hero h = it.next();
            arr.add("[name:hero "+h.num+" hp:"+h.hp+"]");
        }
        //格式化输出
        for(int i=0;i<arr.size();i++){
            if(i==0){
                System.out.println("["+arr.get(i));
            }else{
                System.out.println(", "+arr.get(i));
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args){
        //定义一个具有10个对象的英雄数组
        Hero[] heros = new Hero[10];
        List<Hero> ls = new ArrayList<>();
        //初始化每个英雄的编号和血量(随机)
        for(int i=0;i< heros.length;i++){
            heros[i] = new Hero();  //初始化对象
            heros[i].num = i;
            heros[i].hp = (int)(Math.random()*1000+1);  //每个英雄的血量随机
            ls.add(heros[i]);
        }
        System.out.println("初始化10个Hero");
        printHeroArrays(ls);
        HeroNode root = new HeroNode();
        for(Hero h:heros){      //插入对象
            root.add(h);
        }
        //后序遍历对象二叉树,输出从大到小排列的数组
        System.out.println("根据血量倒排序后的Hero");
        printHeroArrays(root.values());
    }
}
