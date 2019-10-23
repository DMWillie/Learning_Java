package digit;

/*  Author: 北辰
    日期: 23/10/2019
    功能: 测试数字类的自动装箱
 */

public class TestAutoPack {
    public static void main(String[] args){
        int i = 5;
        //基本类型转换成封装类型
        Integer it = new Integer(i);
        //自动转换就叫装箱
        Integer it2 = i;
        System.out.println(it);
        System.out.println(it2);
        System.out.println(it==it2);
    }
}
