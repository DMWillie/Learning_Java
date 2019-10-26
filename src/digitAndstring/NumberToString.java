package digitAndstring;

/*  Author: 北辰
    日期: 23/10/2019
    功能: 数字转换为字符串有两种方式:①使用String类的静态方法valueOf
                               ②先把基本类型装箱为对象，然后调用对象的toString
 */

public class NumberToString {
    public static void main(String[] args){
        int i = 5;
        String str1 = String.valueOf(i);
        Integer it = i;
        String str2 = it.toString();
        System.out.println(str1.equals(str2));
    }
}
