package jdbc;

/*  Author: 北辰
    日期: 27/01/2020
    功能: 使用数据库连接池方式获取数据库连接的线程
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class ConnectionPoolThread extends Thread{
    private ConnectionPool cp;

    public ConnectionPoolThread(String name,ConnectionPool cp){
        super(name);
        this.cp = cp;
    }

    @Override
    public void run(){
        Random r = new Random();
        String sql = "insert into hero values(null,?,?,?)";
        Connection c = cp.getConnection();
        try(PreparedStatement ps = c.prepareStatement(sql)){
            ps.setString(1,"英雄"+r.nextInt());
            ps.setFloat(2,r.nextFloat()*1000);
            ps.setInt(3,r.nextInt(1000));
            ps.execute();
            System.out.println(this.getName()+":\t 获取一根连接,并插入了一条数据");
        }catch(SQLException e){
            e.printStackTrace();
        }
        //用完之后归还连接
        cp.returnConnection(c);
        System.out.println(this.getName()+":\t 释放数据库连接");
    }
}
