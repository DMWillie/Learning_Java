package Interface_And_Extend.Charactor;

/*  Author: 北辰
    日期: 21/10/2019
    功能: 为AP接口增加默认方法attack()
 */

public interface DefaultMethodAP {
    default public void attack(){
        System.out.println("进行魔法攻击");
    }
}
