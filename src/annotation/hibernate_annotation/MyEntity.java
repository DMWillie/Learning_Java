package annotation.hibernate_annotation;
/*  Author: 北辰
    日期: 31/01/2020
    功能:hibernate有两种配置方式，分别是*.hbm.xml 配置方式 和注解方式。
    虽然方式不一样，但是都是用于解决如下问题
1.当前类是否实体类,hibernate_annotation.MyEntity 对应 javax.persistence.Entity
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyEntity {
}
