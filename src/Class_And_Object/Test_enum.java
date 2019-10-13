package Class_And_Object;

/*  Author: 北辰
    日期: 11/10/2019
    功能: 通过switch语句来测试枚举类
 */

public class Test_enum {
    public static void main(String[] args){
        Season season = Season.SPRING;
        switch(season){
            case SPRING:
                System.out.println("春天");
                break;
            case SUMMER:
                System.out.println("夏天");
                break;
            case AUTUMN:
                System.out.println("秋天");
                break;
            case WINTER:
                System.out.println("冬天");
                break;
        }
    }
}
