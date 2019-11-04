package exception;

/*  Author: 北辰
    日期: 04/11/2019
    功能: 测试异常中throws和throw的用法
    throws与throw这两个关键字接近，不过意义不一样，有如下区别：
1. throws 出现在方法声明上，而throw通常都出现在方法体内。
2. throws 表示出现异常的一种可能性，并不一定会发生这些异常；throw则是抛出了异常，执行throw则一定抛出了某个异常对象。
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestThrowException {
    public static void main(String[] args){
        method1();
    }

    private static void method1(){
        try{
            method2();
        }catch(FileNotFoundException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void method2() throws FileNotFoundException{
        File f = new File("d:/LOL.exe");
        System.out.println("试图打开 d:/LOL.exe");
        new FileInputStream(f);
        System.out.println("成功打开");
    }

}
