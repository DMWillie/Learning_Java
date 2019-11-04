package exception;

/*  Author: 北辰
    日期: 04/11/2019
    功能: 假设有一个方法 public int method()， 会返回一个整数
        在这个方法中有try catch 和 finally.
        try 里返回 1
        catch 里 返回 2
        finally 里 返回3
        那么，这个方法到底返回多少？
 */

public class Exercise_HandleException {
    public static void main(String[] args){
        Exercise_HandleException e = new Exercise_HandleException();
        int result = e.method();
        System.out.println(result);     //结果为3,也就是最后返回的是finally中的值
    }

    public int method(){
        try{
            return 1;
        }catch(Exception e){
            return 2;
        }finally{
            return 3;
        }
    }
}
