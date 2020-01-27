package jdbc;

/*  Author: 北辰
    日期: 27/01/2020
    功能: ORM=Object Relationship Database Mapping
        对象和关系数据库的映射
        简单说，一个对象，对应数据库里的一条记录
ps: 在JDBC连接mysql时的URL后面加上&autoReconnect=true&useSSL=false可以消除IDE报的
Establishing SSL connection红色警告
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestORM {
    public static void main(String[] args) {
//        int id = 50;
//        Hero h = get(id);
//        if(h!=null)
//            System.out.printf("hero name:%s\thp:%f\tdamage:%d%n",h.name,h.hp,h.damage);
//        else
//            System.out.println("不存在id为:"+id+"的英雄");
        //打印数据库中总共有多少条数据
        list();
        //增加一条Hero数据到数据库中
        Hero h = new Hero();
        h.id = 1;
        h.name = "提莫";
        h.hp = 313.0f;
        h.damage = 613;
        add(h);
        //再次查询数据库中有多少条数据
        list();
        //取出一条记录
        System.out.print("取出id=100"+"的数据,");
        System.out.println("它的name是:\n"+get(100).name);
        //更改该英雄的名字,并更新到数据库
        Hero anotherHero = get(100);
        anotherHero.name = "英雄100";
        System.out.print("把名字改为"+anotherHero.name);
        update(anotherHero);
        //重新取出该英雄
        System.out.print("取出id=100"+"的数据,");
        System.out.println("它的name是:\n"+get(100).name);
        //删除该英雄对应的数据
        delete(anotherHero);
        //再次查询数据库中的数据条数
        list();
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
                        "jdbc:mysql://127.0.0.1:3306/how2java?" +
                                "characterEncoding=UTF-8&autoReconnect=true&useSSL=false",
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

    //把一个Hero对象插入到数据库中
    public static void add(Hero h){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        String sql = "insert into hero values(?,?,?,?)";        //插入语句
        try(
                Connection c = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/how2java?" +
                                "characterEncoding=UTF-8&autoReconnect=true&useSSL=false",
                        "root","admin");
                PreparedStatement ps = c.prepareStatement(sql)
        ){
            //设置新插入数据的各列的值对应英雄的相应属性
            ps.setInt(1,h.id);
            ps.setString(2,h.name);
            ps.setFloat(3,h.hp);
            ps.setInt(4,h.damage);
            //执行插入语句
            ps.execute();
            System.out.println("新加一条数据");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //把一个Hero对象对应的数据删除掉
    public static void delete(Hero h){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        String sql = "delete from hero where id = "+h.id;        //删除语句
        try(
                Connection c = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/how2java?" +
                                "characterEncoding=UTF-8&autoReconnect=true&useSSL=false",
                        "root","admin");
                PreparedStatement ps = c.prepareStatement(sql)
        ){
            //执行删除语句
            ps.execute();
            System.out.println("删除id="+h.id+"的数据");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //更新一条Hero对象
    public static void update(Hero h){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        String sql = "update hero set name=?,hp=?,damage=? where id = "+h.id;      //更新语句
        try(
                Connection c = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/how2java?" +
                                "characterEncoding=UTF-8&autoReconnect=true&useSSL=false",
                        "root","admin");
                PreparedStatement ps = c.prepareStatement(sql)
        ){
            //更新数据的各列的值对应英雄的相应属性
            ps.setString(1,h.name);
            ps.setFloat(2,h.hp);
            ps.setInt(3,h.damage);
            //执行更新语句
            ps.execute();
            System.out.println("并更新到数据库");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    //把所有的Hero数据查询出来，转换为Hero对象后，放在一个集合中返回
    public static List<Hero> list(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        List<Hero> heroList = new ArrayList<Hero>();
        String sql = "select * from hero";      //查询表中的所有数据
        try(
                Connection c = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/how2java?" +
                                "characterEncoding=UTF-8&autoReconnect=true&useSSL=false",
                        "root","admin");
                PreparedStatement ps = c.prepareStatement(sql)
        ){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                heroList.add(get(id));      //添加hero对象到集合中
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.printf("数据库中总共有%d 条数据%n",heroList.size());
        return heroList;
    }
}
