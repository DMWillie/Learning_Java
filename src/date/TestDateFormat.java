package date;

/*  Author: 北辰
    日期: 02/11/2019
    功能: 使用Java类库中的SimpleDateFormat日期格式化的用法
 */

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class TestDateFormat {

    public static void main(String[] args){
        //y 代表年
        //M 代表月
        //d 代表日
        //H 代表24进制的小时
        //h 代表12进制的小时
        //m 代表分钟
        //s 代表秒
        //S 代表毫秒
        /**日期转换为字符串
         */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        Date d = new Date();
        String str = sdf.format(d);
        System.out.println("当前时间通过 yyyy-MM-dd HH:mm:ss SSS 格式化后的输出: "+str);

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = new Date();
        String str1 = sdf1.format(d1);
        System.out.println("当前时间通过 yyyy-MM-dd格式化后的输出: "+str1+"\n");

        /**字符串转换为日期
         */
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String str2 = "2016/12/24 15:30:25";
        try{
            Date d2 =sdf2.parse(str2);
            System.out.printf("字符串 %s 通过格式  yyyy/MM/dd HH:mm:ss" +
                    "%n转换为日期对象: %s",str2,d2.toString());
        }catch(ParseException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
