package Package_Class;

/*
    Author: 北辰
    日期: 07/10/2019
    功能: 利用Integer包装类将字符变量以二进制,十六进制和八进制形式输出
 */

public class Charac {
    public static void main(String[] args){
        String str1 = Integer.toString(456);                 //获取数组的十进制表示
        String str2 = Integer.toBinaryString(456);                 //获取数组的二进制表示
        String str3 = Integer.toHexString(456);                 //获取数组的十六进制表示
        String str4 = Integer.toOctalString(456);                 //获取数组的八进制表示
        System.out.println("'456'的十进制表示为: "+str1);
        System.out.println("'456'的二进制表示为: "+str2);
        System.out.println("'456'的十六进制表示为: "+str3);
        System.out.println("'456'的八进制表示为: "+str4);
    }
}
