package reflection;

/*  Author: 北辰
    日期: 29/01/2020
    功能: 演示使用反射方式从第一个业务方法doService1()切换到第二个业务方法doService2()的时候，
    首先准备一个配置文件spring.txt, 放在该包名下.里面存放的是类的名称，和要调用的方法名。
在测试类UseReflection中，首先取出类名称和方法名，然后通过反射去调用这个方法。
当需要从调用第一个业务方法，切换到调用第二个业务方法的时候，不需要修改一行代码，也不需要重新编译，
只需要修改配置文件spring.txt，再运行即可。
这也是Spring框架的最基本的原理，只是它做的更丰富，安全，健壮
 */

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

public class UseReflection {
    @SuppressWarnings({"rawtypes","unchecked"})
    public static void main(String[] args) throws Exception{
        //从spring.txt中获取类名称和方法名称
        File springConfigFile = new File("D:\\Learning_Java\\src\\reflection\\spring.txt");
        Properties springConfig = new Properties();
        springConfig.load(new FileInputStream(springConfigFile));
        String className = (String)springConfig.get("class");
        String methodName = (String)springConfig.get("method");
        //根据类名称获取类对象
        Class clazz = Class.forName(className);
        //根据方法名称，获取方法对象
        Method m = clazz.getMethod(methodName);
        //获取构造器
        Constructor c = clazz.getConstructor();
        //根据构造器，实例化出对象
        Object service = c.newInstance();
        //调用对象的指定方法
        m.invoke(service);
    }
}
