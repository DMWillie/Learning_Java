package Interface_And_Extend.property;

/*  Author: 北辰
    日期: 18/10/2019
    功能: 护甲类,继承自AbstractItem类,使用之后不会消失
 */

public class Armor extends AbstractItem{
    @Override
    public boolean disposable(){
        return false;
    }
}
