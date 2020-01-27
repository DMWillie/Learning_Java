package jdbc;

/*  Author: 北辰
    日期: 27/01/2020
    功能: 向数据库中插入100条数据，比较传统方式和数据库连接池方式的性能差异
1. 使用传统方式创建100个线程，每个线程都会创建新的连接，通过这个连接向数据库插入1条数据，然后关闭这个连接。
2. 使用数据库连接池的方式，创建一个有10条连接的连接池，然后创建100个线程，每个线程都会向连接池借用连接，
借用到后，向数据库插入1条数据，然后归还这个连接。
通过时间统计，比较这两种方式的性能表现差异。
 */

public class Exercise_ConnectionPoolPerformance {

    public static void main(String[] args) {
        int threadNum = 100;
        int poolSize = 10;
        long t1 = getTraditionalInsertTime(threadNum);
        System.out.printf("使用传统方式创建%d个线程,每个线程向数据库中插入一条数据,共耗时 %d毫秒%n",
                threadNum,t1);
        long t2 = getConnectionPoolInsertTime(threadNum,poolSize);
        System.out.printf("使用数据库连接池方式创建具有%d条连接的连接池," +
                        "然后创建%d个线程,每个线程向数据库中插入一条数据,共耗时 %d毫秒%n",
                poolSize,threadNum,t2);
    }

    //统计传统方式向数据库中插入数据的时间
    public static long getTraditionalInsertTime(int threadNum){
        long start = System.currentTimeMillis();
        //加载数据库驱动
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        TraditionalThread[] ts = new TraditionalThread[threadNum];
        for(int i=0;i<threadNum;i++){
            TraditionalThread t = new TraditionalThread("传统线程 "+i);
            ts[i] = t;
            t.start();
        }
        //直到所有线程运行完才统计时间
        for(TraditionalThread t:ts){
            try{
                t.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        return end-start;
    }

    //统计使用数据库连接池向数据库中插入数据的时间
    public static long getConnectionPoolInsertTime(int threadNum,int poolSize){
        long start = System.currentTimeMillis();
        ConnectionPool cp = new ConnectionPool(poolSize);
        ConnectionPoolThread[] ts = new ConnectionPoolThread[threadNum];
        for(int i=0;i<threadNum;i++){
            ConnectionPoolThread t = new ConnectionPoolThread("working thread "+i,cp);
            ts[i] = t;
            t.start();
        }
        //直到所有线程运行完才统计时间
        for(ConnectionPoolThread t:ts){
            try{
                t.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        return end-start;
    }
}
