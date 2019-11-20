package stream;

/*  Author: 北辰
    日期: 20/11/2019
    功能: 用FileReader字符流正确读取中文
 */

import java.io.*;
import java.nio.charset.Charset;

public class TestReadRightChinese {
    public static void main(String[] args){
        File f = new File("d:/test.txt");
        System.out.println("默认编码方式:"+ Charset.defaultCharset());
        //FileReader得到的是字符,所以一定是已经把字节根据某种编码识别成了字符了
        //而FileReader使用的编码方式是Charset.defaultCharset()的返回值,如果是中文的操作系统,就是UTF-8
        try(FileReader fr=new FileReader(f)){
            char[] cs = new char[(int)f.length()];
            fr.read(cs);
            System.out.printf("FileReader会使用默认的编码方式%s,识别出的字符是:%n",
                    Charset.defaultCharset());
            System.out.println(new String(cs));
        }catch(IOException e){
            e.printStackTrace();
        }
        //FileReader是不能手动设置编码方式的，为了使用其他的编码方式，只能使用InputStreamReader来代替
        //并且使用new InputStreamReader(new FileInputStream(f),Charset.forName("GBK")); 这样的形式
        try(InputStreamReader isr = new InputStreamReader(
                new FileInputStream(f),Charset.forName("GBK"))){
            char[] cs = new char[(int)f.length()];
            isr.read(cs);
            System.out.printf("InputStreamReader指定编码方式GBK,识别出来的字符是:%n");
            System.out.println(new String(cs));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
