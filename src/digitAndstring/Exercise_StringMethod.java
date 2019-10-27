package digitAndstring;

/*  Author: 北辰
    日期: 27/10/2019
    功能: 练习字符串的一些用法和方法
 */

import java.util.Scanner;

public class Exercise_StringMethod {
    public static void main(String[] args){
        Exercise_StringMethod e = new Exercise_StringMethod();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一句英文句子,每个单词之间用空格 隔开");
        String str = input.nextLine();
        System.out.print("该句子首字母转换为大写之后的句子为:\n");
        System.out.println(e.FirstCharacterToUpperCase(str));
        System.out.println("请输入一句英文绕口令,每个单词之间用空格 隔开");
        String str1 = input.nextLine();
        System.out.println("请输一个英文字母");
        char c = input.nextLine().charAt(0);
        System.out.printf("该绕口令中以字母%c开头的单词有:%d个",c,e.countCharFirst(str1,c));
    }

    //将英文句子中的每个单词的首字母都转换为大写
    public String FirstCharacterToUpperCase(String s){
        String[] temp = s.split(" ");
        String result = "";
        for(int i=0;i<temp.length;i++){
            char c = temp[i].charAt(0);         //取出首字母
            String sub = Character.toUpperCase(c)+temp[i].substring(1,temp[i].length());
            if(i==temp.length-1){       //如果是最后一个单词
                result += sub;
            }else{
                result += sub + " ";
            }
        }
        return result;
    }

    //统计一句英文绕口令中多少以某个字母开头的单词
    public int countCharFirst(String s,char c){
        String[] temp = s.split(" ");
        int result = 0;
        for(int i=0;i<temp.length;i++){
            if(Character.toLowerCase(temp[i].charAt(0))==c)
                result += 1;
        }
        return result;
    }
}
