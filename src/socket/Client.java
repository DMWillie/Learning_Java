package socket;

/*  Author: 北辰
    日期: 28/01/2020
    功能: 网络编程--socket,客户端
 */

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try{
            /**第一步,建立连接*/
            //连接到本机的8888端口(服务器)
            Socket s = new Socket("127.0.0.1",8888);
            System.out.println(s);
            /**第二步,收发数字*/
            //打开输出流
            OutputStream os = s.getOutputStream();
            // 发送数字110到服务端
            os.write(110);
            /**收发字符串
             * 直接使用字节流收发字符串比较麻烦，使用数据流对字节流进行封装，这样收发字符串就容易了*/
            //把输出流封装在DataOutputStream中
            DataOutputStream dos = new DataOutputStream(os);
            //使用writeUTF发送字符串
            dos.writeUTF("Legendary!");
            /**使用Scanner
             * 在上个步骤中，每次要发不同的数据都需要修改代码
             * 可以使用Scanner读取控制台的输入，并发送到服务端，这样每次都可以发送不同的数据了*/
            //使用Scanner读取控制台的输入，并发送到服务端
            Scanner sc = new Scanner(System.in);
            String str = sc.next();
            dos.writeUTF(str);
            dos.close();
            os.close();
            s.close();
        }catch(UnknownHostException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
