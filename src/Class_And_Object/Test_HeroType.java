package Class_And_Object;

/*  Author: 北辰
    日期: 11/10/2019
    功能: 测试英雄联盟的一些英雄类
 */

public class Test_HeroType {
    public static void main(String[] args){
        HeroType h1 = HeroType.TANK;
        HeroType h2 = HeroType.FARMING;
        for(HeroType h:HeroType.values()){
            System.out.println(h);
        }
        switch(h1){
            case TANK:
                System.out.println(h1+"为:"+"坦克");
                break;
            case WIZARD:
                System.out.println(h1+"为:"+"法师");
                break;
            case ASSASSIN:
                System.out.println(h1+"为:"+"刺客");
                break;
            case ASSIST:
                System.out.println(h1+"为:"+"辅助");
                break;
            case WARRIOR:
                System.out.println(h1+"为:"+"近战");
                break;
            case RANGED:
                System.out.println(h1+"为:"+"远程");
                break;
            case PUSH:
                System.out.println(h1+"为:"+"推进");
                break;
            case FARMING:
                System.out.println(h1+"为:"+"打野");
                break;
        }
    }
}
