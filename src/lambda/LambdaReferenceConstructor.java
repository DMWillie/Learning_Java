package lambda;

/*  Author: 北辰
    日期: 05/01/2020
    功能: 引用构造器,有的接口中的方法会返回一个对象，比如java.util.function.Supplier提供
了一个get方法，返回一个对象。
public interface Supplier<T> {
    T get();
}
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class LambdaReferenceConstructor {
    public static void main(String[] args) {
        Supplier<List> s = new Supplier<List>() {
            @Override
            public List get() {
                return new ArrayList();
            }
        };
        //匿名类
        List list1 = getList(s);
        System.out.println("list1为: \n"+list1);
        //Lambda表达式
        List list2 = getList(()->new ArrayList());
        System.out.println("list2为: \n"+list2);
        //引用构造器
        List list3 = getList(ArrayList::new);
        System.out.println("list3为: \n"+list3);
    }

    public static List getList(Supplier<List> s){
        return s.get();
    }
}
