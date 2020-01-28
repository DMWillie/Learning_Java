package socket;

/*  Author: 北辰
    日期: 28/01/2020
    功能: 判断本网段有多少可用的ip地址
    首先获取 获取本机IP地址，比如说是192.168.2.100。 那么本网段的ip地址就是
    从 192.168.2.1 到 192.168.2.255
再通过使用java 执行ping命令 判断这些ip地址能否使用，把能够使用的ip打印出来
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Exercise_getAvailableIPAddress {
    public static void main(String[] args) throws UnknownHostException,IOException{
        //获取本机ip地址
        String localHostIPAddress = getLocalHostIP();
        //获取本机ip地址所在的网段有多少ip是可用的
        List<String> result = getAvailableIPAddress(localHostIPAddress);
        System.out.println("如下ip地址可以连接");
        for(Iterator<String> it=result.iterator();it.hasNext();){
            String ip = it.next();
            System.out.println(ip);
        }
        System.out.println("总共有: "+result.size()+"个地址");
    }

    //获取本机ip地址
    public static String getLocalHostIP() throws UnknownHostException {
        InetAddress host = InetAddress.getLocalHost();
        String ip = host.getHostAddress();
        return ip;
    }

    //测试某网段的ip地址是否可用,并放在一个列表中返回
    public static List<String> getAvailableIPAddress(String localIPAddress) throws IOException{
        List<String> ipList = new ArrayList<>();
        //先获取ip地址前三个字节最终的索引
        int index = localIPAddress.lastIndexOf(".");
        //截取前三个字节+"."
        String tmp = localIPAddress.substring(0,index+1);
        for(int i=1;i<=255;i++){
            String ip = tmp + i;
            if(isAvailable(ip))
                ipList.add(ip);
            System.out.println("已经完成:"+i+" 个ip 测试");
        }
        return ipList;
    }

    //判断某个ip地址是否可用
    public static boolean isAvailable(String ip) throws IOException {
        Process p = Runtime.getRuntime().exec("ping "+ip);
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(),
                "GBK"));
        String line = null;
        while((line=br.readLine())!=null){
            if(line.contains("请求超时"))
                return false;
        }
        return true;
    }
}
