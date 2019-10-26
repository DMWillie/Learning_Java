package digitAndstring;

/*  Author: 北辰
    日期: 25/10/2019
    功能: 通过Scanner从控制台读取字符串，然后把字符串转换为字符数组;
         转换为字符数组后，筛选出控制台读取到的字符串中的大写字母和数字，并打印出来
 */

import java.util.Scanner;

public class Exercise_Char {
    public static void main(String[] args){
        System.out.println("请输入至少一个字符以上");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        char[] arr = str.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(Character.isUpperCase(arr[i])){
                System.out.print(arr[i]+" ");
            }
            if(Character.isDigit(arr[i])){
                System.out.print(arr[i]+" ");
            }
        }
    }
}
