package stream;

/*  Author: 北辰
    日期: 17/11/2019
    功能: 在try中关闭流这样做有一个弊端:如果文件不存在,或者读取的时候出现问题而抛出异常
        那么就不会执行这一关闭流的代码,存在巨大的资源占用隐患.
        目前使用在finally中关闭,这是标准的关闭流的方式
        1. 首先把流的引用声明在try的外面，如果声明在try里面，其作用域无法抵达finally.
        2. 在finally关闭之前，要先判断该引用是否为空
        3. 关闭的时候，需要再一次进行try catch处理
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class closeWithFinally {
    public static void main(String[] args){
        File f = new File("d:/lol.txt");
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(f);
            byte[] all = new byte[(int)f.length()];
            fis.read(all);
            for(byte b:all){
                System.out.println(b);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        finally{
            //在finally里关闭流
            if(null!=fis){
                try{
                    fis.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
