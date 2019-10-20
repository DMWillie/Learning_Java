package Interface_And_Extend.Charactor;

/*  Author: 北辰
    日期: 19/10/2019
    功能: 静态内部类用法:new 外部类.静态内部类(),比如敌方水晶，当敌方水晶没有血的时候，己方所有英雄都取得胜利，
    而不只是某一个具体的英雄取得胜利。与非静态内部类不同，静态内部类水晶类的实例化 不需要一个外部类的实例为基础，
    可以直接实例化.
    因为没有一个外部类的实例，所以在静态内部类里面不可以访问外部类的实例属性和方法
    除了可以访问外部类的私有静态成员外，静态内部类和普通类没什么大的区别
 */

public class StaticInnerHero {
    public String name;             //姓名
    protected float hp;             //英雄血量

    private static void battleWin(){
        System.out.println("battle Win");
    }
    //静态内部类,地方水晶
    static class EnemyCrystal{
        int hp = 5000;
        //如果地方水晶血量为0,则宣布胜利
        public void checkIfVictory(){
            if(hp<=0){
                battleWin();        //或StaticInnerHero.battleWin();
                //静态内部类不能直接访问外部类的实例属性(对象属性)
                //System.out.println(name+"win this game!");
            }else{
                System.out.println("敌方水晶还有"+hp+"滴血");
            }
        }
    }
    public static void main(String[] args){
        //实例化静态内部类
        StaticInnerHero.EnemyCrystal crystal = new StaticInnerHero.EnemyCrystal();
        crystal.checkIfVictory();
        crystal.hp -= 3000;
        crystal.checkIfVictory();
        crystal.hp -= 4000;
        crystal.checkIfVictory();
    }

}
