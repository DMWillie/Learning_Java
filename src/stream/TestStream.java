package stream;

/*  Author: 北辰
    日期: 12/11/2019
    功能: 测试文件流Stream的一些用法
 */

import java.io.*;

public class TestStream {

    public static void main(String[] args){
        //准备文件lol.txt其中的内容是AB，对应的ASCII分别是65 66
        File f = new File("d:/lol.txt");
        try{
            //创建基于文件的输入流
            FileInputStream fis = new FileInputStream(f);
            //通过这个输入流,就可以把数据从硬盘,读取到Java的虚拟机来,也就是读取到内存中
            //创建字节数组，其长度就是文件的长度
            byte[] all = new byte[(int)f.length()];
            //以字节流的形式读取文件所有内容
            fis.read(all);
            for(byte b:all){
                //打印出来是65 66
                System.out.println(b);
            }
            //每次使用完流，都应该进行关闭
            fis.close();
            //创建基于文件的输出流
            //FileOutputStream fos = new FileOutputStream(f);
        }catch(FileNotFoundException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
