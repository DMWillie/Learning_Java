package stream;

/*  Author: 北辰
    日期: 24/11/2019
    功能: System.in可以从控制台输入数据
 */

import java.io.IOException;
import java.io.InputStream;

public class TestSystemIn {
    public static void main(String[] args){
        try(InputStream is = System.in){
            while(true){
                // 敲入a,然后敲回车可以看到
                // 97  10
                // 97是a的ASCII码
                // 10对应回车换行
                int i = is.read();
                System.out.println(i);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
