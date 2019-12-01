package collection;

/*  Author: 北辰
    日期: 01/12/2019
    功能: 集合LinkedList,实现了双向队列Deque
    LinkedList 除了实现了List和Deque外，还实现了Queue接口(队列)。
Queue是先进先出队列 FIFO，常用方法：
offer 在最后添加元素
poll 取出第一个元素
peek 查看第一个元素
 */

import character.Hero;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TestLinkedList {
    public static void main(String[] args){
        /**双向链表Deque*/
        //LinkedList是一个双向链表结构的list
        LinkedList<Hero> ll = new LinkedList<Hero>();
        //所以可以很方便的在头部和尾部插入数据
        //在最后插入新的英雄
        ll.addLast(new Hero("hero 1"));
        ll.addLast(new Hero("hero 2"));
        ll.addLast(new Hero("hero 3"));
        System.out.println(ll);
        //在最前面插入新的英雄
        ll.addFirst(new Hero("hero X"));
        System.out.println(ll);
        //查看最前面的英雄
        System.out.println(ll.getFirst());
        //查看最后面的英雄
        System.out.println(ll.getLast());
        //查看不会导致英雄被删除
        System.out.println(ll);
        //取出最前面的英雄
        System.out.println(ll.removeFirst());
        //取出最后面的英雄
        System.out.println(ll.removeLast());
        //取出会导致英雄被删除
        System.out.println(ll);
        /**队列Queue*/
        //和ArrayList一样，LinkedList也实现了List接口
        List<Hero> list = new LinkedList<Hero>();
        //所不同的是LinkedList还实现了Deque，进而又实现了Queue这个接口
        //Queue代表FIFO 先进先出的队列
        Queue<Hero> q = new LinkedList<Hero>();
        //加在队列的最后面
        System.out.print("初始化队列: \t");
        q.offer(new Hero("Hero1"));
        q.offer(new Hero("Hero2"));
        q.offer(new Hero("Hero3"));
        q.offer(new Hero("Hero4"));
        System.out.println(q);
        System.out.print("把第一个元素取poll()出来:\t");
        //取出第一个Hero,FIFO
        Hero h = q.poll();
        System.out.println(h);
        System.out.print("取出第一个元素之后的队列:\t");
        System.out.println(q);
        //把第一个拿出来看一看，但是不取出来
        h = q.peek();
        System.out.print("查看peek()第一个元素:\t");
        System.out.println(h);
        System.out.print("查看并不会导致第一个元素被取出来:\t");
        System.out.println(q);
    }
}
