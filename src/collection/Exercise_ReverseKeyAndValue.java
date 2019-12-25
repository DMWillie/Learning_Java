package collection;

/*  Author: 北辰
    日期: 25/12/2019
    功能: 使用如下键值对，初始化一个HashMap：
adc - 物理英雄
apc - 魔法英雄
t - 坦克
对这个HashMap进行反转，key变成value,value变成key
提示： keySet()可以获取所有的key, values()可以获取所有的value
 */

import java.util.HashMap;

public class Exercise_ReverseKeyAndValue {
    public static void main(String[] args){
        HashMap<String,String> map = new HashMap<String,String>();
        //初始化map
        map.put("adc","物理英雄");
        map.put("apc","魔法英雄");
        map.put("t","坦克");
        System.out.println("反转键值对之前的map为:");
        System.out.println(map);
        //System.out.println(map.keySet());
        //System.out.println(map.values());
        System.out.println("反转键值对之后的map为:");
        System.out.println(reverseKeyAndValue(map));
    }

    public static HashMap<String,String> reverseKeyAndValue(
            HashMap<String,String> map){
        String[] keys = map.keySet().toArray(new String[map.size()]);
        for(String key:keys){   //先插入数据
            String value = map.get(key);        //根据key获取对应的value
            map.put(value,key);     //插入新的反转的键值对
            //map.remove(key);    删除原来的(会引起java.util.ConcurrentModificationException异常)
        }
        for(int i=0;i<keys.length;i++){ //后删除原来的数据
            map.remove(keys[i]);
        }
        return map;
    }
}
