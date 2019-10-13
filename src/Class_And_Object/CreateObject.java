package Class_And_Object;

/*
    Author: 北辰
    日期: 06/10/2019
    功能: 在Java中创建对象并调用构造方法
 */

public class CreateObject {
    public CreateObject(){                  //构造方法
        int k=1;
        System.out.println("开始创建对象");
        System.out.println("k的值为: "+k);
    }
    public static void main(String[] args){
        new CreateObject();             //创建对象
    }
}
