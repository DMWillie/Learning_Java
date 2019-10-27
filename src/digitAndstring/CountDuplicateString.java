package digitAndstring;

/*  Author: 北辰
    日期: 27/10/2019
    功能: 创建一个长度是100的字符串数组,使用长度是2的随机字符填充该字符串数组
         统计这个字符串数组里重复的字符串有多少种
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class CountDuplicateString {
    Map<String,Integer> map = new HashMap<>();
    public static void main(String[] args){
        Exercise_RandomString e = new Exercise_RandomString();
        CountDuplicateString solution = new CountDuplicateString();
        Scanner input = new Scanner(System.in);
        System.out.print("请输入字符串数组的长度n:");
        int n = input.nextInt();
        System.out.print("请输入每个字符串的长度length:");
        int length = input.nextInt();
        String[] arr = new String[n];       //初始化长度为n的字符串数组

        for(int i=0;i<n;i++){           //创建一个指定长度的随机字符串数组
            arr[i] = e.getRandomString_2(length);
        }
        System.out.print("生成的随机字符串数组如下: ");
        solution.printStringArray(arr);
        int[] index = new int[n];       //记录重复单词的下标
        System.out.printf("总共有%d种重复的字符串,分别是:\n",solution.countDuplicateString_1(arr));
        for(String str:solution.map.keySet()){
            if(solution.map.get(str)!=1){
                System.out.print(str+"\t");
            }
        }
    }

    public void printStringArray(String[] strArray){
        //打印字符串数组,每20个一行
        for(int i=0;i<strArray.length;i++){
            if(i%20==0){
                System.out.print("\n");         //每到20个就换行
            }
            System.out.print(strArray[i]+"\t");
        }
    }

    public int countDuplicateString_1(String[] arr){
        //统计字符串数组里重复的字符串有多少种,使用HashMap来存储每个字符串和对应的次数
        //但忽略不了大小写
        int result = 0;

        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }else{
                map.put(arr[i],map.get(arr[i]+1));
            }
        }
        for(String str:map.keySet()){
            if(map.get(str)!=1)
                result += 1;
        }
        return result;
    }

    public int countDuplicateString_2(String[] arr,int[] index){
        //统计字符串数组里重复的字符串有多少种

        int result = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i].equalsIgnoreCase(arr[j])){
                    index[i] += 1;
                }
            }
        }
    }
}
