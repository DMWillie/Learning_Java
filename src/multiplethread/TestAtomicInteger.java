package multiplethread;
/*  Author: 北辰
    日期: 25/01/2020
    功能:JDK6 以后，新增加了一个包java.util.concurrent.atomic，里面有各种原子类，比如AtomicInteger。
而AtomicInteger提供了各种自增，自减等方法，这些方法都是原子性的。
换句话说，自增方法 incrementAndGet 是线程安全的，同一个时间，只有一个线程可以调用这个方法
 */

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicInteger {
    public static void main(String[] args) {
        AtomicInteger atomicI = new AtomicInteger();
        int i = atomicI.decrementAndGet();
        System.out.println(i);
        int j = atomicI.incrementAndGet();
        System.out.println(j);
        int k = atomicI.addAndGet(3);
        System.out.println(k);
    }
}
