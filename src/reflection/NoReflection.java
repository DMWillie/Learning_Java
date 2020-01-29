package reflection;

/*  Author: 北辰
    日期: 29/01/2020
    功能: 演示使用非反射方式从第一个业务方法doService1()切换到第二个业务方法doService2()的时候，
    必须修改代码，并且重新编译运行，才可以达到效果
 */

public class NoReflection {
    public static void main(String[] args) {
//        new Service1().doService1();
        new Service2().doService2();
    }
}
