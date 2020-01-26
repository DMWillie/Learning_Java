package jdbc;

/*  Author: 北辰
    日期: 26/01/2020
    功能: CRUD是最常见的数据库操作，即增删改查
C 增加(Create)
R 读取查询(Retrieve)
U 更新(Update)
D 删除(Delete)
在JDBC中增加，删除，修改的操作都很类似，只是传递不同的SQL语句就行了
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestCRUD {
    public static void main(String[] args) {
        try{
            //初始化加载驱动
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        //建立数据库连接
        try(
                Connection c = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                        "root","admin");
                Statement s = c.createStatement()
                ){
            /**增加,向数据库中插入数据*/
            String addSql = "insert into hero values(null,"+"'瑞兹'"+","+332.0f+","+429+")";
            s.execute(addSql);
            /**修改*/
            String updateSql = "update hero set hp=231.0 where name='瑞兹'";
            s.execute(updateSql);
            /**删除*/
            String delSql = "delete from hero where name='瑞兹'";
            s.execute(delSql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
