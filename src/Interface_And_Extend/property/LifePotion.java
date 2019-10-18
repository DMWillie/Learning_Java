package Interface_And_Extend.property;

/*  Author: 北辰
    日期: 18/10/2019
    功能: 血瓶类,继承自AbstractItem类,使用之后会消失
 */

public class LifePotion extends AbstractItem{
    @Override
    public boolean disposable(){
        return true;
    }
}
