package collection;

/*  Author: 北辰
    日期: 08/12/2019
    功能: 二叉树结点node类
 */

import java.util.ArrayList;
import java.util.List;

public class Node {
    //左子节点
    public Node leftNode;
    //右子节点
    public Node rightNode;
    //值
    public Object value;

    //插入数据
    public void add(Object v){
        //如果当前节点没有值,让当前结点值为插入数据的值
        if(null==value)
            value = v;
        else{   //当前节点有值,则比较当前节点值和插入节点值的大小
            if(((Integer)v-(Integer)value)<=0){ //插入节点值小于等于当前节点值
                //判断左子节点是否为空
                if(null==leftNode)
                    leftNode = new Node();  //让插入节点成为当前节点的左子节点
                leftNode.add(v);        //否则，递归在左子节点的合适位置插入
            }else{      //插入节点值大于当前节点值
                //判断右子节点是否为空
                if(null==rightNode)
                    rightNode = new Node();  //让插入节点成为当前节点的右子节点
                rightNode.add(v);
            }
        }
    }
    //中序遍历所有的节点
    public List<Object> values(){
        List<Object>  values = new ArrayList<>();
        if(null!=leftNode)  //左子节点不为空
            values.addAll(leftNode.values());
        values.add(value);      //添加当前节点
        if(null!=rightNode) //右子节点不为空
            values.addAll(rightNode.values());
        return values;
    }

    public static void main(String[] args){
        int randoms[] = new int[]{67, 7, 30, 73, 10, 0, 78, 81, 10, 74};
        Node roots = new Node();
        for(int number:randoms){
            roots.add(number);
        }
        System.out.println("此二叉树中序遍历的结果如下: ");
        System.out.println(roots.values());
    }
}
