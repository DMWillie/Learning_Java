package collection;

/*  Author: 北辰
    日期: 27/11/2019
    功能: 不使用字符数组来实现MyStringBuffer,而是使用ArrayList来实现
 */

import java.util.ArrayList;

public class Exercise_MyStringBuffer {

    public static void main(String[] args){
        MyStringBuffer msb = new MyStringBuffer("there");
        System.out.println(msb);
        msb.append(" be");
        msb.append(" light");
        System.out.println(msb);
        msb.insert(0,"Let ");
        System.out.println(msb);
        msb.insert(3,'.');
        System.out.println(msb);
        msb.insert(8," a");
        System.out.println(msb);
    }
}

class MyStringBuffer{
    ArrayList value = new ArrayList();//使用ArrayList来存储字符串集合

    //构造方法,传入一个字符串
    public MyStringBuffer(String str){
        value.add(str);
    }

    //追加字符串
    public void append(String str){
        insert(length(),str);
    }
    //追加字符
    public void append(char c){
        insert(length(),String.valueOf(c));
    }
    //指定位置插入字符
    public void insert(int pos,char b){
        insert(pos,String.valueOf(b));
    }
    //指定位置插入字符串
    public void insert(int pos,String b){
        if(pos<0||pos>length()){
            System.out.println("插入位置不合法");
            return;
        }
        if(pos==length()){//在最后插入
            value.add(b);
            return;
        }
        //在中间插入
        int num = 0;        //当前总长度
        int n = value.size();   //如果直接拿value.size()当做循环终止条件
                                //那么n是会变的
        for(int i=0;i<n;i++){
            int temp = ((String)value.get(i)).length(); //当前子串的长度
            num += temp;
            if(pos>num)     //若不在当前子串的范围内
                continue;
            else if(pos==num-temp){      //在某个子串的开头位置插入
                value.add(i,b); //直接在索引为i的地方插入子串b
                break;      //插入之后就结束循环
            } else{          //在某个子串的中间位置插入
                String s1 = ((String) value.get(i)).substring(0,pos+temp-num);    //截取第一部分
                String s2 = b;      //第二部分就是字符串b
                String s3 = ((String) value.get(i)).substring(pos+temp-num,temp);//截取第三部分
                value.set(i,s1);        //位置i为第一部分
                //其余两部分插入到位置i之后
                value.add(i+1,s2);
                value.add(i+2,s3);
                break;      //插入之后就结束循环
            }
        }
    }
    //从开始位置删除剩下的
    public void delete(int start){
        delete(start,length());
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