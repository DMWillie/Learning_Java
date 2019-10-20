package Interface_And_Extend.Charactor;

/*  Author: 北辰
    日期: 20/10/2019
    功能: 本地类可以理解为有名字的匿名类
        内部类与匿名类不一样的是，内部类必须声明在成员的位置，即与属性和方法平等的位置。
        本地类和匿名类一样，直接声明在代码块里面，可以是主方法，for循环里等等地方
 */

public abstract class LocalHero {
    String name;            //姓名
    float hp;               //血量
    float armor;            //护甲
    int moveSpeed;          //移动速度

    public abstract void attack();

    public static void main(String[] args){
        //与匿名类的区别在于，本地类有了自定义的类名
        class SomeHero extends LocalHero{
            public void attack(){
                System.out.println(name+"使用新的进攻手段");
            }
        }
        SomeHero h = new SomeHero();
        h.name = "皮城女警";
        h.attack();
    }
}
