package stream;

/*  Author: 北辰
    日期: 24/11/2019
    功能: 1.复制文件是常见的IO操作，设计如下方法，实现复制源文件srcFile到目标文件destFile
public static void copyFile(String srcFile, String destFile){
}
2.复制文件夹,实现如下方法，把源文件夹下所有的文件 复制到目标文件夹下(包括子文件夹)
public static void copyFolder(String srcFolder, String destFolder){
}
3.查找文件内容
public static void search(File folder, String search);
假设你的项目目录是 d:/Learning_Java，遍历这个目录下所有的java文件（包括子文件夹），
找出文件内容包括 Magic的那些文件，并打印出来。
 */

import java.io.*;

public class ExerciseCopyFile {
    public static void main(String[] args){
        String f1 = "D:/Learning_Java/src/data/lol.txt";
        String f2 = "D:/Learning_Java/src/data/lol_copy.txt";
        copyFile(f1,f2);
        //复制文件夹
        String folder1 = "d:/Adb";
        String folder2 = "d:/Adb_copy";
        copyFolder(folder1,folder2);
        File f = new File("d:/Learning_Java");
        //寻找在d:/Learning_java文件夹中包含Magic的.java文件并打印出来
        search(f,".java","Magic");
    }
    //复制文件
    public static void copyFile(String srcFile,String destFile){
        File src = new File(srcFile);   //源文件
        File dest = new File(destFile);     //目标文件
        try(
                //读取文件到缓冲区
                FileReader fr = new FileReader(src);
                BufferedReader br = new BufferedReader(fr);
                //从缓冲区写入文件
                FileWriter fw = new FileWriter(dest);
                PrintWriter pw = new PrintWriter(fw);
                ){
            String line = null;
            while((line=br.readLine())!=null){
                pw.println(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    //复制文件夹
    public static void copyFolder(String srcFolder, String destFolder){
        /**注意这里srcFolder和destFolder都要存在*/
        File srcF = new File(srcFolder);        //源文件夹
        File destF = new File(destFolder);      //目标文件夹
        File[] list = srcF.listFiles(); //将源文件夹下的所有文件以文件列表形式返回
        for(int i=0;i<list.length;i++){
            if(list[i].isDirectory()){  //如果是文件夹
                //获取当前文件夹名
                String currentFolder = list[i].getName();
                String connectFile = destF.getAbsolutePath()+"/"+currentFolder;
                File temp = new File(connectFile);
                if(!temp.exists())
                    temp.mkdir();       //创建子文件夹
                //递归调用
                copyFolder(list[i].getAbsolutePath(),connectFile);
            }else{          //如果是文件
                String fname = destF.getAbsolutePath()+"/"+list[i].getName();
                copyFile(list[i].getAbsolutePath(),fname);
            }
        }
    }
    //遍历某个目录下(包括子文件夹)的指定后缀名的文件,找出包含指定内容的文件并打印出来
    public static void search(File folder,String suffix,String search){
        File[] list = folder.listFiles();
        for(int i=0;i<list.length;i++){
            if(list[i].isDirectory())       //遍历子文件夹
                search(list[i],suffix,search);
            String fname = list[i].getAbsolutePath();
            if(fname.endsWith(suffix)&&contains(list[i],search)){ //该文件以指定后缀名结尾
                System.out.printf("找到子目标字符串%s,在以%s为后缀的文件:%s\n"
                ,search,suffix,fname);
            }
        }
    }
    //遍历某个文件,返回是否包含指定内容
    public static boolean contains(File f,String search){
        try(
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                ){
            String line = null;
            while((line=br.readLine())!=null){
                if(line.contains(search))
                    return true;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return false;       //遍历完整个文件都没找到
    }
}
