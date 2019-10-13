package Interface_And_Extend;

/*  Author: 北辰
    日期: 13/10/2019
    功能: 测试接口向下转型为实现类
 */

public class TestDownwardTransitionToClass {
    public static void main(String[] args){
        ADHero ad = new ADHero();
        AD adi = ad;                //实现类向上转型为接口一定能成功

        ADHero adHero = (ADHero)adi;    //将接口向下转型为实现类要强制类型转换
                            //由于adi引用指向的是ADHero类型,所以转换一定能成功

        ADAPHero adapHero = (ADAPHero)adi;  //这里虽然编译器不会报错,但是强制类型转换不会成功
                            //因为adi实际指向ADHero类型,转换为ADAPHero类型不会成功
        adapHero.magicAttack();//抛出ClassCastException异常
    }
}
