package collection;

/*  Author: 北辰
    日期: 05/12/2019
    功能: 使用LinkedList实现Stack栈
    与FIFO(先入先出的)队列类似的一种数据结构是FILO先入后出栈Stack
根据接口Stack ：
实现类：MyStack
public class MyStack implements Stack
并向这个栈中，压入5个英雄，接着弹出5个英雄
 */

import character.Hero;

import java.util.LinkedList;

public class MyStack implements Stack{
    private LinkedList<Hero> l = new LinkedList<Hero>();

    @Override
    public void push(Hero h){
        //把英雄推入到最后一个位置
        l.addLast(h);
    }
    @Override
    public Hero pull(){
        //把最后一个英雄取出来
        Hero h = l.removeLast();
        return h;
    }
    @Override
    public Hero peek(){
        //查看最后一个英雄
        Hero h = l.getLast();
        return h;
    }

    public static void main(String[] args){
        //向这个栈中，压入5个英雄，接着弹出5个英雄
        Hero[] heros = new Hero[5];
        for(int i=0;i<heros.length;i++){
            heros[i] = new Hero("hero "+i);
        }
        MyStack stack = new MyStack();
        System.out.println("stack初始化为: \t"+stack.l);
        for(int i=0;i<heros.length;i++){
            stack.push(heros[i]);
        }
        System.out.print("放入5个英雄后,stack为: \t");
        System.out.println(stack.l);
        for(int i=0;i<heros.length;i++){
            Hero h = stack.pull();
            System.out.println("已取出英雄"+h);
        }
        System.out.println("现在stack为: \t"+stack.l);
    }
}
