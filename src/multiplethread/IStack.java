package multiplethread;

/*  Author: 北辰
    日期: 18/01/2020
    功能: 自定义接口IStack,支持泛型<T>
 */

public interface IStack<T> {
    //把对象推入到最后位置
    public void push(T t);
    //把最后一个对象取出来
    public T pull();
    //查看最后一个对象
    public T peek();

}
