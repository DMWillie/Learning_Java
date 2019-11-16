package stream;

/*  Author: 北辰
    日期: 16/11/2019
    功能: 将拆分出来的文件合并成一个原文件,以是否能正常运行,验证合并是否正确
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise_MergeFile {
    public static void main(String[] args){
        int n = 5;
        int totalLen = 0;           //合并的文件的总长度
        for(int i=0;i<n;i++){
            File tmp = new File("d:/git.exe-"+i);
            totalLen += (int)tmp.length();
        }
        byte[] all = new byte[totalLen];
        //将拆分的文件合并
        try{
            File f = new File("d:/git.exe");
            FileOutputStream fos = new FileOutputStream(f);
            int last = 0;       //每次写入到合并文件的最后的位置
            for(int i=0;i<n;i++){
                File subFile = new File("d:/git.exe-"+i);
                FileInputStream fis = new FileInputStream(subFile);
                byte[] data = new byte[(int)subFile.length()];
                fis.read(data);
                System.arraycopy(data,0,all,last,data.length);
                last += data.length;
                fis.close();
            }
            fos.write(all);
            fos.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
