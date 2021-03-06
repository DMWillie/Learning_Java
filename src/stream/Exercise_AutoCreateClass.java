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
        //autoCreateClass_1(f,className,type,propertyName);
        autoCreateClass_2(f,className,type,propertyName);
        //printFile(f);
        //System.out.println("文件保存在: "+f.toString());
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
    //方法二***,根据模板template.txt来替换文件内容
    private static void autoCreateClass_2(File f,String className,String type,String propertyName){
        //模板文件
        File templateFile = new File("D:/Learning_Java/src/data/template.txt");
        //将属性名的首字母大写
        Character firstChar = propertyName.toCharArray()[0];
        String upperName = propertyName.replace(firstChar,
                Character.toUpperCase(firstChar));
        try(
                FileReader fr = new FileReader(templateFile);
                BufferedReader br = new BufferedReader(fr);
                FileWriter fw = new FileWriter(f);
                PrintWriter pw = new PrintWriter(fw);
                ){
            System.out.println("替换之后的内容为: ");
            pw.println("package data;");
            String line = null;
            while((line=br.readLine())!=null){
                if(line.contains("@class@")) //replace原地替换,而是返回一个新的字符串
                    line = line.replace("@class@",className);
                if(line.contains("@type@"))
                    line = line.replace("@type@",type);
                if(line.contains("@property@"))
                    line = line.replace("@property@",propertyName);
                if(line.contains("@Uproperty@"))
                    line = line.replace("@Uproperty@",upperName);
                pw.println(line);
            }
            //printFile(f);
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            printFile(f);
            System.out.println("文件保存在: "+f.getAbsolutePath());
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
