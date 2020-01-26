package jdbc;

/*  Author: 北辰
    日期: 26/01/2020
    功能: 和 Statement一样，PreparedStatement也是用来执行sql语句的
与创建Statement不同的是，需要根据sql语句创建PreparedStatement
除此之外，还能够通过设置参数，指定相应的值，而不是Statement那样使用字符串拼接
 */


import java.sql.*;

public class TestPreparedStatement {
    public static void main(String[] args) {
        try{
            //初始化加载驱动
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        String sql = "insert into hero values(null,?,?,?)";
        try(
                Connection c = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                        "root","admin");
                Statement s = c.createStatement();
                PreparedStatement ps = c.prepareStatement(sql);
                ){
            /**PreparedStatement的优点1-参数设置*/
            // Statement需要进行字符串拼接，可读性和维修性比较差
            String sql0 = "insert into hero values(null," + "'提莫'" + ","
                    + 313.0f + "," + 50 + ")";
            // PreparedStatement 使用参数设置，可读性好，不易犯错
            ps.setString(1,"提莫");
            ps.setFloat(2,313.0f);
            ps.setInt(3,50);
            ps.execute();
            /**PreparedStatement的优点2-性能表现
             * PreparedStatement有预编译机制，性能比Statement更快*/
            // Statement执行100次，需要100次把SQL语句传输到数据库端
            // 数据库要对每一次来的SQL语句进行编译处理
            int num = 100;
            long st1 = System.currentTimeMillis();
            for(int i=0;i<num;i++){
                String sql1 = "insert into hero values(null," + "'提莫'" + ","
                        + 313.0f + "," + 50 + ")";
                s.execute(sql1);
            }
            long et1 = System.currentTimeMillis();
            System.out.printf("使用Statement语句插入%d次,耗时%d毫秒%n",num,et1-st1);
            // PreparedStatement 执行100次，只需要1次把SQL语句传输到数据库端
            // 数据库对带?的SQL进行预编译
            // 每次执行，只需要传输参数到数据库端
            // 1. 网络传输量比Statement更小
            // 2. 数据库不需要再进行编译，响应更快
            long st2 = System.currentTimeMillis();
            for(int i=0;i<num;i++){
                ps.setString(1, "提莫");
                ps.setFloat(2, 313.0f);
                ps.setInt(3, 50);
                ps.execute();
            }
            long et2 = System.currentTimeMillis();
            System.out.printf("使用PrepareStatement语句插入%d次,耗时%d毫秒%n",num,et2-st2);
            /**PreparedStatement的优点3-防止SQL注入式攻击*/
            // 假设name是用户提交来的数据
            String name = "'盖伦' OR 1=1";
            String sql2 = "select * from hero where name = " + name;
            System.out.println(sql2);
            // 拼接出来的SQL语句就是
            // select * from hero where name = '盖伦' OR 1=1
            // 因为有OR 1=1，所以恒成立
            // 那么就会把所有的英雄都查出来，而不只是盖伦
            // 如果Hero表里的数据是海量的，比如几百万条，把这个表里的数据全部查出来
            // 会让数据库负载变高，CPU100%，内存消耗光，响应变得极其缓慢

            ResultSet rs2 = s.executeQuery(sql2);
            while(rs2.next()){
                String heroName = rs2.getString("name");
                System.out.println(heroName);
            }
            System.out.println("----------------------------");
            // 使用预编译Statement就可以杜绝SQL注入
            String sqlPre = "select * from hero where name = ?";
            PreparedStatement ps1 = c.prepareStatement(sqlPre);
            ps1.setString(1,name);
            ResultSet rs1 = ps1.executeQuery();
            //查不出数据来
            while(rs1.next()){
                String heroName = rs1.getString("name");
                System.out.println(heroName);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
