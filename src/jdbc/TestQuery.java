package jdbc;
/*  Author: 北辰
    日期: 26/01/2020
    功能: executeQuery 执行SQL查询语句
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class TestQuery {
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
            String sql = "select * from hero";
            //执行查询语句,并把结果集返回给ResultSet
            ResultSet rs = s.executeQuery(sql);
            System.out.println("id\tname\thp\tdamage");
            while(rs.next()){
                int id = rs.getInt("id");       //可以使用字段名
                String name = rs.getString(2);  //也可以使用字段的顺序
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                System.out.printf("%d\t%s\t%f\t%d%n",id,name,hp,damage);
            }
            // 不一定要在这里关闭ReultSet，因为Statement关闭的时候，会自动关闭ResultSet
//            rs.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
