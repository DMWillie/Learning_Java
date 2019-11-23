package stream;

/*  Author: 北辰
    日期: 23/11/2019
    功能: 向文件中写入两个数字，然后把这两个数字分别读取出来
    要求
第一种方式： 使用缓存流把两个数字以字符串的形式写到文件里，再用缓存流以字符串的形式读取出来，然后转换为两个数字。
注：两个数字之间要有分隔符用于区分这两个数字。 比如数字是31和15，如果不使用分隔符，那么就是3115，
读取出来就无法识别到底是哪两个数字。 使用分隔符31@15能解决这个问题。
第二种方式： 使用数据流DataOutputStream向文件连续写入两个数字，然后用DataInputStream连续读取两个数字
 */

import java.io.*;

public class Exercise_WriteAndReadNum {
    private static File f = new File("d:/Learning_Java/src/data/data.txt");
    public static void main(String[] args){
        int num1=31,num2=15;
        method2(num1,num2);
    }
    //方法一:使用缓存流
    private static void method1(int num1,int num2){
        //以字符串的形式写入
        try(
                FileWriter fw = new FileWriter(f);
                PrintWriter bw = new PrintWriter(fw);
                ){
            bw.print(String.valueOf(num1));
            bw.print(String.valueOf("@"));
            bw.print(String.valueOf(num2));
        }catch(IOException e){
            e.printStackTrace();
        }
        //读出字符串并转换为整数
        try(
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                ){
            while(true){
                String line = br.readLine();
                if(null==line)
                    break;
                String temp = line.trim();
                String[] nums = temp.split("@");
                System.out.printf("数字1为:%d\n",Integer.parseInt(nums[0]));
                System.out.printf("数字2为:%d\n",Integer.parseInt(nums[1]));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    //方法二:使用数据流
    private static void method2(int num1,int num2){
        //使用DataOutputStream写入数字
        try(
                FileOutputStream fos = new FileOutputStream(f);
                DataOutputStream dos = new DataOutputStream(fos);
                ){
            dos.writeInt(num1);
            dos.writeInt(num2);
        }catch(IOException e){
            e.printStackTrace();
        }
        //使用DataInputStream读取数字
        try(
                FileInputStream fis = new FileInputStream(f);
                DataInputStream dis = new DataInputStream(fis);
                ){
            int l1 = dis.readInt();
            int l2 = dis.readInt();
            System.out.printf("数字1为:%d\n",l1);
            System.out.printf("数字2为:%d\n",l2);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
