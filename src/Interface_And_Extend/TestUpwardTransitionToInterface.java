package Interface_And_Extend;

/*  Author: 北辰
    日期: 13/10/2019
    功能: 测试向上转型为接口
 */

public class TestUpwardTransitionToInterface {
    public static void main(String[] args){
        ADHero ad = new ADHero();           //创建一个物理攻击英雄对象
        AD adi = ad;            //将一个ADHero类型转换为AD接口
    }
}