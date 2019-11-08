package exception;

/*  Author: 北辰
    日期: 06/11/2019
    功能: 一个英雄攻击另一个英雄的时候，如果发现另一个英雄已经挂了，就会抛出EnemyHeroIsDeadException
 */

public class EnemyHeroIsDeadException extends Throwable {
    //无参构造方法
    public EnemyHeroIsDeadException(){
    }
    //有参构造方法
    public EnemyHeroIsDeadException(String msg){
        super(msg);
    }
}
