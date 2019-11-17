package stream;

/*  Author: 北辰
    日期: 17/11/2019
    功能: 使用字符流FileWriter把字符串写入文件
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestFileWriter {
    public static void main(String[] args){
        // 准备文件lol2.txt
        File f = new File("d:/lol2.txt");
        // 创建基于文件的Writer
        try(FileWriter fw = new FileWriter(f)){
            String data = "abcdefgh1234567";
            char[] cs = data.toCharArray();
            fw.write(cs);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
