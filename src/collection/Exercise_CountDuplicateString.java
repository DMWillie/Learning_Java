package collection;

/*  Author: 北辰
    日期: 15/12/2019
    功能: 创建一个长度是100的字符串数组
         使用长度是2的随机字符填充该字符串数组
         统计这个字符串数组里重复的字符串有多少种
         使用HashSet来解决这个问题
 */

import digitAndstring.Exercise_RandomString;
import digitAndstring.CountDuplicateString;

import java.util.HashSet;
import java.util.Scanner;

public class Exercise_CountDuplicateString {
    private static Exercise_RandomString e1 = new Exercise_RandomString();
    private static CountDuplicateString c1 = new CountDuplicateString();

    public static void main(String[] args){
        Exercise_CountDuplicateString e = new Exercise_CountDuplicateString();
        Scanner input = new Scanner(System.in);
        System.out.print("请输入字符串数组的长度n:");
        int n = input.nextInt();
        System.out.print("请输入每个字符串的长度length:");
        int length = input.nextInt();
        String[] arr = new String[n];       //初始化长度为n的字符串数组
        for(int i=0;i<n;i++){
            arr[i] = e1.getRandomString_2(length); //每个元素为随机生成的指定长度的字符串
        }
        System.out.print("生成的随机字符串数组如下: ");
        c1.printStringArray(arr);
        HashSet<String> result = e.countDuplicateString(arr);
        System.out.println();
        System.out.println("-------使用HashSet方法--------");
        System.out.printf("总共有%d种重复的字符串%n分别是:%n",result.size());
        System.out.println(result);
        System.out.println("--------使用其他方法--------");
        int[] index = new int[n];       //记录重复单词的下标
        System.out.printf("总共有%d种重复的字符串\n分别是:\n",c1.countDuplicateString_2(arr,index));
        for(int i=0;i<index.length;i++){
            if(index[i]>=1){
                System.out.print(arr[i]+"\t");
            }
        }
    }

    //使用HashSet统计字符串数组中重复的字符串并打印出来
    public HashSet<String> countDuplicateString(String[] arr){
        HashSet<String> set = new HashSet<>();
        HashSet<String> result = new HashSet<>();   //存放重复的字符串
        for(String str:arr){
            if(set.contains(str)){      //如果set中已经存在该字符串
                result.add(str);        //将重复的字符串添加到结果集合中
            }else{      //只出现一次的字符串
                set.add(str);       //存放到遍历添加的集合
            }
        }
        return result;
    }
}
