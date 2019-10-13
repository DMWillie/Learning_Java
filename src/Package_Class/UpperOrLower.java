package Package_Class;

/*
    Author: 北辰
    日期: 07/10/2019
    功能: 利用Character类的对象判断字符的大小写状态
 */

public class UpperOrLower {
    public static void main(String[] args){
        Character mychar1 = new Character('A');         //声明Character对象
        Character mychar2 = new Character('a');         //声明Character对象
        System.out.println(mychar1+"是大写字母吗?"
        +Character.isUpperCase(mychar1));
        System.out.println(mychar2+"是小写字母吗?"
                +Character.isLowerCase(mychar2));
    }
}
