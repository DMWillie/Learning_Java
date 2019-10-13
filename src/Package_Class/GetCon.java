package Package_Class;

/*
    Author: 北辰
    日期: 07/10/2019
    功能: 将Integer类的常量值输出
 */

public class GetCon {
    public static void main(String[] args){
        int maxint = Integer.MAX_VALUE;             //获取Integer类的常量值
        int minint = Integer.MIN_VALUE;
        int intsize = Integer.SIZE;
        System.out.println("int 类型可取的最大值是: "+maxint);
        System.out.println("int 类型可取的最小值是: "+minint);
        System.out.println("int 类型的二进制位数是: "+intsize);
    }
}
