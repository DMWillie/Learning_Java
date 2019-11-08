package exception;

/*  Author: 北辰
    日期: 08/11/2019
    功能: IStringBuffer接口,不过当实现此接口的类抛出异常时,相应的抽象方法也要抛出异常
 */

public interface IStringBuffer {
    public void append(String str) throws IndexIsNegativeException, IndexIsOutofRangeException;             //追加字符串
    public void append(char c) throws IndexIsOutofRangeException,
            IndexIsNegativeException;                 //追加字符
    public void insert(int pos, char b) throws IndexIsNegativeException,
            IndexIsOutofRangeException;         //指定位置插入字符
    public void insert(int pos, String b) throws IndexIsOutofRangeException,
            IndexIsNegativeException,NullPointerException;       //指定位置插入字符串
    public void delete(int start) throws IndexIsNegativeException, IndexIsOutofRangeException;              //从开始位置删除剩下的
    public void delete(int start, int end) throws IndexIsNegativeException, IndexIsOutofRangeException;      //从开始位置删除结束位置-1
    public void reverse();                      //反转
    public int length();                        //返回长度
}
