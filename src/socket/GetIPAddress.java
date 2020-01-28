package socket;

/*  Author: 北辰
    日期: 28/01/2020
    功能: 获取本机IP地址
 */

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetIPAddress {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress host = InetAddress.getLocalHost();
        String ip = host.getHostAddress();
        System.out.println("本机ip地址: "+ip);
    }
}
