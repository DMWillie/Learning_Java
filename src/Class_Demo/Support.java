package Class_Demo;

/*
    Author: 北辰
    日期: 07/10/2019
    功能: 设计一个类Support (辅助英雄)继承Hero，提供一个heal(治疗)方法,对Support的heal方法进行重载
            heal()
            heal(Hero h) //为指定的英雄加血
            heal(Hero h, int hp) //为指定的英雄加了hp的血
 */
public class Support extends Hero {

    public Support(int num){
        super(num);
    }

    //治疗方法
    public void heal(){
        System.out.println(name+"使用了治疗");
    }

    //方法重载
    public void heal(Hero h){
        System.out.println(name+ "对 "+ h.name +" 进行治疗");
    }

    public void heal(Hero h,int hp){
        System.out.println(name + "对 "+ h.name +" 治疗了 " + hp +" 滴血");
        h.hp += hp;
    }

    public static void main(String[] args){
        Support nameo = new Support(2);
        nameo.name = "娜美";

        Hero garen = new Hero(1);
        garen.name = "盖伦";

        Hero teem = new Hero(2);
        teem.name = "提莫";

        nameo.heal();
        nameo.heal(garen);
        nameo.heal(teem,30);
    }
}
