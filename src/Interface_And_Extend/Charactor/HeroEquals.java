package Interface_And_Extend.Charactor;

/*  Author: 北辰
    日期: 16/10/2019
    功能: Hero类,测试对象的equals()方法
 */

public class HeroEquals {
    public String name;
    protected float hp;

    public boolean equals(Object o){
        if(o instanceof HeroEquals){
            HeroEquals h = (HeroEquals)o;
            return this.hp == h.hp;         //如果两个对象的hp相同那我们就认为它们相等
        }
        return false;
    }

    public static void main(String[] args) {
        HeroEquals h1= new HeroEquals();
        h1.hp = 300;
        HeroEquals h2= new HeroEquals();
        h2.hp = 400;
        HeroEquals h3= new HeroEquals();
        h3.hp = 300;

        System.out.println(h1.equals(h2));
        System.out.println(h1.equals(h3));
    }
}
