package multiplethread;

import java.util.ArrayList;

/*  Author: 北辰
    日期: 12/01/2020
    功能: 破解密码线程,使用穷举法来破解密码
    有两种实现方式:多层for循环和递归
 */
public class CrackThread implements Runnable{
    private int len = 0;    //要破解的密码长度
    public ArrayList<String> container
            = new ArrayList<>();     //所有穷举法生成的密码放进这个容器中

    public CrackThread(int len){
        this.len = len;
    }

    @Override
    public void run(){
        char[] passArr = new char[len];
        System.out.println("破解线程开始穷举破解密码");
        crackCode2(len,0,passArr);
    }
    //方法一***:使用多层for循环暴力破解3位数密码
    public void crackCode1(int n){
        char[] result = new char[n];
        for(int i='0';i<='z';i++){
            result[0] = (char)i;
            for(int j='0';j<='z';j++){
                result[1] = (char)j;
                for(int k='0';k<='z';k++){
                    result[2] = (char)k;
                    container.add(String.valueOf(result));
                }
            }
        }
    }
    //方法二,使用递归破解三位数密码
    public void crackCode2(int n,int index,char[] passCode){
        /** param: n 代表破解的密码长度
         * param: index 代表当前生成密码的下标
         * param: passCode 代表当前生成的密码字符数组
         * */
        for(int i='0';i<='z';i++){
            passCode[index] = (char)i;
            if(index==n-1){ //当生成的密码数组长度为n时,添加该密码到容器中
                container.add(String.valueOf(passCode));
            }else{
                crackCode2(n,index+1,passCode);
            }
        }
    }
//    public static void main(String[] args) {
//        CrackThread t = new CrackThread(3);
//        char[] passArr = new char[3];
//        t.crackCode2(3,0,passArr);
//        System.out.println(t.container);
//    }
}
