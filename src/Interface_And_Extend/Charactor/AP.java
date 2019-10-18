package Interface_And_Extend.Charactor;

/*  Author: 北辰
    日期: 18/10/2019
    功能: AP接口,具有抽象方法magicAttack(),以及public-静态-final属性
 */

public interface AP {
    public static final int resistPhysic = 100;
    //resistMagic即便没有显式的声明为 public static final
    //但依然默认为public static final
    int resistMagic = 0;

    public void magicAttack();
}
