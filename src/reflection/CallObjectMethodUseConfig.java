package reflection;

/*  Author: 北辰
    日期: 29/01/2020
    功能: 把hero.config改动成为支持如下格式：
charactor.APHero
garen
charactor.ADHero
teemo

首先根据这个配置文件，使用反射实例化出两个英雄出来。
然后通过反射给这两个英雄设置名称，接着再通过反射，调用第一个英雄的attackHero方法，攻击第二个英雄
 */

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CallObjectMethodUseConfig {
    public static void main(String[] args) {
        String fileName = "D:\\Learning_Java\\src\\reflection\\heros.config";
        List<Hero> heroList = getHero(fileName);
        callHeroMethod(heroList.get(0),"attackHero",heroList.get(1));
    }

    //根据某个配置文件中的类名及属性,反射实例化英雄并设置属性,并返回一个包含英雄的列表
    public static List<Hero> getHero(String fileName){
        //根据配置文件名获取类列表及其属性
        List<String> classList = getClassList(fileName);
        //结果列表
        List<Hero> heroList = new ArrayList<>();
        Hero h1 = createHero(classList.get(0));
        Hero h2 = createHero(classList.get(2));
        setHeroProperty(h1,"name",classList.get(1));
        //System.out.println(h1.getName());
        setHeroProperty(h2,"name",classList.get(3));
        //System.out.println(h2.getName());
        heroList.add(h1);
        heroList.add(h2);
        return heroList;
    }

    //根据文件名读取文件中的内容,并返回一个列表
    public static List<String> getClassList(String fileName){
        File f = new File(fileName);
        List<String> classList = new ArrayList<>();
        try(FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr)
        ){
            String line = null;
            while((line=br.readLine())!=null){
                classList.add(line);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return classList;
    }

    //通过反射实例化一个英雄类
    public static Hero createHero(String className){
        try{
            //获取类对象
            Class pClass = Class.forName(className);
            //获取类对象的构造器
            Constructor c = pClass.getConstructor();
            //根据构造器创建对象实例
            Hero h = (Hero)c.newInstance();
            return h;
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //通过反射设置对象的属性
    public static void setHeroProperty(Hero h,String propertyName,String value){
        try{
            //获取类Hero的名字叫做name的字段
            /**注意这里不能用getDeclaredField,因为传入的Hero若为ADHero或APHero类型,
             * 则它们都是继承Hero的属性,用getDeclaredField就获取不到继承来的属性*/
            Field f = h.getClass().getField(propertyName);
            //修改这个属性的值
            f.set(h,value);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //通过反射调用对象的方法
    public static void callHeroMethod(Hero h,String methodName,Object value){
        try{
            //获取这个名字叫做attackHero，参数类型是Hero.class的方法
            /**这里如果不设置Hero.class会报NoSuchMethodException错误,因为ADHero或APHero并没有
             * attackHero()方法*/
            Method m = h.getClass().getMethod(methodName,Hero.class);
            //对h对象,调用这个方法
            m.invoke(h,value);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
