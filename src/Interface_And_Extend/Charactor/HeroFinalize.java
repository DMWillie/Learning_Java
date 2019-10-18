package Interface_And_Extend.Charactor;

/*  Author: 北辰
    日期: 16/10/2019
    功能: Hero类,测试对象的finalize()方法
 */

public class HeroFinalize {
    public String name;
    protected float hp;

    private static int i=0;     //类变量i记录对象被回收的次数

    public String toString(){
        return name;
    }
    public void finalize(){
        i++;
        System.out.println("这个英雄正在被回收"+i+"次");
    }
    public static void main(String[] args){
        //只有一个引用
        HeroFinalize h;
        for(int i=0;i<500000;i++){
            //不断生成新的对象
            //每创建一个对象，前一个对象，就没有引用指向了
            //那些对象，就满足垃圾回收的条件
            //当，垃圾堆积的比较多的时候，就会触发垃圾回收
            //一旦这个对象被回收，它的finalize()方法就会被调用
            h = new HeroFinalize();
        }
    }
}
