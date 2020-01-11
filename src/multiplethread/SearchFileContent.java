package multiplethread;

/*  Author: 北辰
    日期: 11/01/2020
    功能: 搜寻文件是否含有某个内容,实现Runnable接口
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SearchFileContent implements Runnable{
    private File f;
    private String search;

    public SearchFileContent(File f,String search){
        this.f = f;
        this.search = search;
    }
    @Override
    public void run(){      //实现run方法,就是查找某个文件中是否含有指定的字符串
        try(
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                ){
            String line = null;
            while((line=br.readLine())!=null){
                if(line.contains(search)) {
                    System.out.printf("%s线程在文件%s中找到了字符串%s!\n",
                            Thread.currentThread().getName(), f, search);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
