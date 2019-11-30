package character;

/*
    Author: 北辰
    日期: 30/11/2019
    功能: 设计一个物理攻击英雄类继承自Hero类,并添加不同的attack()方法,使用可变参数进行重载
 */

public class ADHero extends Hero{

    public ADHero(String name){
        this.name = name;
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
}
