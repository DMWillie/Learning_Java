package generic;

/*  Author: 北辰
    日期: 04/01/2020
    功能: 把二叉树中的Node类，改造成支持泛型
 */

import property.Item;
import java.util.ArrayList;
import java.util.List;

public class MyNode<T extends Comparable<T>> {
    //左子节点
    public MyNode<T> leftNode;
    //右子节点
    public MyNode<T> rightNode;
    //值
    public T value;

    //插入数据
    public void add(T v){
        //如果当前节点没有值,让当前结点值为插入数据的值
        if(null==value)
            value = v;
        else{   //当前节点有值,则比较当前节点值和插入节点值的大小
            if(v.compareTo(value)<0){ //插入节点值小于等于当前节点值
                //判断左子节点是否为空
                if(null==leftNode)
                    leftNode = new MyNode<T>();  //让插入节点成为当前节点的左子节点
                leftNode.add(v);        //否则，递归在左子节点的合适位置插入
            }else{      //插入节点值大于当前节点值
                //判断右子节点是否为空
                if(null==rightNode)
                    rightNode = new MyNode<T>();  //让插入节点成为当前节点的右子节点
                rightNode.add(v);
            }
        }
    }
    //中序遍历所有的节点
    public List<T> values(){
        List<T>  values = new ArrayList<>();
        if(null!=leftNode)  //左子节点不为空
            values.addAll(leftNode.values());
        values.add(value);      //添加当前节点
        if(null!=rightNode) //右子节点不为空
            values.addAll(rightNode.values());
        return values;
    }

    public static void main(String[] args){
        int randoms[] = new int[]{67, 7, 30, 73, 10, 0, 78, 81, 10, 74};
        MyNode<Integer> roots = new MyNode<>();
        for(int number:randoms){
            roots.add(number);
        }
        System.out.println("加入10个int型数字,此二叉树中序遍历的结果如下: ");
        System.out.println(roots.values());
        System.out.println("----------------------------------");
        MyNode<Item> r = new MyNode<>();
        for(int i=0;i<10;i++){
            Item t = new Item("item "+i);
            t.price = (int)(Math.random()*100+1);
            r.add(t);
        }
        System.out.println("加入10个Item,此二叉树中序遍历的结果如下(按照价格从高到低): ");
        System.out.println(r.values());
    }
}
