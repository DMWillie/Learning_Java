package reflection;
/*  Author: 北辰
    日期: 29/01/2020
    功能: 通过反射修改属性的值
 */

import java.lang.reflect.Field;

public class ModifyFieldUseReflection {
    public static void main(String[] args) {
        Hero h = new Hero();
        //使用传统方式修改name的值为garen
        h.name = "gareen";
        System.out.println(h);
        try{
            //获取类Hero的名字叫做name的字段
            Field f1 = h.getClass().getDeclaredField("name");
            //修改这个字段的值
            f1.set(h,"teemo");
            //打印被修改后的值
            System.out.println(h.name);
            /**getField和getDeclaredField的区别
             这两个方法都是用于获取字段
             getField 只能获取public的，包括从父类继承来的字段。
             getDeclaredField 可以获取本类所有的字段，包括private的，但是不能获取继承来的字段。
             (注： 这里只能获取到private的字段，但并不能访问该private字段的值,
             除非加上setAccessible(true))*/
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
