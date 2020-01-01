package collection;

/*  Author: 北辰
    日期: 01/01/2020
    功能: 默认情况下，TreeSet中的数据是从小到大排序的，不过TreeSet的构造方法支持传入一个Comparator
public TreeSet(Comparator comparator)
通过这个构造方法创建一个TreeSet，使得其中的的数字是倒排序的
 */

import java.util.Comparator;
import java.util.TreeSet;

public class CustomizeTreeSet {
    public static void main(String[] args){
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                if(n1<=n2)
                    return 1;
                else
                    return -1;
            }
        };
        TreeSet<Integer> t = new TreeSet<>(c); //支持自定义排序的TreeSet
        //往TreeSet集合中添加数据
        t.add(42);
        t.add(34);
        t.add(63);
        t.add(20);
        t.add(58);
        System.out.println("倒排序的TreeSet为: \n"+t);
    }

}
