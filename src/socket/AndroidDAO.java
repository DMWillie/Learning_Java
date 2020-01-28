package socket;

/*  Author: 北辰
    日期: 28/01/2020
    功能: socket编程中的AndroidDAO类,实现DAO接口,实现根据相应的消息查询相应的回复功能
    创建一个表dictionary，字段：
    id int
    receive varchar(100)
    response varchar(100)

receive 表示受到的信息
response 表示回应的信息
在这个表里准备一些数据：
你好 -> 好你妹！
你叫什么 -> 你想泡我啊？
打你哦 -> 来啊，来打我啊，不打有点挫
等等
 */

import java.sql.*;
import java.util.ArrayList;

public class AndroidDAO implements DAO{
    //初始化
    public AndroidDAO(){
        //加载数据库驱动
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    //获取数据库连接
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/how2java?" +
                        "characterEncoding=UTF-8&autoReconnect=true&useSSL=false",
                "root","admin");
    }

    //查询(根据receive查询response)
    @Override
    public String query(String receive){
        String result = null;
        String sql = "select response from dictionary where receive = ?";
        try(Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement(sql)
                ){
            ps.setString(1,receive);
            ArrayList<String> choices = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String response = rs.getString("response");
                choices.add(response);
            }
            if(!choices.isEmpty()){
                int k = choices.size();
                int random = (int)(Math.random()*k);
                result = choices.get(random);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }

//    public static void main(String[] args) {
//        AndroidDAO ado = new AndroidDAO();
//        System.out.println(ado.query("你叫什么"));
//    }
}
