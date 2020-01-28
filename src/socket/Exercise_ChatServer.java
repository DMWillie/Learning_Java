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
        ServerSocket server=new ServerSocket(8888);
        System.out.println("正在监听端口8888");
        Socket socket=server.accept();
        System.out.println("接收到连接请求 "+socket);
        //创建输入输出流
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();
        DataOutputStream dos = new DataOutputStream(os);
        DataInputStream dis = new DataInputStream(is);
        Scanner sc=new Scanner(System.in);
        while(true) {
            /*
             * 接收消息
             */
//            dis = new DataInputStream(is);
            String receiveMsg = dis.readUTF();
            System.out.println("收到客户端消息: "+receiveMsg);
            if("bye".equals(receiveMsg)) {
                System.out.println("客户端已断开连接!!!");
                break;
            }

            /*
             * 发送消息
             */
//            dos = new DataOutputStream(os);
            System.out.print("服务端发送消息: ");
            String sendMsg = sc.nextLine();
            dos.writeUTF(sendMsg);
            if("bye".equals(sendMsg)) {
                System.out.println("服务端断开连接");
                break;
            }
        }
        sc.close();
        dis.close();
        dos.close();
        socket.close();
        server.close();
        /**以下代码服务端收不到任何消息,只能发送消息,因为客户端与服务端的代码顺序一致,都是先接收消息*/
//        //服务端打开端口8888
//        ServerSocket ss = new ServerSocket(8888);
//        //在8888端口上打开监听,看是否有连接请求过来
//        System.out.println("监听在端口号:8888");
//        Socket s = ss.accept();
//        System.out.println(s);
//        //打开字节输入流
//        InputStream is = s.getInputStream();
//        //把输入流封装在DataInputStream
//        DataInputStream dis = new DataInputStream(is);
//        //打开字节输出流
//        OutputStream os = s.getOutputStream();
//        //把输出流封装在DataOutputStream
//        DataOutputStream dos = new DataOutputStream(os);
//        //使用Scanner读取控制台的输入，并发送到客户端
//        Scanner sc = new Scanner(System.in);
//        while(true) {
//            //接收消息
//            dis = new DataInputStream(is);
//            String receiveMsg = dis.readUTF();
//            if (receiveMsg!=null)
//                System.out.println("收到客户端信息:\t" + receiveMsg);
//            else
//                break;
//            //发送消息
//            String sendMsg = sc.nextLine();
//            dos = new DataOutputStream(os);
//            dos.writeUTF(sendMsg);
//        }
        /**以下代码服务端收不到任何消息,只能发送消息*/
//        System.out.println(dis.readUTF());
//        while(sendMsg!=null || dis.readUTF()!=null){
//            if(dis.readUTF()!=null){
//                System.out.println("收到客户端信息:\t"+dis.readUTF());
//            }
//            sendMsg = new String(sc.nextLine());
//            dos.writeUTF(sendMsg);
//        }
//        dos.close();
//        dis.close();
//        s.close();
//        ss.close();
    }
}
