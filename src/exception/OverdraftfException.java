package exception;

/*  Author: 北辰
    日期: 09/11/2019
    功能: 透支异常类,继承自Exception类
 */

public class OverdraftfException extends Exception{
    public double deficit;          //透支额

    public OverdraftfException(String message,double deficit){
        System.out.println("发生错误,错误信息为: "+message);
        System.out.printf("错误原因为:已透支 %f 元",deficit);
    }

    public double getDeficit(){
        return this.deficit;
    }
}
