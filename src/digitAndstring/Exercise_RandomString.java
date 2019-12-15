package digitAndstring;

/*  Author: 北辰
    日期: 26/10/2019
    功能: 创建一个长度是5的随机字符串，随机字符有可能是数字，大写字母或者小写字母
 */

public class Exercise_RandomString {
    public static void main(String[] args){
        Exercise_RandomString e = new Exercise_RandomString();
        System.out.println(e.getRandomString_2(5));
    }
    /**
     * 生成指定长度的随机字符串(只包含数字,大写字母和小写字母)
     */
    public String getRandomString_1(int n){
        //方法一
        char[] charArray = new char[n];
        for(int i=0;i<charArray.length;i++){
            int randomUppercase = (int)(Math.random()*26 + 65);   //A-Z的ASCII范围为65-90
            int randomLowercase = (int)(Math.random()*26 + 97);   //a-z的ASCII范围为97-122
            int randomDigit = (int)(Math.random()*10 + 48);   //0-9的ASCII范围为48-57
            int randomchoice = (int)(Math.random()*3 + 1); //这里用randomchoice选择每个字符是
            //大写字母，小写字母还是数字
            switch(randomchoice){
                case 1:
                    charArray[i] = (char)randomUppercase;
                    break;
                case 2:
                    charArray[i] = (char)randomLowercase;
                    break;
                case 3:
                    charArray[i] = (char)randomDigit;
                    break;
            }
        }
        String str = new String(charArray);
        //System.out.println(str);
        return str;
    }
    public String getRandomString_2(int n){
        //方法二
        //由于大写字母、小写字母、数字的ascii值不是连续的值，所以建立一个表来对应值
        short[] table = new short[62];
        for(int i=0;i<table.length;i++){
            if(i<10){           //存储0-9
                table[i] = (short)(48+i);   //48+i一定要加括号,否则会报错
            }
            else if(i<36){          //存储A-Z
                table[i] = (short)(45+i);
            }else{                  //存储a-z
                table[i] = (short)(61+i);
            }
        }
//        for(short j:table){
//            System.out.print(j+"\t");
//        }
        char[] charArray = new char[n];
        int s;
        for(int i=0;i<n;i++){
            s = (int)(Math.random()*table.length);  //不加两个括号会每次生成0
            //System.out.println(s);
            charArray[i] = (char)table[s];
        }
        return String.valueOf(charArray);
    }
}
