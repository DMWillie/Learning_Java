package multiplethread;

/*  Author: 北辰
    日期: 18/01/2020
    功能: 消费者（Consumer）线程类，从堆栈中弹出字符并打印到控制台
 */
public class ConsumerThread implements Runnable{
    private SynchronizedStack<Character> stack;
    private String name;

    public ConsumerThread(SynchronizedStack<Character> stack,String name){
        this.stack = stack;
        this.name = name;
    }
    @Override
    public void run(){
        Character c = stack.pull();
        System.out.println(this.name+" 弹出: "+c);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
