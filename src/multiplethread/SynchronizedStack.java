package multiplethread;
/*  Author: 北辰
    日期: 18/01/2020
    功能: 使用LinkedList实现Stack栈,并且是线程安全的;且当栈中的数据为0时,访问pull的线程
    就会等待;当栈中的数据为200时,访问push的线程就会等待
 */

import java.util.LinkedList;

public class SynchronizedStack<T> implements IStack<T>{
    //内部使用LinkedList来实现栈,支持存放单个字符
    private LinkedList<T> list = new LinkedList<T>();

    @Override
    public synchronized void push(T t){
        if(list.size()==200){
            try{
                //当栈中的数据为200时,访问push的线程会等待
                this.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        //把字符推入最后一个位置
        list.addLast(t);
        //通知等待当前对象的线程,并临时释放当前对象
        this.notify();
    }
    @Override
    public synchronized T pull(){
        if(list.size()==0){
            try{
                //当栈中的数据为0时,访问pull的线程会暂停
                this.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        //把最后一个字符取出来
        T t = list.removeLast();
        //通知等待当前对象的线程,并临时释放当前对象
        this.notify();
        return t;
    }
    @Override
    public synchronized T peek(){
        if(list.size()==0){
            try{
                //当前栈中没有数据,则peek线程进行等待
                this.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        T t = list.getLast();
        return t;
    }
}
