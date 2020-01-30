package annotation;

/*  Author: 北辰
    日期: 30/01/2020
    功能: 自定义注解@JDBCConfig
    把DBUtil这个类改造成为支持自定义注解的方式。 首先创建一个注解JDBCConfig
1. 创建注解类型的时候即不使用class也不使用interface,而是使用@interface
public @interface JDBCConfig
2. 元注解
@Target({METHOD,TYPE}) 表示这个注解可以用用在类/接口上，还可以用在方法上
@Retention(RetentionPolicy.RUNTIME) 表示这是一个运行时注解，即运行起来之后，
才获取注解中的相关信息，而不像基本注解如@Override 那种不用运行，在编译时eclipse就可以进行相关工作的编译时注解。
@Inherited 表示这个注解可以被子类继承
@Documented 表示当执行javadoc的时候，本注解会生成相关文档
 */

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.*;

@Target({METHOD,TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface JDBCConfig {
    /**3.注解元素，这些注解元素就用于存放注解信息，在解析的时候获取出来*/
    String ip();
    int port() default 3306;
    String database();
    String encoding();
    String loginName();
    String password();
}
