package jdbc;

/*  Author: 北辰
    日期: 27/01/2020
    功能: 设计类HeroDAO，实现接口DAO
这个HeroDAO和TestORM很接近，做了几个改进：
1. 把驱动的初始化放在了构造方法HeroDAO里：
public HeroDAO() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}
因为驱动初始化只需要执行一次，所以放在这里更合适，其他方法里也不需要写了，代码更简洁
2. 提供了一个getConnection方法返回连接
所有的数据库操作都需要事先拿到一个数据库连接Connection，
以前的做法每个方法里都会写一个，如果要改动密码，那么每个地方都需要修改。
通过这种方式，只需要修改这一个地方就可以了。 代码变得更容易维护，而且也更加简洁
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroDAO implements DAO{
    //构造方法
    public HeroDAO(){
        //初始化驱动
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

    //获取数据库中的记录总数
    public int getTotal(){
        int total = 0;
        String sql = "select count(*) from hero";       //查询所有记录总条数
        try(Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql))
        {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                total = rs.getInt(1);
            }
            //System.out.println("total:" + total);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return total;
    }

    //把一个Hero对象插入到数据库中
    @Override
    public void add(Hero hero){
        String sql = "insert into hero values(null,?,?,?)";        //插入语句
        try(Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)
        ){
            //设置新插入数据的各列的值对应英雄的相应属性
            ps.setString(1,hero.name);
            ps.setFloat(2,hero.hp);
            ps.setInt(3,hero.damage);
            //执行插入语句
            ps.execute();
            //获取该插入对象的id
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                int id = rs.getInt(1);
                hero.id = id;
                System.out.println("插入一条id="+id+"的数据");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //更新一条Hero对象
    @Override
    public void update(Hero hero){
        String sql = "update hero set name=?,hp=?,damage=? where id = "+hero.id;  //更新语句
        try(Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql)
        ){
            //更新数据的各列的值对应英雄的相应属性
            ps.setString(1,hero.name);
            ps.setFloat(2,hero.hp);
            ps.setInt(3,hero.damage);
            //执行更新语句
            ps.execute();
            System.out.println("并更新到数据库");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //把一个Hero对象对应的数据删除掉
    @Override
    public void delete(Hero hero){
        String sql = "delete from hero where id = "+hero.id;        //删除语句
        try(Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql)
        ){
            //执行删除语句
            ps.execute();
            System.out.println("删除id="+hero.id+"的数据");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //根据id返回一个Hero对象
    @Override
    public Hero get(int id){
        Hero hero = null;
        try(Connection c = getConnection();
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

    //把所有的Hero数据查询出来，转换为Hero对象后，放在一个集合中返回
    @Override
    public List<Hero> list(){
        return list(0,Short.MAX_VALUE);
    }

    //分页查询,查询从id从start开始的count记录,并放入到一个集合中
    @Override
    public List<Hero> list(int start,int count){
        List<Hero> heroList = new ArrayList<Hero>();
        String sql = "select * from hero order by id desc limit ?,?";    //分页查询
        try(Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql)
        ){
            ps.setInt(1,start);
            ps.setInt(2,count);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Hero hero = new Hero();
                int id = rs.getInt("id");
                /**这里不再调用get(int id)方法,因为每次调用需要重新查询数据库,比较耗时
                 * heroList.add(get(id));
                 */
                hero.id = id;
                hero.name = rs.getString("name");
                hero.hp = rs.getFloat("hp");
                hero.damage = rs.getInt("damage");
                heroList.add(hero);      //添加hero对象到集合中
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        //System.out.printf("数据库中总共有%d 条数据%n",heroList.size());
        return heroList;
    }
}
