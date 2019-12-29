package collection;

/*  Author: 北辰
    日期: 28/12/2019
    功能: 自定义HashMap,实现接口IHashMap，MyHashMap内部由一个长度是2000的对象数组实现
 */

import java.util.LinkedList;

public class MyHashMap implements IHashMap{
    private Object[] array = new Object[2000];  //长度为2000的对象数组

    @Override
    public void put(String key,Object value){
        /**put(String key,Object value)方法,首先获取到该字符串的hashcode,
         * 然后把这个hashcode作为下标，定位到数组的指定位置
         *1.如果该位置没有数据，则把字符串和对象组合成键值对Entry，再创建一个LinkedList，
         * 把键值对，放进LinkedList中，最后把LinkedList 保存在这个位置
         *2.如果该位置有数据，一定是一个LinkedList,则把字符串和对象组合成键值对Entry，插入到LinkedList后面
         */
        int hashcode = MyHashCode.hashcode(key);
        Entry entry = new Entry(key,value);
        LinkedList<Entry> list = new LinkedList<>();
        if(array[hashcode]==null){
            list.add(entry);
            array[hashcode] = list;
        }else if(array[hashcode] instanceof LinkedList){
            //list.add(entry);
            LinkedList<Entry> ll = (LinkedList<Entry>)array[hashcode];
            ll.addLast(entry);
        }
    }

    @Override
    public Object get(String key){
        /** Object get(String key)方法,获取到该字符串的hashcode,然后把这个hashcode作为下标，
         * 定位到数组的指定位置
         *1.如果这个位置没有数据，则返回空
         *2.如果这个位置有数据，则挨个比较其中键值对的键-字符串，是否equals，
         * 找到匹配的，把键值对的值，返回出去。找不到匹配的，就返回空
         */
        int hashcode = MyHashCode.hashcode(key);
        if(array[hashcode]==null)
            return null;
        else{
            LinkedList<Entry> list = (LinkedList<Entry>)array[hashcode];
            for(Entry e:list){
                if(e.key.equals(key)){
                    return e.value;
                }
            }
        }
        return null;
    }

    public static void main(String[] args){
        MyHashMap hashMap = new MyHashMap();
        hashMap.put("sa","31");
        hashMap.put("ada","43242");
        System.out.println(hashMap.get("ada"));
    }
}