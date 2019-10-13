package Class_Demo;

/*
    Author: 北辰
    日期: 07/10/2019
    功能: 武器类是物品类的派生类,除了名称和价格外,还有攻击力这个属性
 */

public class Weapon extends Item{
    int damage; //攻击力

    public static void main(String[] args) {
        Weapon infinityEdge = new Weapon();
        infinityEdge.damage = 65; //damage属性在类Weapon中新设计的

        infinityEdge.name = "无尽之刃";//name属性，是从Item中继承来的，就不需要重复设计了
        infinityEdge.price = 3600;
    }
}