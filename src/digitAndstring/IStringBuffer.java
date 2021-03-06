package digitAndstring;

/*  Author: 北辰
    日期: 30/10/2019
    功能: IStringBuffer接口
 */

import exception.IndexIsNegativeException;
import exception.IndexIsOutofRangeException;

public interface IStringBuffer {
    public void append(String str);             //追加字符串
    public void append(char c);                 //追加字符
    public void insert(int pos,char b);         //指定位置插入字符
    public void insert(int pos,String b) throws IndexIsNegativeException, IndexIsOutofRangeException;       //指定位置插入字符串
    public void delete(int start);              //从开始位置删除剩下的
    public void delete(int start,int end);      //从开始位置删除结束位置-1
    public void reverse();                      //反转
    public int length();                        //返回长度
}
