package reflection;

/*  Author: 北辰
    日期: 29/01/2020
    功能: 反射中的英雄类
    为Hero增加一个静态属性,并且在静态初始化块里进行初始化
 */

public class Hero {
    public String name;
    public float hp;
    public int damage;
    public int id;
    //静态属性
    static String copyright;
    //静态初始化块
    static{
        System.out.println("初始化 copyright");
        copyright = "版权由Riot Games公司所有";
    }
}
