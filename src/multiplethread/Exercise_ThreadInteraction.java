package multiplethread;

/*  Author: 北辰
    日期: 18/01/2020
    功能: 假设加血线程运行得更加频繁，英雄的最大血量是1000
设计加血线程和减血线程的交互，让回血回满之后，加血线程等待，直到有减血线程减血;
同时英雄血量为1时,减血线程等待,直到加血线程加血
 */

public class Exercise_ThreadInteraction {
    public static void main(String[] args) {
        final MyHero gareen = new MyHero();
        gareen.name = "盖伦";
        gareen.hp = 500;

//        Thread[] addThreads = new Thread[2];    //2条回血线程
//        Thread[] reduceThreads = new Thread[5]; //5条减血线程

        //加血线程
//        for(int i=0;i<addThreads.length;i++){
            Thread t1 = new Thread(){
                public void run(){
                    while(true){
                        gareen.recovery();
                        try{
                            //设置休眠时间比减血线程短,让加血线程运行得更频繁
                            Thread.sleep(10);
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            };
            t1.start();
//            addThreads[i] = t1;
//        }

        //减血线程
//        for(int i=0;i<reduceThreads.length;i++){
            Thread t2 = new Thread(){
                public void run(){
                    while(true){
                        gareen.hurt();
                        try{
                            Thread.sleep(100);
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            };
            t2.start();
//            reduceThreads[i] = t2;
//        }
//        for(int i=0;i<addThreads.length;i++){
//            try{
//                addThreads[i].join();
//            }catch(InterruptedException e){
//                e.printStackTrace();
//            }
//        }
//        for(int i=0;i<reduceThreads.length;i++){
//            try{
//                reduceThreads[i].join();
//            }catch(InterruptedException e){
//                e.printStackTrace();
//            }
//        }
    }
}
