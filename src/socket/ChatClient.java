package socket;

/*  Author: 北辰
    日期: 28/01/2020
    功能: 开发一个程序，当从scanner读取到消息，发给Server服务端，
    服务端用这个消息到表dictionary中找到对应的相应，返回出去。 看上去就像在自动回应一样。
    如果一个recieve有多条response，则随机返回一条
 */

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

//聊天客户端
public class ChatClient{
    public ChatClient() throws IOException{
        Socket client=new Socket("127.0.0.1",8888);
        System.out.println("试图与服务器 127.0.0.1的端口8888建立连接");
        System.out.println("已与服务器建立连接"+client);
        //创建输入流,输出流
        OutputStream os=client.getOutputStream();
        InputStream is=client.getInputStream();
        DataOutputStream dos = new DataOutputStream(os);
        DataInputStream dis = new DataInputStream(is);
        Scanner sc=new Scanner(System.in);
        System.out.println("可以开始聊天了,请发送一句话");
        while(true) {
            /*
             * 客户端先发送消息
             */
            String sendMsg=sc.nextLine();
            dos.writeUTF(sendMsg);
            //退出循环的条件,客户端发送"bye"
            if("bye".equals(sendMsg)) {
                System.out.println("聊天结束!");
                break;
            }
            /*
             * 客户端接收消息
             */
            String receiveMsg = dis.readUTF();
            System.out.println(receiveMsg);
        }
        //关闭连接
        sc.close();
        dis.close();
        dos.close();
        client.close();
    }

    public static void main(String[] args) throws IOException{
        //启动客户端
        new ChatClient();
    }
}

