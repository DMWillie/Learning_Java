package exception;

/*  Author: 北辰
    日期: 09/11/2019
    功能: Account类:银行账号
 */

public class Account {
    private double balance;         //余额

    public Account(double balance){
        this.balance = balance;
    }

    public double getBalance(){         //获取余额
        return this.balance;
    }

    public void setBalance(double money){
        this.balance = money;
    }

    public void deposit(double amt){        //存钱
        this.balance += amt;
    }

    public void withdraw(double amt) throws OverdraftfException {       //取钱
        if(amt>balance)
            throw new OverdraftfException("账户余额不足",amt-balance);
        else{
            this.balance -= amt;
            System.out.printf("已取出 %f 元,账户余额为: %f 元\n",amt,getBalance());
        }

    }
}
