package Interface_And_Extend;

/*  Author: 北辰
    日期: 13/10/2019
    功能: 测试多态的效果,即都是同一个类型，调用同一个方法，却能呈现不同的状态
 */

public class TestPolymorphism {
    /*类的多态的实现条件:
    1.父类(接口)引用指向子类对象
    2.调用的方法要重写
     */
    public static void main(String[] args){
        Item i1 = new LifePotion();
        Item i2 = new MagicPotion();
        if(i1 instanceof Item) {
            System.out.print("i1 是Item类型,执行effect打印： ");
            i1.effect();
        }
        System.out.println();
        if(i2 instanceof Item){
            System.out.print("i2也是Item类型,执行effect打印： ");
            i2.effect();
        }
    }
}
