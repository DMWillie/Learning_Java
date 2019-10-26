package digitAndstring;

/*  Author: 北辰
    日期: 23/10/2019
    功能: 调用Integer的静态方法parseInt
 */

public class StringToNumber {
    public static void main(String[] args){
        String str = "999";
        int i = Integer.parseInt(str);
        System.out.println(i);

        //String str1 = "3.1a4";
        //float f = Float.parseFloat(str1);
        //System.out.println(f);  会报错
    }
}
