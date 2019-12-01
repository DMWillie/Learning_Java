package collection;

/*  Author: 北辰
    日期: 01/12/2019
    功能: 首先初始化一个Hero集合，里面放100个Hero对象，名称分别是从
hero 0
hero 1
hero 2
...
hero 99.
通过遍历的手段，删除掉名字编号是8的倍数的对象
 */
import character.Hero;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Exercise_RemoveElements {
    public static void main(String[] args){
        List<Hero> heros = new ArrayList<>();
        //放入100个Hero对象
        for(int i=0;i<100;i++){
            heros.add(new Hero("hero "+i));
        }
        System.out.println("heros原始的元素为: \n"+heros);
        System.out.println("通过遍历的手段，删除掉名字编号是8的倍数的对象之后，heros为: ");
        for(Iterator<Hero> it = heros.iterator();it.hasNext();){
            Hero h = it.next();
            //取出每个hero的名字中所含的编号
            String numStr = h.name.split(" ")[1];
            int num = Integer.parseInt(numStr);
            if(num%8==0&&num!=0){   //删除编号是8的倍数的对象,例如hero 8,hero 16...
                /**这种写法会抛出java.util.ConcurrentModificationException异常
                 * 原因在于Iterator在对集合遍历的时候不允许对集合元素进行修改,加入了
                 * modCount == expectedModCount这个判断,如果修改了集合,那么modCount就会改变
                 * 从而modCount != expectedModCount,就会抛出java.util.ConcurrentModificationException异常
                 *
                heros.remove(h);
                 解决方法如下,用Iterator的remove()方法*/
                it.remove();
            }
        }
        System.out.println(heros);
    }
}
