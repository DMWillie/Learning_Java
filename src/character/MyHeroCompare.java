package character;

/*  Author: 北辰
    日期: 29/12/2019
    功能: 英雄类,重写toString方法,并实现Comparable接口,在类里面提供比较算法
 */

public class MyHeroCompare implements Comparable<MyHeroCompare>{
    public String name;
    public float hp;

    public int damage;

    public MyHeroCompare(){
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

    @Override
    public String toString(){
        return "Hero [name="+name+", hp="+hp+", damage="+damage+"]\r\n";
    }
}
