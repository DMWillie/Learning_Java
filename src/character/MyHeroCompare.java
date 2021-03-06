package character;

/*  Author: 北辰
    日期: 29/12/2019
    修改日期: 06/01/2020, 添加各个属性的set和get方法
    功能: 英雄类,重写toString方法,并实现Comparable接口,在类里面提供比较算法
 */

public class MyHeroCompare implements Comparable<MyHeroCompare>{
    public String name;
    public float hp;

    public int damage;

    public MyHeroCompare(){
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

    public MyHeroCompare(String name){
        this.name = name;
    }

    public MyHeroCompare(String name,int hp,int damage){
        this.name = name;
        this.hp=hp;
        this.damage = damage;
    }

    @Override
    public int compareTo(MyHeroCompare anotherHero){
        if(damage<anotherHero.damage)
            return -1;
        else
            return 1;
    }

    public boolean matched(){
        return this.hp>100&&this.damage<50;
    }

    @Override
    public String toString(){
        return "Hero [name="+name+", hp="+hp+", damage="+damage+"]\r\n";
    }
}
