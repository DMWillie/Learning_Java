package exception;

/*  Author: 北辰
    日期: 08/11/2019
    功能: 自定义异常,下标为负异常
 */


public class IndexIsNegativeException extends Throwable{
    //无参构造方法
    public IndexIsNegativeException(){
    }
    //有参构造方法
    public IndexIsNegativeException(String msg){
        super(msg);
    }
}
