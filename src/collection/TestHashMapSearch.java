package collection;

/*  Author: 北辰
    日期: 27/12/2019
    功能: 假设在List中存放着无重复名称，没有顺序的2000000个Hero
要把名字叫做“hero 1000000”的对象找出来
使用HashMap 做同样的查找
1. 初始化2000000个对象到HashMap中。
2. 进行10次查询
3. 统计每一次的查询消耗的时间
可以观察到，几乎不花时间，花费的时间在1毫秒以内
 */

import character.Hero;
import java.util.HashMap;

public class TestHashMapSearch {
    public static void main(String[] args){
        HashMap<String,Hero> heroMap = new HashMap<>();
        //初始化
        for(int j=0;j<2000000;j++){
            Hero h = new Hero("hero "+j);
            heroMap.put(h.name,h);
        }

        for(int i=0;i<10;i++){
            //因为HashMap不属于集合Collections,所以不能用Collections的shuffle方法打乱
            long start = System.currentTimeMillis();
            //查找名字是hero 1000000的对象
            Hero target = heroMap.get("hero 1000000");
            if(null!=target){
                System.out.printf("找到了%s!%n",target.name);

                long end = System.currentTimeMillis();
                long elapsed = end - start;
                System.out.printf("第%d次查找，总共花了%d毫秒%n",i+1,elapsed);
            }
        }
    }
}
