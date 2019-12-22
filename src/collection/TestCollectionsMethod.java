package collection;

/*  Author: 北辰
    日期: 22/12/2019
    功能: Collections是一个类，容器的工具类,就如同Arrays是数组的工具类。测试collection的各种方法
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollectionsMethod {
    public static void main(String[] args){
        //初始化集合numbers
        List<Integer> numbers = new ArrayList<>();
        for(int i=0;i<10;i++){
            numbers.add(i);
        }
        System.out.println("集合中的数据:");
        System.out.println(numbers);
        /**reverse 使List中的数据发生翻转*/
        Collections.reverse(numbers);
        System.out.println("翻转后集合中的数据:");
        System.out.println(numbers);
        /**shuffle 混淆List中数据的顺序*/
        Collections.shuffle(numbers);
        System.out.println("混淆后集合中的数据:");
        System.out.println(numbers);
        /**sort 对List中的数据进行排序*/
        Collections.sort(numbers);
        System.out.println("排序后集合中的数据:");
        System.out.println(numbers);
        /**swap 交换两个数据的位置*/
        Collections.swap(numbers,0,5);
        System.out.println("交换0和5下标的数据后，集合中的数据:");
        System.out.println(numbers);
        /**rotate 把List中的数据，向右滚动指定单位的长度*/
        Collections.rotate(numbers,2);
        System.out.println("把集合向右滚动2个单位，标的数据后，集合中的数据:");
        System.out.println(numbers);
        /**synchronizedList 把非线程安全的List转换为线程安全的List*/
        System.out.println("把非线程安全的List转换为线程安全的List");
        List<Integer> synchronizedNumbers = (List<Integer>) Collections.synchronizedList(numbers);
    }
}
