package multiplethread;

/*  Author: 北辰
    日期: 18/01/2020
    功能: 生产者（Producer）线程类，生产随机大写字符压入到堆栈
 */
public class ProducerThread implements Runnable {
    private SynchronizedStack<Character> stack;
    private String name;

    public ProducerThread(SynchronizedStack<Character> stack,String name){
        this.stack = stack;
        this.name = name;
    }
    @Override
    public void run(){
        //向栈中放入一个随机大写字符
        Character c = getRandomUpperChar();
        stack.push(c);
        System.out.println(this.name+" 压入: "+c);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //产生随机大写字符
    private static Character getRandomUpperChar(){
        int x = 'A',y='Z';
        char result = (char)((int)(Math.random()*(y-x+1)+x));
        return result;
    }
}
