package digitAndstring;

/*  Author: 北辰
    日期: 23/10/2019
    功能: 测试数字类的自动拆箱
 */

public class TestAutoUnPack {
    public static void main(String[] args){
        int i = 5;
        Integer it = new Integer(i);
        //封装数据类型转换为基本数据类型
        int i2 = it.intValue();
        //自动转换就叫拆箱
        int i3 = it;
        System.out.println(i2);
        System.out.println(it==i);
        System.out.println(i3==i2);
    }
}
