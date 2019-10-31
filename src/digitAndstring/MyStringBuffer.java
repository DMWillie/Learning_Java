package digitAndstring;

/*  Author: 北辰
    日期: 30/10/2019
    功能: MyStringBuffer实现IStringBuffer接口
 */

public class MyStringBuffer implements IStringBuffer {
    int capacity = 16;
    int length = 0;
    char[] value;
    //无参构造方法
    public MyStringBuffer() {
        value = new char[capacity];
    }
    //有参构造方法
    public MyStringBuffer(String str){
        /**方法一
        if(null!=str){
            value = str.toCharArray();
            length = value.length;

            if(capacity<length){
                capacity = length*2;
            }
        }**/
        //方法二
        this();
        if(null==str)
            return;
        if(capacity<str.length()){
            capacity = str.length()*2;
            value = new char[capacity];
        }
        if(capacity>=str.length()){
            //str.copyValueOf(value,0,str.length());
            System.arraycopy(str.toCharArray(),0,value,0,str.length());
        }
        length = str.length();
    }
    @Override
    public void append(String str) {
        // TODO Auto-generated method stub
        insert(length,str);
    }
    @Override
    public void append(char c) {
        // TODO Auto-generated method stub
    }
    @Override
    public void insert(int pos, char b) {
        // TODO Auto-generated method stub
    }
    @Override
    public void insert(int pos,String b){
        // TODO Auto-generated method stub
    }
    @Override
    public void delete(int start) {
        // TODO Auto-generated method stub
    }
    @Override
    public void delete(int start, int end) {
        // TODO Auto-generated method stub
    }
    @Override
    public void reverse() {
        for(int i=0;i<length/2;i++){
            char temp = value[i];
            value[i] = value[length-i-1];
            value[length-i-1] = temp;
        }
    }
    @Override
    public int length(){
        // TODO Auto-generated method stub
        return 0;
    }
    public String toString(){
        char[] realValue = new char[length];
        System.arraycopy(value,0,realValue,0,length);
        return new String(realValue);
    }

    public static void main(String[] args){
        MyStringBuffer sb = new MyStringBuffer("there light");
        sb.reverse();
        System.out.println(sb);
    }
}
