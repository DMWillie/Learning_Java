package collection;

/*  Author: 北辰
    日期: 22/12/2019
    功能: 生成50个 0-9999之间的随机数，要求不能有重复的
 */

import java.util.HashSet;

public class Exercise_NoDuplicateRandom {
    public static void main(String[] args){
        int n=50,t1=0,t2=9999;
        System.out.printf("生成%d个 %d-%d之间的无重复随机数为:%n",n,t1,t2);
        HashSet<Integer> list = getNoDuplicateRandom(n,t1,t2);
        System.out.println(list);
    }

    public static HashSet<Integer> getNoDuplicateRandom(int n,int t1,int t2){
        //生成n个不重复的t1-t2之间的随机数
        HashSet<Integer> set = new HashSet<Integer>();
        while(true){
            if(set.size()==n)       //当集合set的大小为n时退出循环啊
                break;
            int k = (int)(Math.random()*(t2-t1)+t1);
            set.add(k);
        }
        return set;
    }
}
