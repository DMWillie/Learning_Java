package digitAndstring;

/*  Author: 北辰
    日期: 26/10/2019
    功能: 测试字符串的一些用法和方法
 */


public class TestString {

    /*这里会报错，因为String被修饰为final,不能被继承*/
    //static class MyString extends String{
    //}
    public static void main(String[] args){
        /**创建字符串**/
        String garen = "盖伦";        //字面值,虚拟机碰到字面值就会创建一个字符串对象
        String teemo = new String("提莫"); //创建了两个字符串对象
        char[] cs = new char[]{'崔','斯','特'};
        String hero = new String(cs);       //通过字符数组创建一个字符串对象
        String hero2 = garen+teemo;         //通过+加号进行字符串拼接
        System.out.println(hero);
        System.out.println(hero2);
        /**字符串格式化**/
        String name ="盖伦";
        int kill = 8;
        String title="超神";

        //直接使用+进行字符串连接，编码感觉会比较繁琐，并且维护性差,易读性差
        String sentence = name+ " 在进行了连续 " + kill + " 次击杀后，获得了 " + title +" 的称号";
        System.out.println(sentence);
        //格式化字符串
        //%s表示字符串，%d表示数字,%n表示换行
        String sentenceFormat ="%s 在进行了连续 %d 次击杀后，获得了 %s 的称号%n";
        String sentence2 = String.format(sentenceFormat, name,kill,title);
        System.out.println(sentence2);
    }
}
