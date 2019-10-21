package Interface_And_Extend.Charactor;

/*  Author: 北辰
    日期: 21/10/2019
    功能: 为AD接口增加一个默认方法 attack()
        为AP接口也增加一个默认方法 attack()
        问： ADAPHero同时实现了AD,AP接口，那么 ADAPHero 对象调用attack()的时候，是调用哪个接口的attack()?
 */

public class Exercise_ADAPHero implements DefaultMethodAD,DefaultMethodAP {

    @Override
    public void attack(){
        System.out.println("既可以进行物理攻击，又可以进行魔法攻击");
    }

    public static void main(String[] args){
        Exercise_ADAPHero e = new Exercise_ADAPHero();
        //e.attack();   当AD和AP接口同时有默认同名方法时,不能直接调用该方法,会报错
        e.attack();
    }
}
