package Class_And_Object;

/*
    Author: 北辰
    日期: 06/10/2019
    功能: 访问对象的属性和行为
 */

public class TransferProperty {
    int i = 47;                 //定义成员变量
    public void call(){         //定义成员方法
        System.out.println("调用call()方法");
        for(i=0;i<3;i++){
            System.out.print(i+" ");
            if(i==2)
                System.out.println("\n");
        }
    }

    public TransferProperty(){          //定义构造方法
    }

    public static void main(String[] args){
        TransferProperty t1 = new TransferProperty();           //创建一个对象
        TransferProperty t2 = new TransferProperty();           //创建另一个对象
        t2.i = 60;                      //将类成员变量赋值为60
        //使用第一个对象调用类成员变量
        System.out.println("第一个实例对象调用变量i的结果是: "+t1.i++);    //打印结果为47
        t1.call();                      //使用第一个对象调用类成员方法     //打印0 1 2
        //使用第二个对象调用类成员变量
        System.out.println("第二个实例对象调用变量i的结果是: "+t2.i);      //打印结果为60
        t2.call();                      //使用第一个对象调用类成员方法     //打印0 1 2
    }
}
