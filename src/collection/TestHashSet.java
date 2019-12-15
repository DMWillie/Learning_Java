package collection;

/*  Author: 北辰
    日期: 15/12/2019
    功能: 测试HashSet的一些用法
 */

import java.util.HashSet;
import java.util.Iterator;

public class TestHashSet {
    public static void main(String[] args){
        HashSet<String> names = new HashSet<>();
        /**Set中的元素不能重复*/
        names.add("gareen");
        System.out.println(names);
        //第二次插入同样的数据，是插不进去的，容器中只会保留一个
        names.add("gareen");
        System.out.println(names);
        /**Set中的元素没有按照插入顺序排序*/
        HashSet<Integer> numbers = new HashSet<Integer>();
        numbers.add(9);
        numbers.add(5);
        numbers.add(1);
        //Set中元素顺序不是按照插入顺序
        System.out.println(numbers);
        /**Set不提供get()来获取指定位置的元素
         所以遍历需要用到迭代器，或者增强型for循环*/
        numbers.clear();        //首先清空之前的元素
        for(int i=0;i<20;i++){
            numbers.add(i);
        }
        //Set不提供get方法来获取指定位置的元素
        //numbers.get(0);
        //遍历Set可以采用迭代器iterator
        System.out.println("---------使用iterator遍历Set----------");
        for(Iterator<Integer> iterator=numbers.iterator();iterator.hasNext();){
            Integer i = (Integer)iterator.next();
            System.out.println(i);
        }
        //或者采用增强型for循环
        System.out.println("---------使用增强型for循环遍历Set----------");
        for(Integer i:numbers){
            System.out.println(i);
        }
    }
}
