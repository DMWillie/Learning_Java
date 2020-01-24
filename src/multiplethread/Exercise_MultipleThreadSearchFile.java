package multiplethread;

/*  Author: 北辰
    日期: 11/01/2020
    修改日期: 24/01/2020
    功能: 使用多线程查找某个文件夹下的含有指定字符串内容的文件并打印出来
    遍历所有文件，当遍历到文件是.java的时候，创建一个线程去查找这个文件的内容，
    不必等待这个线程结束，继续遍历下一个文件
    修改之处: 借助线程池同步查找文件内容,初始化一个大小是10的线程池
遍历所有文件，当遍历到文件是.java的时候，创建一个查找文件的任务，把这个任务扔进线程池去执行，继续遍历下一个文件
 */

import java.io.File;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Exercise_MultipleThreadSearchFile {
    public static void main(String[] args) {
        File f = new File("d:/Learning_Java");
        //寻找在d:/Learning_java文件夹中包含Hero的.java文件并打印出来
        searchThreadPool(f,".java","Hero");
    }
    //使用多线程遍历某个目录下(包括子文件夹)的指定后缀名的文件,找出包含指定内容的文件并打印出来
    public static void searchThread(File folder,String suffix,String search){
        File[] list = folder.listFiles();
        for(int i=0;i<list.length;i++){
            if(list[i].isDirectory())  //遍历子文件夹
                searchThread(list[i],suffix,search);
            String fname = list[i].getAbsolutePath();
            if(fname.endsWith(suffix)){     //以suffix为后缀名
                //创建一个新的线程去查找内容
                SearchFileContent sfc = new SearchFileContent(list[i],search);
                new Thread(sfc).start();
            }//同时继续遍历下一个文件
        }
    }

    //使用线程池的方式遍历某个目录下(包括子文件夹)的指定后缀名的文件,找出包含指定内容的文件并打印出来
    public static void searchThreadPool(File folder,String suffix,String search){
        File[] list = folder.listFiles();
        for(int i=0;i<list.length;i++){
            if(list[i].isDirectory()){      //遍历子文件夹
                searchThreadPool(list[i],suffix,search);
            }
            String fname = list[i].getAbsolutePath();
            //创建一个线程池
            ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10,
                    15,60, TimeUnit.SECONDS,new
                    LinkedBlockingQueue<Runnable>());
            if (fname.endsWith(suffix)) {       //以suffix为后缀名
                SearchFileContent sfc = new SearchFileContent(list[i],search);
                threadPool.execute(sfc);
            }//同时继续遍历下一个文件
        }
    }
}
