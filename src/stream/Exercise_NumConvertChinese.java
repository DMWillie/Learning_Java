package stream;

/*  Author: 北辰
    日期: 20/11/2019
    功能: 找出 E5 B1 8C 这3个十六进制对应UTF-8编码的汉字
 */

import java.io.*;

public class Exercise_NumConvertChinese {
    public static void main(String[] args){
        File f = new File("d:/test1.txt");
        try(FileOutputStream fos = new FileOutputStream(f)){
            byte[] num = {(byte)0xe5,(byte)0xb1,(byte)0x8c};
            //System.out.println(num[2]);
            fos.write(num);
        }catch (IOException e){
            e.printStackTrace();
        }
        try(FileReader fr = new FileReader(f)){
            char[] cs = new char[(int)f.length()];
            fr.read(cs);
            System.out.println("E5 B1 8C 这3个十六进制对应UTF-8编码的汉字为:\n"+new String(cs));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
