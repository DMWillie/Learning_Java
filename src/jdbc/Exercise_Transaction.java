package jdbc;
/*  Author: 北辰
    日期: 27/01/2020
    功能:当c.setAutoCommit(false);时，事务是不会提交的
只有执行使用 c.commit(); 才会提交进行
设计一个代码，删除表中前10条数据，但是删除前会在控制台弹出一个提示：
是否要删除数据(Y/N)
如果用户输入Y，则删除
如果输入N则不删除。
如果输入的既不是Y也不是N，则重复提示
 */

import java.sql.*;
import java.util.Scanner;

public class Exercise_Transaction {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        deleteTableData("how2java","hero",10);
    }

    public static void deleteTableData(String database,String table,int n){
        /** 删除某个数据库中某个表的前n条数据
         * param: database 数据库名
         *  param: table    数据库中的表
         *  param: n        要删除的前n条数据
         * */
        String url = "jdbc:mysql://127.0.0.1:3306/%s?characterEncoding=UTF-8";
        String sql = String.format("delete from %s limit ?",table);
        try(
                Connection c = DriverManager.getConnection(String.format(url,database),
                        "root","admin");
                Statement s = c.createStatement();
                PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
                ){
            String sqlSelect  = String.format("select * from %s limit 0,%d",table,n);
            //设置事务
            c.setAutoCommit(false);
            /**要获得删除的id集合,必须先执行查询语句,而且不能放在删除语句后,否则就算没有提交,获取的id
             * 也不是准备删除id集合,而是即将删除之后的id集合*/
            ResultSet rs = s.executeQuery(sqlSelect);
            while(rs.next()){
                int id = rs.getInt(1);
                System.out.printf("试图删除id=%d 的数据%n",id);
            }
            ps.setInt(1,n);
            //执行删除语句
            ps.execute();
            /**这里不会返回任何数据,因为并没有提交,所以没有真正执行*/
//            ResultSet rs = ps.getGeneratedKeys();       //返回自增长id集合
//            while(rs.next()){
//                int id = rs.getInt(1);
//                System.out.printf("试图删除id=%d 的数据%n",id);
//            }
            Scanner input = new Scanner(System.in);
            String userChoice = null;
            boolean isDeleted = true;       //是否删除的标志
            System.out.print("是否要删除数据(Y/N)?");
            while(!((userChoice=input.nextLine()).equalsIgnoreCase("Y"))){
                if(userChoice.equalsIgnoreCase("N")){
                    isDeleted = false;      //用户选择不删除
                    break;
                }
                else
                    System.out.print("是否要删除数据(Y/N)?");
            }
            if(isDeleted){
                System.out.println("提交删除");
                c.commit();     //真正进行删除
            } else
                System.out.println("并没有删除这些数据");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
