package Class_And_Object;

/*  Author: 北辰
    日期: 11/10/2019
    功能: 使用懒汉式单例模式
 */

public class GiantDragon_Lazy {
    //私有化构造方法使得该类无法在外部通过new进行实例化
    private GiantDragon_Lazy(){
    }
    //准备一个类属性,用于指向一个实例化对象,但是暂时指向null
    private static GiantDragon_Lazy instance;

    //public static方法,返回实例对象
    public static GiantDragon_Lazy getInstance(){
        //第一次访问的时候,发现instance没有指向任何对象,这时实例化一个对象
        if(null==instance){
            instance = new GiantDragon_Lazy();
        }
        //返回instance指向的对象
        return instance;
    }
}
