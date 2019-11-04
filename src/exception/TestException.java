package exception;

/*  Author: 北辰
    日期: 03/11/2019
    功能: 测试Java中异常类的一些用法
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestException {

    public static void main(String[] args){
        File f = new File("d:/LOL.exe");
        //试图打开文件LOL.exe,会抛出FileNotFoundException异常,如果不处理该异常,就会有编译错误
        //new FileInputStream(f);
        try{
            System.out.println("试图打开 d:/LOL.exe");
            new FileInputStream(f);
            System.out.println("成功打开");
        }catch(FileNotFoundException e){
            System.out.println("d:/LOL.exe文件不存在");
            e.printStackTrace();
        }finally{
            System.out.println("无论文件是否存在，都会执行的代码");
        }
    }
}
