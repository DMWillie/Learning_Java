package stream;

/*  Author: 北辰
    日期: 22/11/2019
    功能: 使用缓存字符输出流 PrintWriter 可以一次写入一行数据
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestPrintWriter {
    public static void main(String[] args){
        File f = new File("d:/Learning_Java/src/data/lol2.txt");
        String str1 = new String("garen kill teemo");
        String str2 = new String("teemo revive after 1 minutes");
        String str3 = new String("teemo try to garen, but killed again");
        String[] data = {str1,str2,str3};
        //创建文件字符流
        //缓存流必须建立在一个存在的流的基础上
        try(
                FileWriter fw = new FileWriter(f);
                PrintWriter pw = new PrintWriter(fw);
                )
        {
            for(String str:data){
                pw.println(str);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
