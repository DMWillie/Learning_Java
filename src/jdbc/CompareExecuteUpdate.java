package jdbc;

/*  Author: 北辰
    日期: 26/01/2020
    功能: 比较execute和executeUpdate语句的相同点和不同点
 */

import java.sql.*;

public class CompareExecuteUpdate {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "admin");
             Statement s = c.createStatement()) {
            String sqlInsert = "insert into Hero values (null,'盖伦',616,100)";
            String sqlDelete = "delete from Hero where id = 100";
            String sqlUpdate = "update Hero set hp = 300 where id = 100";

            // 相同点：都可以执行增加，删除，修改
            s.execute(sqlInsert);
            s.execute(sqlUpdate);
            s.execute(sqlDelete);
            s.executeUpdate(sqlInsert);
            s.executeUpdate(sqlUpdate);
            s.executeUpdate(sqlDelete);

            // 不同1：execute可以执行查询语句
            // 然后通过getResultSet，把结果集取出来
            String sqlSelect = "select * from hero where name = "+"'提莫'";
            s.execute(sqlSelect);
            ResultSet rs = s.getResultSet();
            System.out.println("使用execute语句进行查询");
            while (rs.next()) {
                System.out.println(rs.getInt("id"));
            }
            System.out.println("使用executeUpdate语句进行查询");
            // executeUpdate不能执行查询语句
            //s.executeUpdate(sqlSelect);
            //不同2:
            //execute返回boolean类型，true表示执行的是查询语句，false表示执行的是insert,delete,update等等
            //executeUpdate返回的是int，表示有多少条数据受到了影响
            boolean isSelect = s.execute(sqlSelect);
            System.out.println(isSelect);
            boolean isSelect1 = s.execute(sqlDelete);
            System.out.println(isSelect1);
            // executeUpdate返回的是int，表示有多少条数据受到了影响
            String sqlUpdate1 = "update Hero set hp=300 where id<100";
            int number = s.executeUpdate(sqlUpdate1);
            System.out.printf("执行executeUpdate语句后,%d行数据受到了影响",number);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
