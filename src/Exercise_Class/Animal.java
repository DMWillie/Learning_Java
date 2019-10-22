package Exercise_Class;

/*  Author: 北辰
    日期: 22/10/2019
    功能: Animal类是所有动物的抽象父类
 */

public abstract class Animal {
    protected int legs;             //动物的腿的数目

    protected Animal(int legs){
        this.legs = legs;
    }

    //抽象方法
    public abstract void eat();

    public void walk(){
        System.out.println("动物如何行走,有"+legs+"条腿");
    }
}
