package stream;

/*  Author: 北辰
    日期: 23/11/2019
    功能: 设计一个方法，用于移除Java文件中的注释
public void removeComments(File javaFile)
比如，移出以//开头的注释行
File f = new File("d:/LOLFolder/LOL.exe");
System.out.println("当前文件是：" +f);
//文件是否存在
System.out.println("判断是否存在："+f.exists());
//是否是文件夹
System.out.println("判断是否是文件夹："+f.isDirectory());
注： 如果注释在后面，或者是\/**\/风格的注释暂不用处理
 */

import java.io.*;

public class Exercise_RemoveComments {

    public static void main(String[] args){
        File javaFile = new File("d:/Learning_Java/src/stream/TestRemoveCommentsFile.java");
        removeComments(javaFile);
    }

    public static void removeComments(File javaFile){
        //要写入的文件,暂时不在原文件上改
        File f = new File("d:/Learning_Java/src/data/TestRemoveCommentsFile.java");
        try(
                FileReader fr = new FileReader(javaFile);
                BufferedReader br = new BufferedReader(fr);
                FileWriter fw = new FileWriter(f);
                PrintWriter pw = new PrintWriter(fw);
                )
        {
            while(true){
                String line = br.readLine();
                if(null==line)  //如果为null,则代表到了文件末尾
                    break;
                String temp = line.trim();      //去掉某一行开头和结尾的空格
                if(temp.startsWith("//"))
                    continue;
                if(temp.startsWith("package")){
                    pw.println("package data;"); //更换包名
                }else{
                    pw.println(line);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
