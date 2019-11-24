package stream;

/*
    Author: 北辰
    日期: 24/11/2019
    功能: 创建一个Hero对象，设置其名称为garen
        把该对象序列化到一个文件garen.lol
        然后再通过序列化把该文件转换为一个Hero对象
注：把一个对象序列化有一个前提是：这个对象的类，必须实现了Serializable接口
 */

import Class_Demo.Hero;

import java.io.*;

public class TestObjectStream {
    public static void main(String[] args){
        //创建一个Hero garen
        //要把Hero对象直接保存在文件上,务必让Hero类实现Serialize接口
        Hero h = new Hero(1);
        h.name = "garen";
        h.hp = 616;

        //准备一个文件保存该对象
        File f = new File("D:/Learning_Java/src/data/garen.lol");
        try(
                //创建对象输出流
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                //创建对象输入流
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                ){
            oos.writeObject(h);
            Hero h2 = (Hero)ois.readObject();
            System.out.println(h2.name);
            System.out.println(h2.hp);
        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
