package digitAndstring;

/*  Author: 北辰
    日期: 28/10/2019
    功能: 测试StringBuffer的用法
 */

public class TestStringBuffer {
    public static void main(String[] args){
        String str1 = "let there ";

        StringBuffer sb = new StringBuffer(str1);       //根据str1创建一个StringBuffer对象
        sb.append("be light");          //在最后追加
        System.out.println(sb);

        sb.delete(4,10);            //删除4-10之间的字符
        System.out.println(sb);
        sb.insert(4,"there ");          //在4这个位置插入子串
        System.out.println(sb);
        sb.reverse();               //反转
        System.out.println(sb);

        /**StringBuffer内部维护了一个字符数组.但是，这个字符数组，留有冗余长度;这样调用插入和追加，在现成的数组的基础上就可以完成了*/
        String str2 = "the";
        StringBuffer sb2 = new StringBuffer(str2);
        System.out.println(sb2.length());       //内容长度             3
        System.out.println(sb2.capacity());     //总空间              19


    }
}
