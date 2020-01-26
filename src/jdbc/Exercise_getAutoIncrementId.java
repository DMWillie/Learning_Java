package jdbc;
/*  Author: 北辰
    日期: 26/01/2020
    功能: 当插入一条数据之后，通过获取自增长id，得到这条数据的id，比如说是55.
删除这条数据的前一条，54.
如果54不存在，则删除53，以此类推直到删除上一条数据。
 */

import java.sql.*;

public class Exercise_getAutoIncrementId {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sqlInsert = "insert into hero values(null,?,?,?)";
        try (
                Connection c = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                        "root", "admin");
                //加Statement.RETURN_GENERATED_KEYS参数，以确保会返回自增长ID
                PreparedStatement ps = c.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
                Statement s = c.createStatement()
        ){
            /**在Statement通过execute或者executeUpdate执行完插入语句后，
             * MySQL会为新插入的数据分配一个自增长id，(前提是这个表的id设置为了自增长,
             * 在Mysql创建表的时候，AUTO_INCREMENT就表示自增长)*/
            ps.setString(1, "盖伦");
            ps.setFloat(2, 616);
            ps.setInt(3, 100);
            // 执行插入语句
            ps.execute();

            // 在执行完插入语句后，MySQL会为新插入的数据分配一个自增长id
            // JDBC通过getGeneratedKeys获取该id
            ResultSet rs= ps.getGeneratedKeys();
            int id = 0;
            if(rs.next()){
                id = rs.getInt(1);  //获取自增长id
                System.out.println("插入这条数据的自增长id为: "+id);
            }
            String sql = "delete from hero where id = %d";
            while(s.executeUpdate(String.format(sql,id-1))!=1 && id>1){
                id -= 1;
            }
            if(id>1)
                System.out.println("删除成功");
            else
                System.out.println("没有找到合适的数据删除");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
