package stream;

/*
    Author: 北辰
    日期: 24/11/2019
    功能: 准备一个长度是10，类型是Hero的数组，使用10个Hero对象初始化该数组
然后把该数组序列化到一个文件heros.lol
接着使用ObjectInputStream 读取该文件，并转换为Hero数组，验证该数组中的内容，是否和序列化之前一样
 */

import Class_Demo.Hero;

import java.io.*;

public class Exercise_ObjectArraysSerial {
    public static void main(String[] args){
        Hero[] heros = new Hero[10];        //初始化每个Hero对象都为null
        System.out.println("序列化之前的数组的每一个元素为:");
        for(int i=0;i<heros.length;i++){
            heros[i] = new Hero(i);     //初始化每个英雄加序号
            System.out.println(heros[i]);
        }
        File f = new File("D:/Learning_Java/src/data/heros.lol");
        try(
                //创建文件输出流
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                //创建文件输入流
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                ){
            //将序列化对象数组写入文件中
            for(Hero h:heros){
                oos.writeObject(h);
            }
            System.out.println("查看文件中反序列化出来的数组中的每一个元素: ");
            //读取序列化数组对象
            for(int i=0;i<heros.length;i++){
                Hero h2 = (Hero)ois.readObject();
                System.out.println(h2);
            }
        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
