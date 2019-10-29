package digitAndstring;

/*  Author: 北辰
    日期: 29/10/2019
    功能: 生成10位长度的随机字符串
        然后,先使用String的+,连接10000个随机字符串,计算消耗的时间
        然后,再使用StringBuffer连接10000个随机字符串,计算消耗的时间
 */

import digitAndstring.Exercise_RandomString;

public class Exercise_StringBuffer {

    public static void main(String[] args){
        Exercise_StringBuffer solution = new Exercise_StringBuffer();
        System.out.printf("使用字符串+的方式,连接10000次,耗时%d毫秒\n",solution.getConnectTime_String());
        System.out.printf("使用StringBuffer的方式,连接1000000次,耗时%d毫秒",solution.getConnectTime_StringBuffer());
    }

    public long getConnectTime_String(){
        //使用字符串+方式连接10000次,计算耗时
        long start = System.currentTimeMillis();
        String str = "";
        Exercise_RandomString e = new Exercise_RandomString();
        for(int i=0;i<10000;i++){
            str += e.getRandomString_2(10);
        }
        long end = System.currentTimeMillis();
        System.out.println(str);
        return end-start;
    }

    public long getConnectTime_StringBuffer(){
        //使用字符串+方式连接10000次,计算耗时
        long start = System.currentTimeMillis();
        StringBuffer str = new StringBuffer("");
        Exercise_RandomString e = new Exercise_RandomString();
        for(int i=0;i<1000000;i++){
            str.append(e.getRandomString_2(10));
        }
        long end = System.currentTimeMillis();
        System.out.println(str);
        return end-start;
    }
}
