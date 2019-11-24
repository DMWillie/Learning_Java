package Class_Demo;

/*
    Author: 北辰
    日期: 07/10/2019
    功能: 设计一个物理攻击英雄类继承自Hero类,并添加不同的attack()方法,使用可变参数进行重载
 */

public class ADHero extends Hero{
    public ADHero(int num){
        super(num);
    }
    public void attack() {
        System.out.println(name + " 进行了一次攻击 ，但是不确定打中谁了");
    }

    //方法重载,使用可变参数
    public void attack(Hero... heroes){
        for(int i=0;i<heroes.length;i++){
            System.out.println(name+" 攻击了 "+ heroes[i].name);
        }
    }

    public static void main(String[] args) {
        ADHero bh = new ADHero(1);
        bh.name = "赏金猎人";

        Hero h1 = new Hero(1);
        h1.name = "盖伦";
        Hero h2 = new Hero(2);
        h2.name = "提莫";

        bh.attack(h1);
        bh.attack(h1, h2);

    }
}
