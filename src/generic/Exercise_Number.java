package generic;

/*  Author: 北辰
    日期: 01/01/2020
    功能: 根据数字类的知识，设计一个集合，这个集合里即可以放整数，也可以放浮点数，但是不能放字符串
 */

import java.util.ArrayList;

public class Exercise_Number {
    public static void main(String[] args){
        //设定集合的类型为Number即可
        ArrayList<Number> num = new ArrayList<>();
        int i = 31;
        float f = 3.1f;
        double d = 3.14;
        short s = 41;
        byte b = 8;
        String str = "31";
        //num集合除了str之外，都能添加
        num.add(i);
        num.add(f);
        num.add(d);
        num.add(s);
        num.add(b);
        //num.add(str);
        System.out.println("加入各种类型的数字之后的num集合为: ");
        System.out.println(num);
    }
}
