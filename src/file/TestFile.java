package file;

/*  Author: 北辰
    日期: 10/11/2019
    功能: 测试文件File类的一些用法
 */

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestFile {

    public static void main(String[] args) throws IOException {
        /**创建一个文件对象*/
        //绝对路径
        File f1 = new File("d:/LOLFolder");
        System.out.println("f1的绝对路径: " + f1.getAbsolutePath());
        //相对路径,相对于工作目录,如果在Eclipse中,就是项目目录
        File f2 = new File("LOL.exe");
        System.out.println("f2的绝对路径: " + f2.getAbsolutePath());
        //把f1作为父目录创建文件对象
        File f3 = new File(f1, "LOL.exe");
        System.out.println("f3的绝对路径: " + f3.getAbsolutePath());
        /**文件常用方法1*/
        File f = new File("d:/KMS10/KMS10/KMS10.exe");
        System.out.println("当前文件是: " + f);
        //文件是否存在
        System.out.println("判断是否存在: " + f.exists());
        //是否是文件夹
        System.out.println("判断是否是文件夹: " + f.isDirectory());
        //是否是文件(非文件夹)
        System.out.println("是否是文件(非文件夹):" + f.isFile());
        //文件长度
        System.out.println("获取文件的长度: " + f.length());
        //文件最后修改时间
        long time = f.lastModified();
        Date d = new Date(time);
        System.out.println("获取文件的最后修改时间: " + d);
        //设置文件最后修改时间为: 1970.1.1 08:00:00
        f.setLastModified(0);
        //文件重命名
        File ff = new File("d:/KMS/软件截图.jpg");
        File ff2 = new File("d:/KMS/KMS10截图.jpg");
        ff.renameTo(ff2);
        System.out.println("把软件截图.jpg改成了KMS10截图.jpg");
        System.out.println("注意： 需要在D:\\KMS10\\KMS10确实存在一个KMS10.exe," +
                "\r\n才可以看到对应的文件长度、修改时间等信息");
        /**文件常用方法2*/
        File file = new File("d:/LOLFolder/skin/adb.exe");
        // 以字符串数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
        System.out.println(file+"所在的文件夹下所有文件为: "); //会抛出NullPointerException异常
        for(String s: f.list()){
            System.out.println(s);
        }
        // 以文件数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
        File[] fs = f.listFiles();
        for(File subfile:fs){
            System.out.println(subfile);
        }
        //以字符串形式返回获取所在文件夹
        System.out.println("当前文件所在文件夹为: "+f.getParent());
        //以文件形式返回获取所在文件夹
        f.getParentFile();
        //创建文件夹,如果父文件夹Adb不存在,创建就无效
        f.mkdir();
        // 创建文件夹，如果父文件夹Adb不存在，就会创建父文件夹
        f.mkdirs();
        //创建一个空文件,如果父文件夹Adb不存在,就会抛出异常
        f.createNewFile();
        //所以创建一个空文件之前,通常都会创建父目录
        f.getParentFile().mkdirs();
        //列出所在的盘符 c: / d: / e:
        f.listRoots();
        //删除文件
        f.delete();
        //JVM结束的时候,删除文件,常用于临时文件的删除
        f.deleteOnExit();
    }

}
