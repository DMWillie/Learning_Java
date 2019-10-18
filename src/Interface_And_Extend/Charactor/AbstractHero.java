package Interface_And_Extend.Charactor;

/*  Author: 北辰
    日期: 18/10/2019
    功能: 抽象类AbstractHero,有一个抽象方法attack()
 */

public abstract class AbstractHero {
    String name;
    float hp;
    float armor;
    int moveSpeed;

    public static void main(String[] args){

    }
    //抽象方法attack
    //Abstract的子类会被要求实现attack()方法
    public abstract void attack();
}
