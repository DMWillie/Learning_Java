package Interface_And_Extend.Charactor;

/*  Author: 北辰
    日期: 21/10/2019
    功能: 接口方法也可以有实现体,并用default修饰(JDK8新特性)
 */

public interface DefaultMethodMortal {
    public void die();
    //默认方法
    default public void revive(){
        System.out.println("本英雄复活了");
    }
}

/** 为什么要有默认方法?
 * 假设没有默认方法这种机制，那么如果要为Mortal增加一个新的方法revive,那么所有实现了Mortal接口的类，都需要做改动。
 * 但是引入了默认方法后，原来的类，不需要做任何改动，并且还能得到这个默认方法
 * 通过这种手段，就能够很好的扩展新的类，并且做到不影响原来的类
 */
