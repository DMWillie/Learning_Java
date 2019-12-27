package collection;

/*  Author: 北辰
    日期: 26/12/2019
    功能: HashSet： 无序
         LinkedHashSet： 按照插入顺序
         TreeSet： 从小到大排序
 */

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class CompareSet {
    public static void main(String[] args){
        HashSet<Integer> numberSet1 = new HashSet<>();
        //HashSet中的数据不是按照插入顺序存放
        numberSet1.add(32);
        numberSet1.add(88);
        numberSet1.add(888);
        numberSet1.add(8);
        System.out.println(numberSet1);

        LinkedHashSet<Integer> numberSet2 = new LinkedHashSet<>();
        //LinkedHashSet中的数据是按照插入顺序存放
        numberSet2.add(32);
        numberSet2.add(88);
        numberSet2.add(888);
        numberSet2.add(8);
        System.out.println(numberSet2);

        TreeSet<Integer> numberSet3 = new TreeSet<>();
        //TreeSet 中的数据是进行了排序的
        numberSet3.add(32);
        numberSet3.add(88);
        numberSet3.add(888);
        numberSet3.add(8);
        System.out.println(numberSet3);
    }
}
