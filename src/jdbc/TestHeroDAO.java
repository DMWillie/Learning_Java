package jdbc;

/*  Author: 北辰
    日期: 27/01/2020
    功能: 测试HeroDAO类
 */

public class TestHeroDAO {
    public static void main(String[] args) {
        //新建一个HeroDAO对象
        HeroDAO heroDAO = new HeroDAO();
        //打印数据库中总共有多少条数据
        System.out.printf("数据库中总共有%d 条数据%n",heroDAO.getTotal());
        //增加一条Hero数据到数据库中
        Hero h = new Hero();
        h.name = "伊泽瑞尔";
        h.hp = 342.0f;
        h.damage = 644;
        heroDAO.add(h);
        //再次查询数据库中有多少条数据
        System.out.printf("数据库中总共有%d 条数据%n",heroDAO.getTotal());
        //取出一条记录
        System.out.print("取出id=104"+"的数据,");
        System.out.println("它的name是:\n"+heroDAO.get(104).name);
        //更改该英雄的名字,并更新到数据库
        Hero anotherHero = heroDAO.get(104);
        anotherHero.name = "英雄104";
        System.out.print("把名字改为"+anotherHero.name);
        heroDAO.update(anotherHero);
        //重新取出该英雄
        System.out.print("取出id=104"+"的数据,");
        System.out.println("它的name是:\n"+heroDAO.get(104).name);
        //删除该英雄对应的数据
        heroDAO.delete(anotherHero);
        //再次查询数据库中的数据条数
        System.out.printf("数据库中总共有%d 条数据%n",heroDAO.getTotal());
    }
}
