package reflection;

/*  Author: 北辰
    日期: 29/01/2020
    功能: 反射中的英雄类
    为Hero增加一个静态属性,并且在静态初始化块里进行初始化
 */

public class Hero {
    public String name;
    public float hp;
    public int damage;
    public int id;
    //静态属性
    static String copyright;
    //静态初始化块
    static{
        System.out.println("初始化 copyright");
        copyright = "版权由Riot Games公司所有";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hero(){
    }
    public Hero(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        return "Hero [name="+name+"]";
    }

    public boolean isDead(){
        // TODO Auto-generated method stub
        return false;
    }

    public void attackHero(Hero h2){
        System.out.println(this.name+ " 正在攻击 " + h2.getName());
    }
}
