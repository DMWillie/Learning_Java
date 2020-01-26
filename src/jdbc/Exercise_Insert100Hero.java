package jdbc;
/*  Author: 北辰
    日期: 26/01/2020
    功能: 借助循环,一次性向how2java数据库中插入100个Hero
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class Exercise_Insert100Hero {
    public static void main(String[] args) {
        int num = 100;      //要插入的英雄个数
        Random r = new Random();
//        String name;        //英雄名字
        float hp;           //英雄血量
        int damage;         //英雄伤害
        try{
            //初始化驱动
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        //建立数据库连接
        try(
                Connection c = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                        "root","admin"
                );Statement s = c.createStatement()
                ){
            String sql = "insert into hero values(null,"+"'英雄%s'"+","+"%s"+","+"%s)";
            for(int i=0;i<num;i++){
//                name = "hero "+(i+1);
                hp = r.nextFloat()*1000;
                damage = r.nextInt(1000);
                //必须重新声明一个字符串对象ss,否则ss赋第一个对象的值
                //String的format()方法格式化字符串并返回一个新的字符串
                String sa = String.format(sql,(i+1),hp,damage);
                //System.out.println(sa);
                //sql.format(sql,(i+1),hp,damage);
                s.execute(sa);
                System.out.println("插入一行sql语句成功");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
