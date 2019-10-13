package Interface_And_Extend;

/*  Author: 北辰
    日期: 12/10/2019
    功能: 辅助英雄类,继承自Hero类同时又实现了Healer接口
 */

import Class_And_Object.Hero;

public class Support extends Hero implements Healer {
    @Override
    public void heal(){
        System.out.println("进行治疗");
    }
    public static void main(String[] args){
        Support nama = new Support();
        nama.heal();
    }
}
