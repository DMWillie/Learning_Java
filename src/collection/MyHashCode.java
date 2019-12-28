package collection;

/*  Author: 北辰
    日期: 28/12/2019
    功能: 自定义一个简单的hashcode算法，计算任意字符串的hashcode
因为String类不能被重写，所以我们通过一个静态方法来返回一个String的hashcode
public static int hashcode(String)
如果字符串长度是0，则返回0。
否则： 获取每一位字符，转换成数字后，相加，最后乘以23
(s[0]+ s[1] + s[2] + s[3]+ s[n-1])*23.
如果值超过了1999，则取2000的余数，保证落在0-1999之间。
如果是负数，则取绝对值。
随机生成长度是2-10的不等的100个字符串，打印用本hashcode获取的值分别是多少
 */

import digitAndstring.Exercise_RandomString;

public class MyHashCode {
    public static void main(String[] args){
        Exercise_RandomString e = new Exercise_RandomString();
        //初始化一个含有100个字符串的字符串数组
        String[] arr = new String[100];
        for(int i=0;i<arr.length;i++){
            int len = (int)(Math.random()*9+2);  //该字符串的长度
            arr[i] = e.getRandomString_2(len);  //生成长度为len的由字母，数字组成的随机字符串
            int hashcode = hashcode(arr[i]);    //计算该字符串对应的hashcode
            System.out.printf("字符串\"%s\"对应的hashcode为:%d%n",arr[i],hashcode);
        }
    }

    //自定义计算hashcode的算法
    public static int hashcode(String str){
        if(str.equals(""))
            return 0;
        int result = 0;
        char[] strArr = str.toCharArray();
        for(int i=0;i<strArr.length;i++){
            result += (int)strArr[i];
        }
        result *= 23;
        //保证返回值落在0-1999之间
        return result>1999?(result%2000):result;
    }
}
