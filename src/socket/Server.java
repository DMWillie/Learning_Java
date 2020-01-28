package socket;

/*  Author: 北辰
    日期: 28/01/2020
    功能: 网络编程--socket,服务器端
 */

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try{
            /**第一步,建立连接*/
            //服务端打开端口8888
            ServerSocket ss = new ServerSocket(8888);
            //在8888端口上打开监听,看是否有连接请求过来
            System.out.println("监听在端口号:8888");
            Socket s = ss.accept();
            System.out.println("有连接过来"+s);
            /**第二步,收发数字*/
            //打开输入流
            InputStream is = s.getInputStream();
            //读取客户端发送的数据
            int msg = is.read();
            //打印出来
            System.out.println(msg);
            //把输入流封装在DataInputStream
            DataInputStream dis = new DataInputStream(is);
            //使用readUTF读取字符串
            String msg1 = dis.readUTF();
            System.out.println(msg1);
            String message = dis.readUTF();
            System.out.println(message);
            is.close();
            s.close();
            ss.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
