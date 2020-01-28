package socket;

/*  Author: 北辰
    日期: 28/01/2020
    功能: 客户端既能发送数据也能接收数据,并且可以一直持续下去,客户端
 */

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Exercise_ChatClient {
    public static void main(String[] args) throws IOException {
        //连接到本机的8888端口(服务器)
        Socket s= new Socket("127.0.0.1",8888);
        System.out.println(s);
        //打开字节输入流
        InputStream is = s.getInputStream();
        //把输入流封装在DataInputStream
        DataInputStream dis = new DataInputStream(is);
        //使用Scanner读取控制台的输入，并发送到服务端
        Scanner sc = new Scanner(System.in);
        StringBuffer sendMsg = null;
        while(String.valueOf(sendMsg)!=null || dis.readUTF()!=null){
            if(dis.readUTF()!=null){
                System.out.println("收到服务端信息:\t"+dis.readUTF());
            }
            sendMsg = new StringBuffer(sc.nextLine());
        }
        dis.close();
        s.close();
    }
}
