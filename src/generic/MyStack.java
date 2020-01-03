package generic;

/*  Author: 北辰
    日期: 03/01/2020
    功能: 设计一个支持泛型的栈MyStack
设计这个类的时候，在类的声明上，加上一个<T>，表示该类支持泛型。
T是type的缩写，也可以使用任何其他的合法的变量，比如A,B,X都可以，但是一般约定成俗使用T，代表类型
 */

import character.Hero;
import property.Item;

import java.util.LinkedList;

public class MyStack<T> {
    LinkedList<T> values = new LinkedList<T>();

    public void push(T t){
        values.addLast(t);
    }
    public T pull(){
        return values.removeLast();
    }
    public T peek(){
        return values.getLast();
    }
    public static void main(String[] args){
        //在声明这个Stack的时候，使用泛型<Hero>就表示该Stack只能放Hero
        MyStack<Hero> heroStack = new MyStack<>();
        heroStack.push(new Hero());
        //不能放Item
        //heroStack.push(new Item());

        //在声明这个Stack的时候，使用泛型<Item>就表示该Stack只能放Item
        MyStack<Item> itemStack = new MyStack<>();
        itemStack.push(new Item());
        //不能放Hero
        //itemStack.push(new Hero());
    }
}
