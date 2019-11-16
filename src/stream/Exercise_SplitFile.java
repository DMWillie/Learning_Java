package stream;

/*  Author: 北辰
    日期: 16/11/2019
    功能: 找到一个大于10k的文件，按照10k为单位，拆分成多个子文件，并且以编号作为文件名结束。
        比如文件 git.exe，大小是43k。
        拆分之后，成为
        git.exe-0,大小为10240字节
        git.exe-1,大小为10240字节
        git.exe-2,大小为10240字节
        git.exe-3,大小为10240字节
        git.exe-4,大小为3072字节
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise_SplitFile {

    public static void main(String[] args){
        Exercise_SplitFile e = new Exercise_SplitFile();
        File f = new File("d:/Git/bin/git.exe");
        int unit = 10*1024; //分割单位,以10KB为单位
        e.splitFile_2(f,unit);
    }

    /**方法一:利用文件输入流的read()方法读取指定位置和长度的内容,
     * 但是read(byte b[],int offset,int len)并不是从输入流中指定的位置读取,
     * 而是将输入流读取到字节数组b指定的开始位置offset,读取长度为len字节的内容
     * 因此这里会报IndexOutOfException异常*/
    public void splitFile_1(File f,int size){
        int len = (int)f.length()/size;     //将要分割的文件数量(大小一致)
        if((int)f.length()-len*size>0)  //若分割完最后一个文件大小不是size单位
            len = len+1;            //则分割的文件数量加1
        byte[] buffer = new byte[size];  //缓冲数组,存放当前读入的字节
        File[] files = new File[len];   //写入的文件数组
        try{
            FileInputStream fis = new FileInputStream(f);//获取文件输入流
            for(int i=0;i<len;i++){
                String filename = String.format("d:/git.exe-%d",i);
                files[i] = new File(filename);
                FileOutputStream fos = new FileOutputStream(files[i]);
                if(i==len-1){
                    int remainLen = (int)(f.length()-i*size);   //最后一个文件的字节数
                    buffer = new byte[remainLen];
                    fis.read(buffer,i*size,remainLen);
                }else{
                    fis.read(buffer,i*size,size);
                }
                fos.write(buffer);          //将缓冲区的内容写入文件
                fos.close();
            }
            fis.close();
        }catch(IOException e){
            System.out.println("读取或写入文件发生错误");
        }
        for(File ff:files){
            System.out.printf(ff+"的大小是:%f 字节\n",ff.length());
        }
    }

    /**思路同方法一,但是这次是将整个源文件辅助到一个字节数组中,再从字节数组中相应的位置读取写入到新文件中*/
    public void splitFile_2(File f,int size){
        int num = (int)f.length()/size;     //将要分割的文件数量
        byte[] data = new byte[(int)f.length()];        //将文件f的字节数据缓存到一个字节数组中
        try{
            FileInputStream fis = new FileInputStream(f);//获取文件输入流
            fis.read(data);         //将文件输入流写入字节数组中
            for(int i=0;i<num;i++){
                String filename = String.format("d:/git.exe-%d",i);
                File splitFile = new File(filename);
                byte[] tmp = new byte[size];
                //将大的字节数组中的数据分段拷贝到临时数组中
                System.arraycopy(data,i*size,tmp,0,size);
                FileOutputStream fos = new FileOutputStream(splitFile);
                fos.write(tmp);
                fos.close();
                System.out.printf(splitFile.toString()+"的大小是 %d字节\n",splitFile.length());
            }
            int remainLen = (int)f.length()-num*size;
            if(remainLen>0){  //若f的长度不是size的整数倍
                File fs = new File("d:/git.exe-"+(num+1));
                FileOutputStream foo = new FileOutputStream(fs);
                foo.write(data,remainLen,remainLen);
                foo.close();
                System.out.printf(fs.toString()+"的大小是 %d字节\n",fs.length());
            }
            fis.close();
        }catch(IOException e){
            System.out.println("读取或写入文件发生错误");
            e.printStackTrace();
        }
    }
}
