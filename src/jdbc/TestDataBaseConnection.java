package jdbc;
/*  Author: 北辰
    日期: 26/01/2020
    功能:建立与数据库的Connection连接
这里需要提供：
数据库所处于的ip:127.0.0.1 (本机)
数据库的端口号： 3306 （mysql专用端口号）
数据库名称 how2java
编码方式 UTF-8
账号 root
密码 admin        修改数据库密码为admin的命令: set password for root@localhost = password('admin');
注： 这一步要成功执行，必须建立在mysql中有数据库how2java的基础上
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDataBaseConnection {
    public static void main(String[] args) {
        Connection c = null;
        Statement s = null;
        try{
            //初始化驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 建立与数据库的Connection连接
            // 这里需要提供：
            // 数据库所处于的ip:127.0.0.1 (本机)
            // 数据库的端口号： 3306 （mysql专用端口号）
            // 数据库名称 how2java
            // 编码方式 UTF-8
            // 账号 root
            // 密码 admin
            /**建立与数据库的连接*/
            c = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                    "root","admin");
            System.out.println("连接成功, 获取连接对象: "+c);
            /**创建Statement,Statement是用于执行SQL语句的，比如增加，删除*/
            // 注意：使用的是 java.sql.Statement
            // 不要不小心使用到： com.mysql.jdbc.Statement;
            s = c.createStatement();
            System.out.println("获取 Statement对象: "+s);
            /**执行sql语句,s.execute执行sql语句*/
            // 准备sql语句
            // 注意： 字符串要用单引号'
            String sql = "insert into hero values(null,"+"'提莫'"+","+313.0f+","+50+")";
            s.execute(sql);
            System.out.println("执行插入语句成功! ");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            // 数据库的连接是有限资源，相关操作结束后，养成关闭数据库的好习惯
            // 先关闭Statement
            if(s!=null){
                try{
                    s.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            //后关闭connection
            if(c!=null){
                try{
                    c.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }

        /**使用try-with-source的方式自动关闭连接
         * 如果觉得上一步的关闭连接的方式很麻烦，可以参考关闭流的方式
         * 使用try-with-resource的方式自动关闭连接，
         * 因为Connection和Statement都实现了AutoCloseable接口*/
        try(
                Connection c1 = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                        "root", "admin");
                Statement s1 = c1.createStatement();
                ){
            System.out.println("连接成功, 获取连接对象: "+c1);
            System.out.println("获取 Statement对象: "+s1);
            String sql = "insert into hero values(null,"+"'盖伦'"+","+428.0f+","+100+")";
            s1.execute(sql);
            System.out.println("执行插入语句成功!");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
