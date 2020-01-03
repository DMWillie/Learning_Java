package generic;

/*  Author: 北辰
    日期: 03/01/2020
    功能: 当需要一个只能放Item的栈的时候，就需要设计一个ItemStack
 */

import character.Hero;
import property.Item;

import java.util.LinkedList;

public class ItemStack {
    LinkedList<Item> items = new LinkedList<>();

    public void push(Item t){
        items.addLast(t);
    }
    public Item pull(){
        return items.removeLast();
    }
    public Item peek(){
        return items.getLast();
    }
    public static void main(String[] args){
        ItemStack itemStack = new ItemStack();
        for(int i=0;i<5;i++){
            Item t = new Item("item name "+i);
            System.out.println("压入 item:"+t);
            itemStack.push(t);
        }
        System.out.println();
        for(int i=0;i<5;i++){
            Item t = itemStack.pull();
            System.out.println("弹出 item:"+t);
        }
    }
}
