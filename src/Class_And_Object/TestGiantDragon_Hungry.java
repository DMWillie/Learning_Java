package Class_And_Object;

/*
    Author: 北辰
    日期: 10/10/2019
    功能: 测试饿汉式单例模式
 */

public class TestGiantDragon_Hungry {
    public static void main(String[] args){
        //通过new实例化会报错
        //GiantDragon g = new GiantDragon();
        //只能通过getInstance得到对象
        GiantDragon_Hungry g1 = GiantDragon_Hungry.getInstance();
        GiantDragon_Hungry g2 = GiantDragon_Hungry.getInstance();
        GiantDragon_Hungry g3 = GiantDragon_Hungry.getInstance();
        //都是同一个对象
        System.out.println(g1==g2);
        System.out.println(g1==g3);
    }
}
