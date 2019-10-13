package Class_Demo;

/*
    Author: 北辰
    日期: 07/10/2019
    功能: 设计一个物品类
 */

public class Item {
    String name;            //物品名称
    int price;              //价格

    public static void main(String[] args){
        //实例化三件具体物品
        Item boolofbox = new Item();
        boolofbox.name = "血瓶";
        boolofbox.price = 50;

        Item grasshoes = new Item();
        grasshoes.name = "草鞋";
        grasshoes.price = 300;

        Item longsword = new Item();
        longsword.name = "长剑";
        longsword.price = 350;
    }
}
