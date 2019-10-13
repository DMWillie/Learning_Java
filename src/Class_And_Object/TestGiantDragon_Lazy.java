package Class_And_Object;

/*  Author: 北辰
    日期: 11/10/2019
    功能: 测试懒汉式单例模式
 */

public class TestGiantDragon_Lazy {
    public static void main(String[] args) {
        //通过new实例化会报错
        //GiantDragon_Lazy g = new GiantDragon_Lazy();

        //只能通过getInstance得到对象

        GiantDragon_Lazy g1 = GiantDragon_Lazy.getInstance();
        GiantDragon_Lazy g2 = GiantDragon_Lazy.getInstance();
        GiantDragon_Lazy g3 = GiantDragon_Lazy.getInstance();

        //都是同一个对象
        System.out.println(g1==g2);
        System.out.println(g1==g3);
    }
}
