package multiplethread;
/*  Author: 北辰
    日期: 19/01/2020
    功能: 测试线程池,可以看到某个任务消费者线程执行完任务后又继续执行任务
 */
public class TestThreadPool {
    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool();
        for(int i=0;i<5;i++){
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行任务...");
                    //任务可能是打印一句话
                    //可能是访问文件
                    //可能是做排序
                }
            };
            pool.add(task);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
