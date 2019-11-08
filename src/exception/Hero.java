package exception;

/*  Author: 北辰
    日期: 06/11/2019
    功能: 在Hero的attack方法中，当发现敌方英雄的血量为0的时候，抛出该异常
        1. 创建一个EnemyHeroIsDeadException实例
        2. 通过throw 抛出该异常
        3. 当前方法通过 throws 抛出该异常
在外部调用attack方法的时候，就需要进行捕捉，并且捕捉的时候，可以通过e.getMessage() 获取当时出错的具体原因
 */

public class Hero {
    public String name;
    protected float hp;

    public void attackHero(Hero h) throws EnemyHeroIsDeadException{
        if(h.hp==0){
            throw new EnemyHeroIsDeadException(h.name+" 已经挂了,不需要释放技能");
        }
    }

    public String toString(){
        return name;
    }

    public static void main(String[] args){
        Hero garen = new Hero();
        garen.name = "盖伦";
        garen.hp = 616;

        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 0;

        try{
            garen.attackHero(teemo);
        }catch(EnemyHeroIsDeadException e){
            System.out.println("异常的具体原因: "+e.getMessage());
            e.printStackTrace();
        }
    }
}
