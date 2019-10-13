package Package_Class;

/*
    Author: 北辰
    日期: 07/10/2019
    功能: 利用Integer包装类将String类型数组中的元素转换成int型
 */

public class Summation {
    public static void main(String[] args){
        String str[] = {"89","12","10","18","35"};          //定义String数组
        int sum = 0;
        for(int i=0;i<str.length;i++){
            int myint = Integer.parseInt(str[i]);       //将数组中的每个元素都转换为int型
            sum += myint;
        }
        System.out.println("数组中的各元素之和是: "+sum);
    }
}
