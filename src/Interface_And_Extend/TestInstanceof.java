package Interface_And_Extend;

/*  Author: 北辰
    日期: 13/10/2019
    功能: 测试instanceof关键字的作用,即判断一个引用所指向的对象是否是指定类型或者其子类的实例
 */


public class TestInstanceof {
    public static void main(String[] args){
        ADHero ad = new ADHero();
        APHero ap = new APHero();

        Hero h1= ad;
        Hero h2= ap;

        //判断引用h1指向的对象，是否是ADHero类型
        System.out.println(h1 instanceof ADHero);

        //判断引用h2指向的对象，是否是APHero类型
        System.out.println(h2 instanceof APHero);

        //判断引用h1指向的对象，是否是Hero的子类型
        System.out.println(h1 instanceof Hero);
    }
}
