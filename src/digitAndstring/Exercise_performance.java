package digitAndstring;

/*  Author: 北辰
    日期: 01/11/2019
    功能: 使用Java自带的 StringBuffer 和 这个我们自己开发的MyStringBuffer性能比较。
        参考比较方案:
        1. 生成长度是10的随机字符串
        2. 使用StringBuffer追加1000000次统计时间
        3. 使用MyStringBuffer追加1000000次统计时间
 */

public class Exercise_performance {
    public static void main(String[] args){
        Exercise_performance solution = new Exercise_performance();
        System.out.printf("使用StringBuffer追加1000000次的时间为: %d毫秒\n",
                solution.getStringBufferTime());
        System.out.printf("使用MyStringBuffer追加1000000次的时间为: %d毫秒",
                solution.getMyStringBufferTime());
    }

    //使用StringBuffer追加1000000次统计时间
    public long getStringBufferTime(){
        long start = System.currentTimeMillis();
        Exercise_RandomString e1 = new Exercise_RandomString();
        StringBuffer str = new StringBuffer("");
        for(int i=0;i<1000000;i++){
            str.append(e1.getRandomString_2(10));
        }
        long end = System.currentTimeMillis();
        return end-start;
    }

    //使用MyStringBuffer追加1000000次统计时间
    public long getMyStringBufferTime(){
        long start = System.currentTimeMillis();
        Exercise_RandomString e1 = new Exercise_RandomString();
        MyStringBuffer str = new MyStringBuffer("");
        for(int i=0;i<1000000;i++){
            str.append(e1.getRandomString_2(10));
        }
        long end = System.currentTimeMillis();
        return end-start;
    }
}
