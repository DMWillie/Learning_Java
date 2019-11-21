package stream;

/*  Author: 北辰
    日期: 20/11/2019
    修改: 21/11/2019
    功能: 找出 E5 B1 8C 这3个十六进制对应UTF-8编码的汉字
 */

import java.io.*;

public class Exercise_NumConvertChinese {
    public static void main(String[] args) throws UnsupportedEncodingException{
        byte[] num = {(byte)0xe5,(byte)0xb1,(byte)0x8c};
        String ans = getChinese_2(num);
        System.out.println("E5 B1 8C 这3个十六进制对应UTF-8编码的汉字为:\n"+ans);
    }

    /**方法一:将字节保存到文件再读取出相应的字符串*/
    public static String getChinese_1(byte[] num){
        File f = new File("d:/test1.txt");
        try(FileOutputStream fos = new FileOutputStream(f)){
            //System.out.println(num[2]);
            fos.write(num);
        }catch (IOException e){
            e.printStackTrace();
        }
        try(FileReader fr = new FileReader(f)){     //获取文件字符流
            char[] cs = new char[(int)f.length()];
            fr.read(cs);
            //System.out.println("E5 B1 8C 这3个十六进制对应UTF-8编码的汉字为:\n"+new String(cs));
            return String.valueOf(cs);
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    //方法二***,直接使用String的构造方法(带编码)
    public static String getChinese_2(byte[] num) throws UnsupportedEncodingException{
        String str = new String(num,"UTF-8");

        String str2 = getChinese_1(num);
        byte[] bs = str2.getBytes("UTF-8");  //获取字符串编码为"UTF-8"的字节
        for(byte b:bs){
            System.out.printf("%x\t",b);
        }
        System.out.println();
        return str;
    }
}
