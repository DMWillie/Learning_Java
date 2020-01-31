package annotation;
/*  Author: 北辰
    日期: 31/01/2020
    功能:@Repeatable 运用举例
    比如在练习练习-查找文件内容 中有一个要求，即查找文件后缀名是.java的文件，我们把部分代码修改为注解，
    并且使用@Repeatable 这个元注解来表示，文件后缀名的范围可以是java, html, css, js 等等。
为了紧凑起见，把注解作为内部类的形式放在一个文件里。
1. 注解FileTypes，其value()返回一个FileType数组
2. 注解FileType，其@Repeatable的值采用FileTypes
3. 运用注解：在work方法上重复使用多次@FileType注解
4. 解析注解： 在work方法内，通过反射获取到本方法上的FileType类型的注解数组，然后遍历本数组
 */

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class FindFiles {

    @Target(METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FileTypes{
        FileType[] value();
    }

    /**当没有@Repeatable修饰的时候，注解在同一个位置，只能出现一次，如例所示：
     @JDBCConfig(ip = "127.0.0.1", database = "test", encoding = "UTF-8", loginName = "root", password = "admin")
     @JDBCConfig(ip = "127.0.0.1", database = "test", encoding = "UTF-8", loginName = "root", password = "admin")
     重复做两次就会报错了。
     使用@Repeatable之后，再配合一些其他动作，就可以在同一个地方使用多次了*/
    @Target(METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(FileTypes.class)
    public @interface FileType{
        String value();
    }

    @FileType(".java")
    @FileType(".html")
    @FileType(".css")
    @FileType(".js")
    public void work(){
        try{
            FileType[] fileTypes =
                    this.getClass().getMethod("work").getAnnotationsByType(FileType.class);
            System.out.println("将从如下后缀名的文件中查找文件内容");
            for(FileType fileType:fileTypes){
                System.out.println(fileType.value());
            }
            System.out.println("查找过程略。。。");
        }catch(NoSuchMethodException | SecurityException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FindFiles().work();
    }
}
