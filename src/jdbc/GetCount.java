package jdbc;

/*  Author: 北辰
    日期: 26/01/2020
    功能: 获取总数
        执行的sql语句为
        select count(*) from hero
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class GetCount {
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
        ) {
            String sql = "select count(*) from hero";
            //执行查询语句,并把结果集返回给ResultSet
            ResultSet rs = s.executeQuery(sql);
            int total = 0;
            while(rs.next()){
                total = rs.getInt(1);
            }
            System.out.println("表Hero中总共有:" + total+" 条数据");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
