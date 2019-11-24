package Class_Demo;
/*
    Author: 北辰
    日期: 07/10/2019
    修改日期: 24/11/2019,实现Serializable接口
    功能: 设计一个英雄类
 */


import java.io.Serializable;

public class Hero implements Serializable {
    //表示这个类当前的版本,如果有了变化,比如新设计了属性,就应该修改这个版本号
    private static final long serialVersionUID = 1L;
    public String name; //姓名
    public float hp; //血量
    float armor; //护甲
    int moveSpeed; //移动速度

    public static void main(String[] args) {
        //创建一个对象
        new Hero();
        //使用一个引用来指向这个对象
        Hero h1 = new Hero();
        Hero h2 = new Hero();
        Hero h3;
        h3 = h1;
        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h3);
        //h3和h1指向同一个对象,和h2指向的对象不同,因此打印的结果h1和h3相同,而和h2不同

        //创建两个英雄,并设置它们的属性
        Hero garen =  new Hero();
        garen.name = "盖伦";
        garen.hp = 616.28f;
        garen.armor = 27.536f;
        garen.moveSpeed = 350;

        Hero teemo =  new Hero();
        teemo.name = "提莫";
        teemo.hp = 383f;
        teemo.armor = 14f;
        teemo.moveSpeed = 330;
    }
}
