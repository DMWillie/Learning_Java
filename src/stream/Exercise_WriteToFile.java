package stream;

/*  Author: 北辰
    日期: 14/11/2019
    功能: 以字节流的形式向文件写入数据中的例子，当lol2.txt不存在的时候，是会自动创建lol2.txt文件的。
        但是，如果是写入数据到d:/xyz/lol2.txt，而目录xyz又不存在的话，就会抛出异常。
        那么怎么自动创建xyz目录？
        如果是多层目录 d:/xyz/abc/def/lol2.txt 呢
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise_WriteToFile {

    public static String filePath = "d:/xyz/abc/def/lol.txt"; //文件路径

    public static void main(String[] args){
        try{
            File parentFolder = new File(getFilePath(filePath));
            if(!parentFolder.exists())  //判断文件父目录是否存在
                parentFolder.mkdirs();//不存在则先创建
            File f = new File(filePath);
            FileOutputStream fos = new FileOutputStream(f);
            byte[] data = {42,43};
            fos.write(data);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    //获取一个文件路径的目录(不包含文件名)
    public static String getFilePath(String str){
        String[] temp = str.split("/");
        String result = "";
        for(int i=0;i<temp.length-1;i++)
            result += temp[i]+"/";
        return result;
    }
}
