package multiplethread;

/*  Author: 北辰
    日期: 12/01/2020
    功能: 日志线程,打印都用过哪些字符串去匹配,这个日志线程设计为守护线程(不完善)
 */

import java.util.ArrayList;

public class LogThread extends Thread implements Runnable{

    private ArrayList<String> list = new ArrayList<>();

    public LogThread(ArrayList<String> list){
        this.list = list;
    }
    @Override
    public void run(){
        for(int i=0;i<list.size();i++){
            String pwd = list.get(i);
            if(pwd==null){
                try{
                    Thread.sleep(1000);//容器为空则休眠1s
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.printf("正在尝试使用字符串 %s去匹配正确的密码%n",pwd);
        }
    }
}
