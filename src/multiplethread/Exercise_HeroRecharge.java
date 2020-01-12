package multiplethread;
/*  Author: 北辰
    日期: 12/01/2020
    功能: 英雄有可以放一个技能叫做: 波动拳-a du gen。
每隔一秒钟，可以发一次，但是只能连续发3次。
发完3次之后，需要充能5秒钟，充满，再继续发。
 */
public class Exercise_HeroRecharge {
    public static void main(String[] args) {
        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 10;

        Thread t = new Thread(){
            public void run(){
                int i = 1;
                while(true){
                    if(i>3){
                        i = 1;
                        teemo.charge(5);
                        try{
                            Thread.sleep(5000); //充电5s
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }else{
                        teemo.launchSkill(i);
                        try{
                            Thread.sleep(1000); //每隔1s发动一次冲击拳
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        i++;
                    }
                }
            }
        };
        t.start();
    }
}
