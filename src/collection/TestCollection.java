package collection;

/*  Author: 北辰
    日期: 24/11/2019
    功能: 使用数组会有局限性,为了解决数组的局限性，引入容器类的概念。 最常见的容器类就是
    ArrayList
    容器的容量"capacity"会随着对象的增加，自动增长
    只需要不断往容器里增加英雄即可，不用担心会出现数组的边界问题
 */

import character.Hero;

import java.util.ArrayList;

public class TestCollection {
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        /**数组的局限性
         * Hero heros[] = new Hero[10];
         * //声明长度是10的数组
         * //不用的数组就浪费了
         * //超过10的个数，又放不下
         * heros[0] = new Hero("盖伦");
         * heros[20] = new Hero("提莫");
         */
        //容器类ArrayList,用于存放对象
        ArrayList heros = new ArrayList();
        heros.add(new Hero("盖伦"));
        System.out.println(heros.size());
        //容器的容量"capacity"会随着对象的增加，自动增长
        //只需要不断往容器里增加英雄即可，不用担心会出现数组的边界问题。
        heros.add(new Hero("提莫"));
        System.out.println(heros.size());
    }
}
