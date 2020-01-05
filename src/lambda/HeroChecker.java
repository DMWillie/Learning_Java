package lambda;

/*  Author: 北辰
    日期: 05/01/2020
    功能: 接口HeroChecker，提供一个test(MyHeroCompare)方法
 */

import character.MyHeroCompare;

public interface HeroChecker {
    public boolean test(MyHeroCompare h);
}
