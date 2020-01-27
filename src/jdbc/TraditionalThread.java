package jdbc;

/*  Author: 北辰
    日期: 27/01/2020
    功能: 使用传统方式获取数据库连接的线程
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class TraditionalThread extends Thread{

    public TraditionalThread(String name){
        super(name);
    }
    //每一个线程单独创建数据库连接,并向数据库中插入一条数据
    @Override
    public void run(){
        Random r = new Random();
        String sql = "insert into hero values(null,?,?,?)";
        try(
               Connection c = DriverManager.getConnection(
                       "jdbc:mysql://127.0.0.1:3306/how2java?" +
                               "characterEncoding=UTF-8&autoReconnect=true&useSSL=false",
                       "root","admin");
               PreparedStatement ps = c.prepareStatement(sql)
                ){
            synchronized (c){
                ps.setString(1,"英雄"+r.nextInt());
                ps.setFloat(2,r.nextFloat()*1000);
                ps.setInt(3,r.nextInt(1000));
                ps.execute();
                System.out.println(this.getName()+":\t 获取一根连接,并插入了一条数据");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println(this.getName()+":\t 释放数据库连接");
    }
}
