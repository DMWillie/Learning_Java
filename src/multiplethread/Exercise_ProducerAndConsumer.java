package multiplethread;

/*  Author: 北辰
    日期: 18/01/2020
    功能: 生产者消费者问题是一个非常典型性的线程交互的问题。
1. 使用栈来存放数据
1.1 把栈改造为支持线程安全
1.2 把栈的边界操作进行处理，当栈里的数据是0的时候，访问pull的线程就会等待。
当栈里的数据是200的时候，访问push的线程就会等待
2. 提供一个生产者（Producer）线程类，生产随机大写字符压入到堆栈
3. 提供一个消费者（Consumer）线程类，从堆栈中弹出字符并打印到控制台
4. 提供一个测试类，使两个生产者和三个消费者线程同时运行
 */

public class Exercise_ProducerAndConsumer {
    public static void main(String[] args) {
        SynchronizedStack<Character> stack = new SynchronizedStack<>();
        //消费者比生产者多
        stack.push('#');
        //2个生产者线程
        for(int i=0;i<2;i++){
            ProducerThread pt = new ProducerThread(stack,"Producer"+(i+1));
            new Thread(pt).start();
        }
        //3个消费者线程
        for(int j=0;j<3;j++){
            ConsumerThread ct = new ConsumerThread(stack,"Consumer"+(j+1));
            new Thread(ct).start();
        }
    }
}
