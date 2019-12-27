package collection;

/*  Author: 北辰
    日期: 27/12/2019
    功能: 利用LinkedHashSet的既不重复，又有顺序的特性，把Math.PI中的数字，
    按照出现顺序打印出来，相同数字，只出现一次
 */

import java.util.LinkedHashSet;

public class Exercise_SortedAndNoDuplicate {
    public static void main(String[] args){
        String numStr = String.valueOf(Math.PI);    //先将数字变为字符串
        char[] numArr = numStr.toCharArray();   //将字符串中的每个数字拿出来组成一个字符数组
        //使用LinkedHashSet来组成一个有序集合
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for(Character c:numArr){
            if(Character.isDigit(c)){       //排除"."的影响
                String s = String.valueOf(c);       //将单个字符变为字符串
                set.add(Integer.parseInt(s));       //把每个字符串解析成数字
            }
        }
        System.out.println(set);
    }
}
