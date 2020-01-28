package socket;
/*  Author: 北辰
    日期: 28/01/2020
    功能: 聊天机器人服务端
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class ChatServer{
    public ChatServer(AndroidDAO androidDAO) throws IOException {
        //服务端监听在8888端口
        ServerSocket server = new ServerSocket(8888);
        System.out.println("服务器监听在8888端口");
        Socket s = server.accept();
        System.out.println("接收到连接请求 "+s);
        //创建输入,输出流
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();
        DataInputStream dis = new DataInputStream(is);
        DataOutputStream dos = new DataOutputStream(os);
        while(true) {
            /*
             * 服务端接收消息
             */
            String receiveMsg = dis.readUTF();
            System.out.println("收到客户端消息: "+receiveMsg);
            if("bye".equals(receiveMsg)) {
                System.out.println("客户端已断开连接!!!");
                break;
            }
            /*
             * 服务端根据接收到的消息查询数据库中相应的回复进行发送
             */
            String sendMsg = androidDAO.query(receiveMsg);
            if(sendMsg==null){
                sendMsg = "我不懂你在说什么,请换一个试试^-^";
            }
            dos.writeUTF(sendMsg);
            System.out.println("服务端发送: "+sendMsg);
        }
        dis.close();
        s.close();
        server.close();
    }

    public static void main(String[] args) throws IOException {
        AndroidDAO androidDAO = new AndroidDAO();
        //先启动服务端
        new ChatServer(androidDAO);
    }
}
