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
        Socket client=new Socket("127.0.0.1",8888);
        System.out.println("试图与服务器 127.0.0.1的端口8888建立连接");
        System.out.println("已与服务器建立连接"+client);
        //创建输入流,输出流
        OutputStream os=client.getOutputStream();
        InputStream is=client.getInputStream();
        DataOutputStream dos = new DataOutputStream(os);
        DataInputStream dis = new DataInputStream(is);
        Scanner sc=new Scanner(System.in);
        while(true) {
            /*
             * 客户端先发送消息
             */
//            dos = new DataOutputStream(os);
            System.out.print("客户端发送: ");
            String sendMsg=sc.nextLine();
            dos.writeUTF(sendMsg);
            //退出循环的条件,客户端发送"bye"
            if("bye".equals(sendMsg)) {
                System.out.println("客户端断开连接");
                break;
            }
            /*
             * 客户端接收消息
             */
//            dis = new DataInputStream(is);
            String receiveMsg = dis.readUTF();
            System.out.println("收到服务端消息: "+receiveMsg);
            if("bye".equals(receiveMsg)) {
                System.out.println("服务端已断开连接!!!");
                break;
            }
        }
        //关闭连接
        sc.close();
        dis.close();
        dos.close();
        client.close();
        /**以下代码客户端也接收不到消息,因为客户端和服务端代码的顺序都是先接收后发送,这就造成一直在等待对方发送*/
//        //连接到本机的8888端口(服务器)
//        Socket s= new Socket("127.0.0.1",8888);
//        System.out.println(s);
//        //打开字节输出流
//        OutputStream os = s.getOutputStream();
//        //把输出流封装在DataOutputStream
//        DataOutputStream dos = new DataOutputStream(os);
//        //打开字节输入流
//        InputStream is = s.getInputStream();
//        //把输入流封装在DataInputStream
//        DataInputStream dis = new DataInputStream(is);
//        //使用Scanner读取控制台的输入，并发送到服务端
//        Scanner sc = new Scanner(System.in);
//        while(true) {
//            //接收消息
//            dis = new DataInputStream(is);
//            String receiveMsg = dis.readUTF();
//            if (receiveMsg!=null)
//                System.out.println("收到服务端信息:\t" + receiveMsg);
//            else
//                break;
//            //发送消息
//            String sendMsg = sc.nextLine();
//            dos = new DataOutputStream(os);
//            dos.writeUTF(sendMsg);
//        }
        /**以下代码都客户端都接收不到信息,只能发送*/
//        while(sendMsg!= || receiveMsg!=null){
//            if(dis.readUTF()!=null){
//                System.out.println("收到服务端信息:\t"+dis.readUTF());
//            }
//            sendMsg = new String(sc.nextLine());
//            dos.writeUTF(sendMsg);
//        }
//        dos.close();
//        dis.close();
//        s.close();
    }
}
