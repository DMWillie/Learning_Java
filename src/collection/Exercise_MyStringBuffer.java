package collection;

/*  Author: 北辰
    日期: 27/11/2019
    功能: 不使用字符数组来实现MyStringBuffer,而是使用ArrayList来实现
 */

import java.util.ArrayList;

public class Exercise_MyStringBuffer {

    public static void main(String[] args){
        MyStringBuffer msb = new MyStringBuffer("adafaf");
        System.out.println(msb);
        System.out.println(msb.length());
    }
}

class MyStringBuffer{
    ArrayList value = new ArrayList();

    //构造方法,传入一个字符串
    public MyStringBuffer(String str){
        value.add(str);
    }

    //追加字符串
    public void append(String str){

    }
    //追加字符
    public void append(char c){

    }
    //指定位置插入字符
    public void insert(int pos,char b){

    }
    //指定位置插入字符串
    public void insert(int pos,String b){

    }
    //从开始位置删除剩下的
    public void delete(int start){

    }
    //从开始位置删除结束位置-1
    public void delete(int start,int end){

    }
    //反转
    public void reverse(){

    }
    //返回长度
    public int length(){
        int len = 0;
        for(int i=0;i<value.size();i++){
            len += ((String)value.get(i)).length(); //需要强制类型转换
        }
        return len;
    }

    public String toString(){
        String str = "";
        for(int i=0;i<value.size();i++){
            str += value.get(i);
        }
        return str;
    }
}