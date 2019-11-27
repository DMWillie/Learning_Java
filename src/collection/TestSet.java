package collection;

/*  Author: 北辰
    日期: 27/11/2019
    功能: 测试集合类ArrayList的set方法，用于替换指定位置的元素
 */
import character.Hero;
import java.util.ArrayList;

public class TestSet {
    public static void main(String[] args){
        ArrayList heros = new ArrayList();

        // 初始化5个对象
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i));
        }
        Hero specialHero = new Hero("special hero");
        heros.add(specialHero);

        System.out.println(heros);
        System.out.println("把下标是5的元素,替换为\"hero 5\"");
        heros.set(5,new Hero("hero 5"));
        System.out.println(heros);
    }
}
