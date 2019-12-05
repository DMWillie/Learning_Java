package collection;

/*  Author: 北辰
    日期: 05/12/2019
    功能: 自定义接口Stack
 */

import character.Hero;

public interface Stack {
    //把英雄推入到最后位置
    public void push(Hero h);
    //把最后一个英雄取出来
    public Hero pull();
    //查看最后一个英雄
    public Hero peek();

}
