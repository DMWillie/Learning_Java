package character;

/*  Author: 北辰
    日期: 29/12/2019
    功能: 英雄类,重写toString方法
 */

public class MyHero {
    public String name;
    public float hp;

    public int damage;

    public MyHero(){
    }
    public MyHero(String name){
        this.name = name;
    }
    public String toString(){
        return "Hero [name="+name+", hp="+hp+", damage="+damage+"]\r\n";
    }
    public MyHero(String name,int hp,int damage){
        this.name = name;
        this.hp=hp;
        this.damage = damage;
    }
}
