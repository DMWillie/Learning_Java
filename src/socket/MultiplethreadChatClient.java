package socket;
/*  Author: 北辰
    日期: 29/01/2020
    功能: 在练习-服务端和客户端互聊 中，只能一人说一句，说了之后，必须等待另一个人的回复，才能说下一句。
这是因为接受和发送都在主线程中，不能同时进行。 为了实现同时收发消息，基本设计思路是把收发分别放在不同的线程中进行
4.Client 一旦建立了连接，就启动收发两个线程
 */

import java.io.IOException;
import java.net.Socket;

public class MultiplethreadChatClient {
    public static void main(String[] args) {
        try{
            System.out.println("试图与ip为127.0.0.1的服务器的8888端口建立连接");
            Socket s = new Socket("127.0.0.1",8888);
            //启动发送消息线程
            new SendThread(s).start();
            //启动接收消息线程
            new ReceiveThread(s).start();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
