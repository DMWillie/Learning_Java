package collection;

/*  Author: 北辰
    日期: 27/11/2019
    功能: 测试集合类ArrayList的size方法，用于获取ArrayList的大小
 */
import character.Hero;
import java.util.ArrayList;

public class TestSize {
    public static void main(String[] args){
        ArrayList heros = new ArrayList();

        // 初始化5个对象
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i));
        }
        Hero specialHero = new Hero("special hero");
        heros.add(specialHero);

        System.out.println(heros);
        System.out.print("获取ArrayList的大小: ");
        System.out.println(heros.size());
    }
}
