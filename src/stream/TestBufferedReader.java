package stream;

/*  Author: 北辰
    日期: 22/11/2019
    功能: 使用缓存字符输入流 BufferedReader 可以一次读取一行数据
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestBufferedReader {
    public static void main(String[] args){
        //准备文件lol.txt中的内容是
        //garen kill teemo
        //teemo revive after 1 minutes
        //teemo try to garen, but killed again
        File f = new File("d:/Learning_Java/src/data/lol.txt");
        //创建文件字符流
        //缓存流必须建立在一个存在的流的基础上
        try(
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                )
        {
            while(true){
                //一次读一行
                String line = br.readLine();
                if(null==line)
                    break;
                System.out.println(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
