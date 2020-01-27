package jdbc;

/*  Author: 北辰
    日期: 27/01/2020
    功能: ORM=Object Relationship Database Mapping
        对象和关系数据库的映射
        简单说，一个对象，对应数据库里的一条记录
 */

import java.sql.*;

public class TestORM {
    public static void main(String[] args) {
        int id = 50;
        Hero h = get(id);
        if(h!=null)
            System.out.printf("hero name:%s\thp:%f\tdamage:%d%n",h.name,h.hp,h.damage);
        else
            System.out.println("不存在id为:"+id+"的英雄");
    }
    //根据id返回一个Hero对象
    public static Hero get(int id){
        Hero hero = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        try(
                Connection c = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                        "root","admin");
                Statement s = c.createStatement()
                ){
            String sql = "select * from hero where id = "+id;
            ResultSet rs = s.executeQuery(sql);
            // 因为id是唯一的，ResultSet最多只能有一条记录
            // 所以使用if代替while
            if(rs.next()){
                hero = new Hero();
                String name = rs.getString(2);
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                hero.name = name;
                hero.hp = hp;
                hero.damage = damage;
                hero.id = id;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return hero;
    }
}
