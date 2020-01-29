package socket;
/*  Author: 北辰
    日期: 29/01/2020
    功能: 在练习-服务端和客户端互聊 中，只能一人说一句，说了之后，必须等待另一个人的回复，才能说下一句。
这是因为接受和发送都在主线程中，不能同时进行。 为了实现同时收发消息，基本设计思路是把收发分别放在不同的线程中进行
1.SendThread 发送消息线程
 */

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread{
    private Socket s;

    public SendThread(Socket s){
        this.s = s;
    }

    @Override
    public void run(){
        try{
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            while(true){
                System.out.println("from me: ");
                Scanner sc = new Scanner(System.in);
                String str = sc.nextLine();
                dos.writeUTF(str);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
