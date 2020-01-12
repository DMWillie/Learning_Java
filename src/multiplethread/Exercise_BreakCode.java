package multiplethread;
/*  Author: 北辰
    日期: 12/01/2020
    功能: 破解密码(不完善)
1. 生成一个长度是3的随机字符串，把这个字符串当作密码
2. 创建一个破解线程，使用穷举法，匹配这个密码
3. 创建一个日志线程，打印都用过哪些字符串去匹配，这个日志线程设计为守护线程
提示： 破解线程把穷举法生成的可能密码放在一个容器中，日志线程不断的从这个容器中拿出可能密码，
并打印出来。 如果发现容器是空的，就休息1秒，如果发现不是空的，就不停的取出，并打印。
 */

import digitAndstring.Exercise_RandomString;

public class Exercise_BreakCode {
    public static void main(String[] args) {
        Exercise_RandomString e = new Exercise_RandomString();
        String password = e.getRandomString_2(3);   //生成一个3位包含大小写字母,数字的字符串密码
        System.out.println("生成的3位字符串密码为: "+password);
        CrackThread t1 = new CrackThread(password.length());
        new Thread(t1).start();  //启动破解线程来破解密码
        LogThread t2 = new LogThread(t1.container);
        t2.setDaemon(true); //设置日志线程为守护线程
        t2.start();
    }
}
