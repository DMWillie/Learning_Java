package Class_And_Object;

/*
    Author: 北辰
    日期: 10/10/2019
    功能: 使用饿汉式单例模式
 */

public class GiantDragon_Hungry {
    //私有化构造方法使得该类无法在外部通过new 进行实例化
    private GiantDragon_Hungry(){
    }
    //准备一个类属性,指向一个实例化对象。因为是类属性，所以只有一个
    private static GiantDragon_Hungry instance = new GiantDragon_Hungry();
    //public static 方法，提供给调用者获取14行定义的对象
    public static GiantDragon_Hungry getInstance(){
        return instance;
    }
}
