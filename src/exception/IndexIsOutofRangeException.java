package exception;

/*  Author: 北辰
    日期: 08/11/2019
    功能: 自定义异常,下标超出范围异常
 */

public class IndexIsOutofRangeException extends Throwable{
    //无参构造方法
    public IndexIsOutofRangeException(){
    }
    //有参构造方法
    public IndexIsOutofRangeException(String msg){
        super(msg);
    }
}
