package reflection;
/*  Author: 北辰
    日期: 29/01/2020
    功能: 通过配置文件获取对象
    首先准备一个文本文件：hero.config。 在这个文件中保存类的全名称，
    可以是charactor.APHero 或者是charactor.ADHero
接着设计一个方法叫做：
public static Hero getHero()
在这个方法中，读取hero.config的数据，取出其中的类名，根据类名实例化出对象，然后返回对象。
 */

import java.io.*;
import java.lang.reflect.Constructor;
import Interface_And_Extend.Hero;

public class GetObjectUseConfig {
    public static void main(String[] args) {
        String fileName = "D:\\Learning_Java\\src\\reflection\\hero.config";
        Hero h = getHero(fileName);
        System.out.println(h);
    }
    //根据某个配置文件中的类名称获取该对象
    public static Hero getHero(String fileName){
        String className = getClassName(fileName);
        if(className==null){
            System.out.println("没有获取到任何类,请检查"+fileName+"文件中的配置是否正确");
        }
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
    //根据文件名读取文件中的类全名
    public static String getClassName(String fileName){
        File f = new File(fileName);
        String result = null;
        try(FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr)
        ){
            String line = null;
            while((line=br.readLine())!=null){
                result = line.toString();
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return result;
    }
}
