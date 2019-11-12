package file;

/*  Author: 北辰
    日期: 10/11/2019
    功能: 遍历C:\WINDOWS目录下所有的文件(不用遍历子目录)
        找出这些文件里，最大的和最小(非0)的那个文件，打印出他们的文件名
 */

import java.io.File;

public class Exercise_TraversetFolder {
    private static long maxLen = 0,minLen = Integer.MAX_VALUE;
    private static String maxLenFile = "",minLenFile="";
    public static void main(String[] args){
        File f = new File("d:/DATA");
        traverseSubFile(f);
        //traverseSubFolder(f);
        System.out.println(f+"目录下(不包含子文件夹):");
        //System.out.println(f+"目录下(包含子文件夹):");
        System.out.println("最大的文件是: "+maxLenFile+" 其大小为: "+maxLen+"字节");
        System.out.println("最小的文件是: "+minLenFile+" 其大小为: "+minLen+"字节");
    }

    //获取当前目录下最大和最小的文件(不包含子文件夹)
    public static void traverseSubFile(File f){
        File[] fs = f.listFiles();      //将f下的子文件和子文件夹以文件列表形式返回
        for(int i=0;i<fs.length;i++){
            if(fs[i].isDirectory())     //排除子文件夹
                continue;
            if(fs[i].length()>maxLen){
                maxLen = fs[i].length();
                maxLenFile = fs[i].toString();
            }
            if(fs[i].length()<minLen){
                minLen = fs[i].length();
                minLenFile = fs[i].toString();
            }
        }
    }

    //获取当前目录下最大和最小的文件(包含子文件夹)
    public static void traverseSubFolder(File f){
        File[] fs = f.listFiles();      //将f下的子文件和子文件夹以文件列表形式返回
        for(int i=0;i<fs.length;i++){
            if(fs[i].isDirectory())     //如果是目录则递归调用
                traverseSubFolder(fs[i]);
            else {
                if (fs[i].length() > maxLen) {
                    maxLen = fs[i].length();
                    maxLenFile = fs[i].toString();
                }
                if (fs[i].length() < minLen) {
                    minLen = fs[i].length();
                    minLenFile = fs[i].toString();
                }
            }
        }
    }
}
