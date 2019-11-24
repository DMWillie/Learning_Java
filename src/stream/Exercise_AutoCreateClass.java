package stream;

/*  Author: 北辰
    日期: 24/11/2019
    功能: 自动创建有一个属性的类文件。
通过控制台，获取类名，属性名称，属性类型，根据一个模板文件，自动创建这个类文件，并且为属性提供setter和getter

 */

import java.io.*;
import java.util.Scanner;

public class Exercise_AutoCreateClass {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入类的名称: ");
        String className = input.nextLine();
        System.out.println("请输入属性的类型: ");
        String type = input.nextLine();
        System.out.println("请输入属性的名称: ");
        String propertyName = input.nextLine();
        File f = new File("d:/Learning_Java/src/data/"+className+".java");
        autoCreateClass_1(f,className,type,propertyName);
        System.out.println("替换后的内容为: ");
        printFile(f);
        System.out.println("文件保存在: "+f.toString());
    }

    //根据类名,属性类型,属性名自动创建类
    private static void autoCreateClass_1(File f,String className,String type,String propertyName){
        try(
                FileWriter fw = new FileWriter(f);
                PrintWriter pw = new PrintWriter(fw);
                ){
            //首先打印包名
            pw.println("package data;");
            String tab = "  ";      //Tab键的内容
            pw.printf("public class %s {\n",className);
            pw.print(tab);
            pw.printf("public %s %s;\n",type,propertyName);
            pw.print(tab);
            pw.printf("public %s() {\n",className);
            pw.print(tab);
            pw.println("}");
            pw.print(tab);
            Character firstChar = propertyName.toCharArray()[0];
            String upperName = propertyName.replace(firstChar,
                    Character.toUpperCase(firstChar));
            pw.printf("public void set%s(%s %s){\n",upperName,type,propertyName);
            pw.print(tab);
            pw.print(tab);
            pw.printf("this.%s = %s;\n",propertyName,propertyName);
            pw.print(tab);
            pw.println("}\n");
            pw.print(tab);
            pw.printf("public %s get%s(){\n",type,upperName);
            pw.print(tab);
            pw.print(tab);
            pw.printf("return this.%s;\n",propertyName);
            pw.print(tab);
            pw.println("}");
            pw.print("}");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //打印文件内容
    public static void printFile(File f){
        try(
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                ){
            while(true){
                String line = br.readLine();
                if(null==line)
                    break;
                System.out.println(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
