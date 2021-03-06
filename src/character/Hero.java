package character;

/*  Author: 北辰
    日期: 24/11/2019
    修改日期: 12/12/2019,每个英雄新增一个序号的属性
    功能: 重写toString()方法的Hero类
 */

public class Hero {
    public String name;
    public float hp;
    public int num;         //英雄的序号
    public int damage;

    public Hero(){
    }
    //增加一个初始化name的构造方法
    public Hero(String name){
        this.name = name;
    }
    //重写toString()方法
    public String toString(){
        return name;
    }
}
