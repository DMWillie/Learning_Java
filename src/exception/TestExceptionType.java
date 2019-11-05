package exception;

/*  Author: 北辰
    日期: 05/11/2019
    功能: 测试Java中异常的三种类型:可查异常/运行时异常/错误
 */

public class TestExceptionType {
    public static void main(String[] args){
        //任何除数不能为0:ArithmeticException
        try{
            int k = 5/0;
        }catch(ArithmeticException e){
            System.out.println("除数不能为0");
        }

        //下标越界异常：ArrayIndexOutOfBoundsException
        try{
            int[] j = new int[5];
            j[10] = 10;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("数组下标越界");
        }

        //空指针异常：NullPointerException
        try{
            String str = null;
            str.length();
        }catch(NullPointerException e){
            System.out.println("空指针异常");
        }

        StringBuffer sb = new StringBuffer();
        //错误Error，指的是系统级别的异常，通常内存用光了会报OutOfMemoryError
        try{
            for(int i=0;i<Integer.MAX_VALUE;i++){
                sb.append('a');
            }
        }catch(OutOfMemoryError e){
            System.out.println("内存已用尽");
        }

        /**运行时异常是不可查异常,不需要对其进行显式的捕捉
         非运行时异常是可查异常,必须要对其进行显式的捕捉,抛出,不然编译器会报错不允许程序运行.
         */
    }
}
