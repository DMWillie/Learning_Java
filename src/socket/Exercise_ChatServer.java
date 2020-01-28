package socket;

/*  Author: 北辰
    日期: 28/01/2020
    功能: 服务端既能接收数据也能发送数据,并且可以一直持续下去,服务器端
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Exercise_ChatServer {
    public static void main(String[] args) throws IOException {
        //服务端打开端口8888
        ServerSocket ss = new ServerSocket(8888);
        //在8888端口上打开监听,看是否有连接请求过来
        System.out.println("监听在端口号:8888");
        Socket s = ss.accept();
        System.out.println(s);
        //打开字节输入流
        InputStream is = s.getInputStream();
        //把输入流封装在DataInputStream
        DataInputStream dis = new DataInputStream(is);
        //使用Scanner读取控制台的输入，并发送到客户端
        Scanner sc = new Scanner(System.in);
        StringBuffer sendMsg = null;
        while(String.valueOf(sendMsg)!=null ||dis.readUTF()!=null){
            if(dis.readUTF()!=null){
                System.out.println("收到客户端信息:\t"+dis.readUTF());
            }
            sendMsg = new StringBuffer(sc.nextLine());
        }
        dis.close();
        s.close();
        ss.close();
    }
}
