package Exercise_Class;

/*  Author: 北辰
    日期: 22/10/2019
    功能: 测试类
 */

public class Test {
    public static void main(String[] args){
        Spider s = new Spider();
        s.eat();
        System.out.println();
        Cat c = new Cat("黑猫警长");
        c.eat();
        c.play();
        c.walk();
        System.out.println();
        Fish f = new Fish();
        f.setName("鲨鱼");
        f.eat();
        f.play();
        f.walk();
    }
}
