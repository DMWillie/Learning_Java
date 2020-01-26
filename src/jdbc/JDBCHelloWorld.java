package jdbc;
/*  Author: 北辰
    日期: 26/01/2020
    功能:通过Class.forName("com.mysql.jdbc.Driver");
初始化驱动类com.mysql.jdbc.Driver
就在 mysql-connector-java-5.1.41-bin.jar中
//如果忘记了第一个步骤的导包，就会抛出ClassNotFoundException
Class.forName是把这个类加载到JVM中，加载的时候，就会执行其中的静态初始化块，完成驱动的初始化的相关工作
 */


public class JDBCHelloWorld {
    public static void main(String[] args) {
        //初始化驱动
        try{
            //驱动类com.mysql.jdbc.Driver
            //就在 mysql-connector-java-5.1.41-bin.jar中
            //如果忘记了第一个步骤的导包，就会抛出ClassNotFoundException
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库驱动加载成功 ！");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
