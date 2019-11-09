package exception;

/*  Author: 北辰
    日期: 09/11/2019
    功能: 测试OverdraftException类,初始化账户余额为1万元,先取出3000元,再取8000元,会报透支异常错误
 */

public class TestOverdraftException {

    public static void main(String[] args){
        Account myAccount = new Account(10000);
        double withdraw1 = 3000;
        double deposit1 = 200;
        double withdraw2 = 8000;
        try{
            System.out.printf("试图取出 %f 元\n",withdraw1);
            myAccount.withdraw(withdraw1);
        }catch(OverdraftfException e){
            e.printStackTrace();
        }
        System.out.println();
        myAccount.deposit(deposit1);
        System.out.printf("存入 %f 元,现在账户余额为: %f 元\n\n",deposit1,myAccount.getBalance());

        try{
            System.out.printf("试图取出 %f 元\n",withdraw2);
            myAccount.withdraw(withdraw2);
        }catch(OverdraftfException e){
            e.printStackTrace();
        }
    }
}
