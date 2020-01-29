package socket;
/*  Author: 北辰
    日期: 29/01/2020
    功能: 在练习-服务端和客户端互聊 中，只能一人说一句，说了之后，必须等待另一个人的回复，才能说下一句。
这是因为接受和发送都在主线程中，不能同时进行。 为了实现同时收发消息，基本设计思路是把收发分别放在不同的线程中进行
2.ReceiveThread 接受消息线程
 */

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ReceiveThread extends Thread{
    private Socket s;

    public ReceiveThread(Socket s){
        this.s = s;
    }

    @Override
    public void run(){
        try{
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            while(true){
                String msg = dis.readUTF();
                System.out.println("from he: "+msg);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
