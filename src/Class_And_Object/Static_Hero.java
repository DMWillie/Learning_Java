package Class_And_Object;

/*
    Author: 北辰
    日期: 10/10/2019
    功能: 测试初始化属性的顺序
 */

public class Static_Hero {
    public String name = "some hero";

    public Static_Hero(){
        name = "one hero";
    }
    {               //初始化代码块
        name = "other hero";
    }

    public static void main(String[] args){
        Static_Hero hero = new Static_Hero();
        System.out.println(hero.name);          //打印one hero
        /*由此可以看出,初始化属性时的顺序为:
        1.类属性初始化
        2.静态代码块
        3.代码块
        4.构造方法
         */
    }
}