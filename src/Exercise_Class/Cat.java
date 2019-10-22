package Exercise_Class;

/*  Author: 北辰
    日期: 22/10/2019
    功能: Cat(猫类)
 */

public class Cat extends Animal implements Pet {
    public String name;
    public Cat(String name){
        super(4);           //调用超类构造器指明所有的猫都是4条腿
        this.name = name;
    }
    //无参构造器
    public Cat(){
        this("");       //调用前一个构造器（用this关键字）并传递一个空字符串作为参数
    }
    @Override
    public String getName(){
        return this.name;
    }
    @Override
    public void setName(String name){
        this.name = name;
    }
    @Override
    public void play(){
        System.out.println(name+"在玩");
    }
    @Override
    public void eat(){
        System.out.println(name+"有"+legs+"条腿,吃鱼");
    }
}
