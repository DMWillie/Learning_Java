package reflection;

/*  Author: 北辰
    日期: 29/01/2020
    功能: 在对象方法前，加上修饰符synchronized ，同步对象是当前实例。
那么如果在类方法前，加上修饰符 synchronized，同步对象是什么呢？
编写代码进行验证
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestReflection {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            public void run(){
                method1();
            }
        };
        t1.setName("t1线程");
        t1.start();

        Thread t2 = new Thread(){
            public void run(){
                method2();
            }
        };
        t2.setName("t2线程");
        t2.start();
    }

    public static String now(){
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }
    public static void log(String msg){
        System.out.printf("%s %s %s%n",now(),Thread.currentThread().getName(),msg);
    }

    public static void method1(){
        synchronized(TestReflection.class){
            // 对于method1而言，同步对象是TestReflection.class，
            // 只有占用TestReflection.class才可以执行到这里
            log("进入了method1()方法");
            try{
                log("运行5s");
                Thread.sleep(5000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static synchronized void method2(){
        // 对于mehotd2而言，必然有个同步对象，通过观察发现，当某个线程在method1中，
        // 占用了TestReflection.class之后就无法进入method2，
        // 推断出，method2的同步对象，就是TestReflection.class
        log("进入了method2()方法");
        try{
            log("运行5s");
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
