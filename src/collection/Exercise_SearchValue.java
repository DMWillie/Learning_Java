package collection;

/*  Author: 北辰
    日期: 14/12/2019
    修改日期: 29/12/2019 (加入自定义MyHashMap比较)
    功能: 准备一个ArrayList其中存放3000000(三百万个)Hero对象，其名称是随机的,格式是hero-[4位随机数]
hero-3229
hero-6232
hero-9365
...
因为总数很大，所以几乎每种都有重复，把名字叫做 hero-5555的所有对象找出来
要求使用两种办法来寻找
1. 不使用HashMap，直接使用for循环找出来，并统计花费的时间
2. 借助HashMap，找出结果，并统计花费的时间
 */

import character.Hero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Exercise_SearchValue {
    public static void main(String[] args){
        ArrayList<Hero> list = new ArrayList<>();
        //初始化三百万个英雄
        for(int i=0;i<3000000;i++){
            Hero h = new Hero();
            //随机生成四位整数
            int random = (int)(Math.random()*8999+1000);
            h.num = i;
            h.name = "hero-"+random;
            list.add(h);
        }
        //查找名字为hero-5555的对象并打印出来
        System.out.println("------------使用for查找--------");
        searchHeroName1(list,"hero-5555");
        System.out.println("------------使用HashMap查找------------");
        searchHeroName2(list,"hero-5555");
        System.out.println("------------使用自定义HashMap查找--------------");
        searchHeroName3(list,"hero-5555");
    }
    //方法一，使用for循环查找指定名字的对象并打印出来
    public static void searchHeroName1(ArrayList<Hero> list,String name){
        long start = System.currentTimeMillis();
        int count = 0;
        System.out.print("[");
        for(int i=0;i<list.size();i++){
            if(list.get(i).name.equals(name)){
                if(count==0){
                    System.out.print("hero:"+list.get(i).num);
                }
                else if(count%10==0){
                    System.out.println();
                    System.out.print("hero:"+list.get(i).num);
                }else{
                    System.out.print(","+"hero:"+list.get(i).num);
                }
                count++;
            }
        }
        System.out.println("]");
        long end = System.currentTimeMillis();
        System.out.printf("总共找到%d个名字为:%s的英雄对象,耗时%s毫秒%n",
                count,name,end-start);
    }
    //方法二***，使用HashMap查找指定名字的对象并打印出来
    public static void searchHeroName2(ArrayList<Hero> list,String name){
        /***
        HashMap<Hero,String> heroMap = new HashMap<>();
        //将ArrayList中的对象全部加入HashMap中
        for(Iterator<Hero> it = list.iterator();it.hasNext();){
            Hero h = it.next();
            heroMap.put(h,h.name);
        }
         */
        long t1 = System.currentTimeMillis();
        HashMap<String,ArrayList<Hero>> heroMap = new HashMap<>();
        for(Hero h:list){
            ArrayList<Hero> mark = heroMap.get(h.name);
            if(null==mark){     //如果对应name的集合不存在
                mark = new ArrayList<Hero>();   //首先创建这个集合
                heroMap.put(h.name,mark); //将对应键值对放入HashMap中
            }
            //存在对应的集合则把对应的英雄添加到集合中
            mark.add(h);
        }
        long t2 = System.currentTimeMillis();
        //开始从HashMap中寻找对应的英雄并打印出来
        long start = System.currentTimeMillis();
        //将指定name的结合找出来
        ArrayList<Hero> heroSearch = heroMap.get(name);
        int count = 0;
        //通过遍历打印英雄的编号
        System.out.print("[");
        for(Iterator<Hero> it = heroSearch.iterator();it.hasNext();){
            Hero hh = it.next();
            if(count==0){
                System.out.print("hero:"+hh.num);
            }
            else if(count%10==0){
                System.out.println();
                System.out.print("hero:"+hh.num);
            }else{
                System.out.print(","+"hero:"+hh.num);
            }
            count++;
        }
        System.out.println("]");
        long end = System.currentTimeMillis();
        System.out.printf("创建HashMap耗时%s毫秒%n",t2-t1);
        System.out.printf("总共找到%d个名字为:%s的英雄对象,耗时%s毫秒%n",
                count,name,end-start);
    }
    //方法三,使用自定义MyHashMap寻找
    public static void searchHeroName3(ArrayList<Hero> list,String name){
        //创建MyHashMap
        long t1 = System.currentTimeMillis();
        MyHashMap heroMap = new MyHashMap();
        for(Hero h:list){
            ArrayList<Hero> l = (ArrayList<Hero>)heroMap.get(h.name);
            if(l==null){  //heroMap不存在对应的集合,即键"h.name"不存在
                l = new ArrayList<Hero>();  //创建一个Hero类型的集合
                heroMap.put(h.name,l);
            }
            //存在对应的集合则把对应的英雄添加到集合中
            l.add(h);
        }
        long t2 = System.currentTimeMillis();
        //开始从HashMap中寻找对应的英雄并打印出来
        long start = System.currentTimeMillis();
        //将指定name的结合找出来
        ArrayList<Hero> heroSearch = (ArrayList<Hero>) heroMap.get(name);
        int count = 0;
        //通过遍历打印英雄的编号
        System.out.print("[");
        for(Iterator<Hero> it = heroSearch.iterator();it.hasNext();){
            Hero hh = it.next();
            if(count==0){
                System.out.print("hero:"+hh.num);
            }
            else if(count%10==0){
                System.out.println();
                System.out.print("hero:"+hh.num);
            }else{
                System.out.print(","+"hero:"+hh.num);
            }
            count++;
        }
        System.out.println("]");
        long end = System.currentTimeMillis();
        System.out.printf("创建MyHashMap耗时%s毫秒%n",t2-t1);
        System.out.printf("总共找到%d个名字为:%s的英雄对象,耗时%s毫秒%n",
                count,name,end-start);
    }
}
