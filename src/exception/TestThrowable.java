package exception;

/*  Author: 北辰
    日期: 06/11/2019
    功能: 测试Throwable的用法,Throwable是类，Exception和Error都继承了该类
        所以在捕捉的时候，也可以使用Throwable进行捕捉
 */

import java.io.File;
import java.io.FileInputStream;

public class TestThrowable {

    public static void main(String[] args){
        File f = new File("d:/LOL.exe");
        try{
            new FileInputStream(f);
        }catch(Throwable t){
            // TODO Auto-generated catch block
            t.printStackTrace();
        }
    }
}
