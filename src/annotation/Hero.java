package annotation;

/*  Author: 北辰
    日期: 29/01/2020
    功能: 演示基本内置注解
 */

public class Hero {
    String name;

    /**一.@Override 用在方法上，表示这个方法重写了父类的方法，如toString()*/
    @Override
    public String toString(){
        return name;
    }
    /**如果父类没有这个方法，那么就无法编译通过，如例所示，在fromString()方法上加上@Override 注解，
     * 就会失败，因为Hero类的父类Object，并没有fromString方法*/
    //@Override
    public String fromString(){
        return name;
    }
    /**二.@Deprecated 表示这个方法已经过期，不建议开发者使用。(暗示在将来某个不确定的版本，就有可能会取消掉)*/
    //如例所示，开地图这个方法hackMap，被注解为过期
    @Deprecated
    public void hackMap(){
    }

    /**三.@SuppressWarnings Suppress英文的意思是抑制的意思，这个注解的用处是忽略警告信息。
    比如大家使用集合的时候，有时候为了偷懒，会不写泛型，像这样：
    List heros = new ArrayList();
    那么就会导致编译器出现警告，而加上
     @SuppressWarnings({ "rawtypes", "unused" })
     就对这些警告进行了抑制，即忽略掉这些警告信息。
     @SuppressWarnings 有常见的值，分别对应如下意思
     1.deprecation：使用了不赞成使用的类或方法时的警告(使用@Deprecated使得编译器产生的警告)；
     2.unchecked：执行了未检查的转换时的警告，例如当使用集合时没有用泛型 (Generics) 来指定集合保存的类型;
     关闭编译器警告
     3.fallthrough：当 Switch 程序块直接通往下一种情况而没有 Break 时的警告;
     4.path：在类路径、源文件路径等中有不存在的路径时的警告;
     5.serial：当在可序列化的类上缺少 serialVersionUID 定义时的警告;
     6.finally：任何 finally 子句不能正常完成时的警告;
     7.rawtypes 泛型类型未指明
     8.unused 引用定义了，但是没有被使用
     9.all：关于以上所有情况的警告。*/

    /**四.@SafeVarargs 这是1.7 之后新加入的基本注解.当使用可变数量的参数的时候，而参数的类型又是泛型T的话，
     * 就会出现警告。 这个时候，就使用@SafeVarargs来去掉这个警告
     @SafeVarargs注解只能用在参数长度可变的方法或构造方法上，且方法必须声明为static或final，
     否则会出现编译错误。一个方法使用@SafeVarargs注解的前提是，
     开发人员必须确保这个方法的实现中对泛型类型参数的处理不会引发类型安全问题*/

    /**五.@FunctionalInterface这是Java1.8 新增的注解，用于约定函数式接口。
     函数式接口概念： 如果接口中只有一个抽象方法（可以包含多个默认方法或多个static方法），
     该接口称为函数式接口。函数式接口其存在的意义，主要是配合Lambda 表达式 来使用。
     */
    public static void main(String[] args) {
        new Hero().hackMap();   //在调用时IDE就会提示
    }
}
