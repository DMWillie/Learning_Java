package multiplethread;

/*  Author: 北辰
    日期: 12/01/2020
    功能: 日志线程,打印都用过哪些字符串去匹配,这个日志线程设计为守护线程
    改进之处: 不再通过遍历的方式去打印集合中的元素,而是通过每次移除第一个元素来获取
 */

import java.util.ArrayList;

public class LogThread extends Thread implements Runnable{

    private ArrayList<String> list;

    public LogThread(ArrayList<String> list){
        this.list = list;
    }
    @Override
    public void run(){
        while(true){
            if(list.isEmpty()){ //如果集合中没有穷举法生成的密码或者已经打印过
                try{
                    Thread.sleep(1000); //休眠1s
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }else{
                String pwd = list.remove(0);    //将第一个移除,才能遍历得到所有的(在集合动态变化
                //的情况下)
                System.out.printf("已尝试使用字符串 %s去匹配正确的密码%n",pwd);
            }
        }
//        for(int i=0;i<list.size();i++){
//            String pwd = list.get(i);
//            if(pwd==null){
//                try{
//                    Thread.sleep(1000);//容器为空则休眠1s
//                }catch(InterruptedException e){
//                    e.printStackTrace();
//                }
//            }
//            System.out.printf("正在尝试使用字符串 %s去匹配正确的密码%n",pwd);
//        }
    }
}
