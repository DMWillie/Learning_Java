package file;

/*  Author: 北辰
    日期: 10/11/2019
    功能: 遍历C:\WINDOWS目录下所有的文件(不用遍历子目录)
        找出这些文件里，最大的和最小(非0)的那个文件，打印出他们的文件名
 */

import java.io.File;

public class Exercise_TraversetFolder {
    public static void main(String[] args){
        File f = new File("c:/Windows");
        long maxLen = 0,minLen = Integer.MAX_VALUE;
        String maxLenFile = "",minLenFile="";
        File[] fs = f.listFiles();
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
        System.out.println(f+"目录下:");
        System.out.println("最大的文件是: "+maxLenFile+" 其大小为: "+maxLen+"字节");
        System.out.println("最小的文件是: "+minLenFile+" 其大小为: "+minLen+"字节");
    }
}
