package exception;

/*  Author: 北辰
    日期: 08/11/2019
    功能: MyStringBuffer实现IStringBuffer接口,并判断抛出相应异常
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
    public void append(String str) throws IndexIsNegativeException,
            IndexIsOutofRangeException {
        // TODO Auto-generated method stub
        insert(length,str);
    }
    @Override
    public void append(char c) throws IndexIsNegativeException,
            IndexIsOutofRangeException{
        // TODO Auto-generated method stub
        insert(length,String.valueOf(c));
    }
    @Override
    public void insert(int pos, char b) throws IndexIsNegativeException,
            IndexIsOutofRangeException {
        // TODO Auto-generated method stub
        insert(pos,String.valueOf(b));
    }
    @Override
    public void insert(int pos,String b) throws IndexIsNegativeException,
            IndexIsOutofRangeException,NullPointerException{
        // TODO Auto-generated method stub
        if(pos<0)
            throw new IndexIsNegativeException("插入位置下标小于0");
        if(pos>length)
            throw new IndexIsOutofRangeException("插入位置下标大于当前字符串长度最大值");
        if(null==b)
            throw new NullPointerException();
        //扩容
        while(b.length()+length>capacity){
            capacity = (int)((b.length()+length)*1.5f);
            char[] newcharValue = new char[capacity];
            System.arraycopy(value,0,newcharValue,0,length);
            value = newcharValue;
        }

        char[] cs = b.toCharArray();
        //将数据右移以便新字符串插入
        System.arraycopy(value,pos,value,pos+b.length(),length-pos);
        //把要插入的数据插入到指定位置
        System.arraycopy(cs,0,value,pos,cs.length);
        length += cs.length;
    }
    @Override
    public void delete(int start) throws IndexIsNegativeException, IndexIsOutofRangeException {
        // TODO Auto-generated method stub
        delete(start,length);
    }
    @Override
    public void delete(int start, int end) throws IndexIsNegativeException, IndexIsOutofRangeException {
        // TODO Auto-generated method stub
        //边界条件判断
        if(start<0)
            throw new IndexIsNegativeException("删除下标小于0");
        if(start>length)
            throw new IndexIsOutofRangeException("删除起始下标大于最大长度");
        if(end<0)
            throw new IndexIsNegativeException("删除结束下标小于0");
        if(end>length)
            throw new IndexIsOutofRangeException("删除结束下标大于最大长度");
        if(start>=end)
            throw new IndexIsOutofRangeException("开始下标大于结束下标");

        //将后面的数据直接左移到删除的起始位置
        System.arraycopy(value,end,value,start,length-end);
        length -= end-start;
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
        return length;
    }
    public String toString(){
        char[] realValue = new char[length];
        System.arraycopy(value,0,realValue,0,length);
        return new String(realValue);
    }

    public static void main(String[] args) throws IndexIsNegativeException,
            IndexIsOutofRangeException{
        MyStringBuffer sb = new MyStringBuffer("there light");
        System.out.println(sb);
        sb.insert(-1, "let ");
        System.out.println(sb);

        sb.insert(10, "be ");
        System.out.println(sb);
        sb.insert(0, "God Say:");
        System.out.println(sb);
        sb.append("!");
        System.out.println(sb);
        sb.append('?');
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);
        sb.delete(0,4);
        System.out.println(sb);
        sb.delete(4);
        System.out.println(sb);
    }
}
