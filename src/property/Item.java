package property;

/*  Author: 北辰
    日期: 30/11/2019
    修改日期: 01/01/2020 ,重写toString()方法
    功能: 物品类Item
 */

public class Item {
    String name;
    int price;

    public Item(){
    }
    //提供一个初始化name的构造方法
    public Item(String name){
        this.name = name;
    }
    public void effect(){
        System.out.println("物品使用后，可以有效果");
    }
    public String toString(){
        return "[Item "+name+", price="+price+"]";
    }
}
