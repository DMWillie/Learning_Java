package reflection;

/*  Author: 北辰
    日期: 29/01/2020
    功能: 通过反射机制调用Hero的方法
 */

import java.lang.reflect.Method;

public class CallMethodUseReflection {
    public static void main(String[] args) {
        Hero gareen = new Hero("盖伦");
        //传统方式调用Hero的方法
        System.out.println(gareen.getName());
        try{
            //获取这个名字叫做setName，参数类型是String的方法
            Method m = gareen.getClass().getMethod("setName",String.class);
            // 对gareen对象，调用这个方法
            m.invoke(gareen,"无敌盖伦");
            System.out.println(gareen.getName());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
