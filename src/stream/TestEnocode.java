package stream;

/*  Author: 北辰
    日期: 17/11/2019
    功能: 写在.java源代码中的汉字，在执行之后，都会变成JVM中的字符。
        而这些中文字符采用的编码方式，都是使用UNICODE
 */

import java.io.UnsupportedEncodingException;

public class TestEnocode {
    public static void main(String[] args){
        //"中"字对应的UNICODE是4E2D,所以在内存中，实际保存的数据就是十六进制的0x4E2D, 也就是十进制的20013
        String str = "中";
        System.out.println(str);
        int x = 0x4E2D;
        char y = (char)x;
        System.out.println(y);
        System.out.println();
        showCode(str);
    }

    //观察一个中文字符在不同的编码方式下的值为多少
    private static void showCode(String str){
        String[] encodes = {"BIG5","GBK","GB2312","UTF-8","UTF-16","UTF-32"};
        for(String encode:encodes){
            showCode(str,encode);
        }
    }

    private static void showCode(String str,String encode){
        try{
            System.out.printf("字符: \"%s\" 在编码方式%s下的十六进制值是%n",str,encode);
            byte[] bs = str.getBytes(encode);
            for(byte b:bs){
                int i = b&0xff;
                System.out.print(Integer.toHexString(i)+" ");
            }
            System.out.println();
            System.out.println();
        }catch(UnsupportedEncodingException e){
            System.out.printf("UnsupportedEncodingException: %s编码方式无法解析字符%s\n",
                    encode,str);
        }
    }
}
