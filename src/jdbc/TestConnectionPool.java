package jdbc;

/*  Author: 北辰
    日期: 27/01/2020
    功能: 首先初始化一个有3条连接的数据库连接池
然后创建100个线程，每个线程都会从连接池中借用连接，并且在借用之后，归还连接。
拿到连接之后，执行一个耗时1秒的SQL语句
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnectionPool {
    public static void main(String[] args) {
        ConnectionPool cp = new ConnectionPool(3);
        for(int i=0;i<100;i++){
            new WorkingThread("working thread "+i,cp).start();
        }
    }

}

class WorkingThread extends Thread{
    private ConnectionPool cp;

    public WorkingThread(String name,ConnectionPool cp){
        super(name);
        this.cp = cp;
    }

    @Override
    public void run(){
        Connection c = cp.getConnection();
        System.out.println(this.getName()+":\t 获取了一根连接,并开始工作");
        try(Statement s = c.createStatement()){
            //模拟时耗１秒的数据库SQL语句
            Thread.sleep(1000);
            s.execute("select * from hero");
        }catch(SQLException e){
            e.printStackTrace();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        //用完之后归还连接
        cp.returnConnection(c);
    }
}
