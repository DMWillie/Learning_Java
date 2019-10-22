package Exercise_Class;

/*  Author: 北辰
    日期: 22/10/2019
    功能: Sipder类继承自Animal类,它调用父类构造器来指明所有蜘蛛都是8条腿
 */

public class Spider extends Animal{
    public Spider(){
        super(8);
    }

    @Override
    public void eat(){
        System.out.println("蜘蛛有"+legs+"条腿,靠吃昆虫为生");
    }
}
