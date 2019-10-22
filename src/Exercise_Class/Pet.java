package Exercise_Class;

/*  Author: 北辰
    日期: 22/10/2019
    功能: pet（宠物）接口
 */

public interface Pet {
    //返回该宠物的名字
    public String getName();
    //为该宠物命名
    public void setName(String name);

    public void play();
}
