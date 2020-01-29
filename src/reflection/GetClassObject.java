package reflection;

/*  Author: 北辰
    日期: 29/01/2020
    功能: 获取类对象有3种方式
1. Class.forName
2. Hero.class
3. new Hero().getClass()
在一个JVM中，一种类，只会有一个类对象存在。所以以上三种方式取出来的类对象，都是一样的。
注： 准确的讲是一个ClassLoader下，一种类，只会有一个类对象存在。通常一个JVM下，只会有一个ClassLoader
 */

import character.Hero;

public class GetClassObject {
    public static void main(String[] args) {
        String className = "character.Hero";
        try{
            Class pClass1 = Class.forName(className);
            Class pClass2 = Hero.class;
            Class pClass3 = new Hero().getClass();
            System.out.println(pClass1==pClass2);
            System.out.println(pClass1==pClass3);
            System.out.println(pClass1);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
