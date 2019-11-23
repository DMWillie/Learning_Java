package stream;

/*  Author: 北辰
    日期: 23/11/2019
    功能: 有时需要把数据立即写入到硬盘中,而不是等到缓存满了才写入。这时就需要用到flush
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestFlush {
    public static void main(String[] args){
        //向文件lol3.txt中写入三行语句
        File f = new File("D:\\Learning_Java\\src\\data\\lol3.txt");
        //创建文件字符流
        //缓存流必须建立在一个存在的流的基础之上
        try(FileWriter fr=new FileWriter(f); PrintWriter pw=new PrintWriter(fr)){
            pw.println("garen kill teemo");
            //强制把缓存中的数据写入硬盘,无论缓存是否已满
            pw.flush();
            pw.println("teemo revive after 1 minutes");
            pw.flush();
            pw.println("teemo try to garen, but killed again");
            pw.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
