package reflection;

/*  Author: 北辰
    日期: 29/01/2020
    功能: 获取类对象
    无论什么途径获取类对象，都会导致静态属性被初始化，而且只会执行一次。
   （除了直接使用 Class c = Hero.class 这种方式，这种方式不会导致静态属性被初始化）
 */

public class GetClassObject1 {
    public static void main(String[] args) {
        String className1 = "reflection.Hero";
        try{
            Class pClass11 = Class.forName(className1);
            System.out.println(pClass11);
            Class pClass12 = Hero.class;
            System.out.println(pClass12);
            Class pClass13 = new Hero().getClass();
            System.out.println(pClass13);
            System.out.println(pClass11==pClass12);
            System.out.println(pClass11==pClass13);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
