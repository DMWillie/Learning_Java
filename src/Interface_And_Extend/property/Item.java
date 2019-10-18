package Interface_And_Extend.property;

/*  Author: 北辰
    日期: 16/10/2019
    功能: Item类,重写它的toString(),finalize(),equals()方法
 */

public class Item {
    String name;
    int price;

    public Item(String name,int price){
        this.name = name;
        this.price = price;
    }
    public String toString(){
        return name+": "+price;
    }

    public void finalize(){
        System.out.println("当前对象正在被回收");
    }

    public boolean equals(Object o){
        if(o instanceof Item){
            Item h = (Item) o;
            return this.price==h.price;
        }
        return false;
    }

    public static void main(String[] args){
        Item l1 = new Item("多兰盾",500);
        Item l2 = new Item("冰霜之刃",500);
        Item l3 = new Item("复活甲",1000);

        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);

        System.out.println(l1.equals(l2));
        System.out.println(l1.equals(l3));

        //测试finalize()方法
        Item l;
        for(int i=0;i<500000;i++){
            l = new Item("",0);
        }
    }
}
