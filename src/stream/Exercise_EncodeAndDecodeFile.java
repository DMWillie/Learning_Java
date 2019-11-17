package stream;

/*  Author: 北辰
    日期: 17/11/2019
    功能: 准备一个文本文件(非二进制)，其中包含ASCII码的字符和中文字符。
加密方法:
public static void encodeFile(File encodingFile, File encodedFile);
在这个方法中把encodingFile的内容进行加密，然后保存到encodedFile文件中。
加密算法：
数字：
如果不是9的数字，在原来的基础上加1，比如5变成6, 3变成4
如果是9的数字，变成0
字母字符：
如果是非z字符，向右移动一个，比如d变成e, G变成H
如果是z，z->a, Z-A。
字符需要保留大小写
非字母字符
比如',&^ 保留不变，中文也保留不变

同理,解密方法
public static void decodeFile(File decodingFile, File decodedFile);
解密算法为加密算法的逆过程
 */

import java.io.*;

public class Exercise_EncodeAndDecodeFile {

    public static void main(String[] args){
        File f1 = new File("d:/lolSource.txt");
        File f2 = new File("d:/lolEncoded.txt");
        System.out.println(f1+"文件中的内容为: ");
        printFile(f1);
        encodeFile(f1,f2);      //进行文件加密
        System.out.println(f1+"加密后的内容为: ");
        printFile(f2);
    }

    //文件加密算法
    public static void encodeFile(File encodingFile,File encodedFile){
        char[] data = new char[(int)encodingFile.length()];
        try(FileReader fr=new FileReader(encodingFile);
            FileWriter fw=new FileWriter(encodedFile)){
            fr.read(data);      //将字符流读入到字符数组data中
            for(int i=0;i<data.length;i++){
                if(Character.isDigit(data[i])||Character.isLetter(data[i])){ //若为数字字符或字母字符
                    if(data[i]=='9'){
                        data[i] = '0';
                    }else if(data[i]=='z'){
                        data[i] = 'a';
                    }else if(data[i]=='Z'){
                        data[i] = 'A';
                    }else{      //将字符所对应的数字加1再转换为字符
                        data[i] = (char)((int)data[i]+1);
                    }
                }
            }
            fw.write(data);     //将加密后的文件内容写入加密文件
        }catch(IOException e){
            System.out.println("读取文件或写入文件时发生错误");
            e.printStackTrace();
        }
    }

    //打印文件内容
    public static void printFile(File f){
        try(FileReader fr = new FileReader(f)){
            char[] all = new char[(int)f.length()];
            fr.read(all);
            for(char c:all){
                System.out.print(c);
            }
            System.out.println();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
