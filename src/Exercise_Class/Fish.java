package Exercise_Class;

/*  Author: 北辰
    日期: 22/10/2019
    功能: Fish(鱼类)
 */

public class Fish extends Animal implements Pet {
    private String name;

    //无参构造方法
    public Fish(){
        super(0);
    }
    //重写Animal的walk方法以表明鱼不能走且没有腿
    @Override
    public void walk(){
        System.out.println(getName()+"不能走且没有腿");
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public void setName(String name){
        this.name = name;
    }
    @Override
    public void play(){
        System.out.println(getName()+"在玩耍");
    }

    @Override
    public void eat(){
        System.out.println(getName()+"有"+legs+"条腿,吃小鱼");
    }
}
