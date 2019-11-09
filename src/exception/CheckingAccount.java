package exception;

/*  Author: 北辰
    日期: 09/11/2019
    功能: 支票账户,具备透支额度,继承Account
 */

public class CheckingAccount extends Account{
    private double overdraftProtection;         //透支额度

    public CheckingAccount(double balance){
        super(balance);             //显示调用父类带参构造方法
    }

    public CheckingAccount(double balance,double protect){
        super(balance);             //显示调用父类带参构造方法
        this.overdraftProtection = protect;     //将局部变量传入成员变量中
    }

    public void withdraw(double amt) throws OverdraftfException{
        if(getBalance()+overdraftProtection<amt){// 若取钱金额超过余额+透支额,则会抛出异常,并根据自定义异常返回透支额
            throw new OverdraftfException("您的余额不足,您当前透支额度为："+(amt-getBalance()-overdraftProtection),
                    amt-getBalance()-overdraftProtection);
        }
        if(getBalance()<amt){
            setBalance(0);
            overdraftProtection -= amt-getBalance();
        }
        setBalance(getBalance()-amt);
    }

    public static void main(String[] args){
        // 拥有5000余额和2500透支额度
        CheckingAccount money = new CheckingAccount(5000,2500);
        //存钱
        money.deposit(3000);
        //显示余额
        System.out.println("您的账户当前余额为: "+money.getBalance());
        //取钱
        try{
            for(int i=0;i<100;i++){
                money.withdraw(550);
                System.out.println("取走550元,您的账户当前余额为: "+money.getBalance());
            }
        }catch(OverdraftfException e){
            System.err.println("您的账户透支金额为: "+e.getDeficit());
        }
    }
}
