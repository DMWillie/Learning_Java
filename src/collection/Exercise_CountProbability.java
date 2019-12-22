package collection;

/*  Author: 北辰
    日期: 22/12/2019
    功能: 首先初始化一个List,长度是10，值是0-9。
        然后不断的shuffle，直到前3位出现
        3 1 4
        shuffle 1000,000 次，统计出现的概率
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise_CountProbability {
    public static void main(String[] args){
        List<Integer> numbers = new ArrayList<>();
        for(int i=0;i<10;i++){
            numbers.add(i);
        }
        System.out.println("初始化numbers集合为:");
        System.out.println(numbers);
        countProbability(numbers);
    }

    public static void countProbability(List<Integer> num){
        int count = 0;
        final int k = 1000000;
        for(int i=0;i<k;i++){
            Collections.shuffle(num);
            if(num.get(0)==3&&num.get(1)==1&&num.get(2)==4)
                count++;
        }
        double p = count/k;
        System.out.println(p);
        System.out.printf("混淆集合numbers%d次，前三位出现3 1 4的概率为:%f %%",k,
                p*100);
    }
}
