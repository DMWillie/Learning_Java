package jdbc;

/*  Author: 北辰
    日期: 26/01/2020
    功能: 设计一个方法，进行分页查询
public static void list(int start, int count)
start 表示开始页数，count表示一页显示的总数
list(0,5) 表示第一页，一共显示5条数据
list(10,5) 表示第三页，一共显示5条数据
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Exercise_PageQuery {
    private static Connection c;
    private static Statement s;

    //分页查询方法
    public static void list(int start,int count){
        //建立数据库连接
        try{
            c = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                    "root","admin");
            s = c.createStatement();
            String sql = "select * from hero limit "+start+","+count;
            System.out.println("id\tname\t\thp\t\tdamage");
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float hp = rs.getFloat("hp");
                int damage = rs.getInt("damage");
                System.out.printf("%d\t%s\t%f\t%d%n",id,name,hp,damage);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }finally{       //关闭Statement和数据库连接
            if(s!=null){
                try{
                    s.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(c!=null){
                try{
                    c.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        try{
            //初始化加载驱动
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        System.out.println("-------第一页数据---------");
        list(0,5);      //查询第一页数据,每页5个
        System.out.println("-------第三页数据---------");
        list(10,5);      //查询第三页数据,每页5个
        System.out.println("-------第二页数据---------");
        list(3,3);      //查询第二页数据,3
    }
}
