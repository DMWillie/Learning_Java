package property;

/*  Author: 北辰
    日期: 30/11/2019
    修改日期: 01/01/2020 ,重写toString()方法,并实现Comparable接口,使得Item按照价格从高到低排序
    功能: 物品类Item
 */

public class Item implements Comparable<Item>{
    public String name;
    public int price;

    public Item(){
    }
    //提供一个初始化name的构造方法
    public Item(String name){
        this.name = name;
    }
    public void effect(){
        System.out.println("物品使用后，可以有效果");
    }
    @Override
    public int compareTo(Item anotherItem){
        if(price<=anotherItem.price)
            return 1;
        else
            return -1;
    }
    public String toString(){
        return "["+name+", price="+price+"]";
    }
}
