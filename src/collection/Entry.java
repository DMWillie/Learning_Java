package collection;

/*  Author: 北辰
    日期: 28/12/2019
    功能: 由字符串和对象组合成的键值对Entry
 */

public class Entry {
    public Object key;
    public Object value;

    public Entry(Object key,Object value){
        super();
        this.key = key;
        this.value = value;
    }
    @Override
    public String toString(){
        return "[key="+key+", value="+value+"]";
    }
}
