package Interface_And_Extend.property;

/*  Author: 北辰
    日期: 18/10/2019
    功能: AbstractItem类,有一个抽象方法public abstract boolean disposable()
    不同的子类，实现disposable后，会返回不同的值
 */

public abstract class AbstractItem {
    String name;            //名称
    int price;              //价格

    public abstract boolean disposable();
}
