package Interface_And_Extend;


public class Exercise {
    public static void main(String[] args){
        ADHero ad = new ADHero();
        Hero h = ad;
        AD adi = (AD) h;        //这里不能省略AD这个强制转换,因为h指向为ADHero类型,但本身是Hero类型
                            //而Hero类型是没有实现AD接口的
        APHero ap = (APHero) adi;       //这行会报错
    }
}
