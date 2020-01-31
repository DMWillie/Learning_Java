package annotation.pojo;
/*  Author: 北辰
    日期: 31/01/2020
    功能:在Hero类上运用这些自定义注解：
当注解的方法是value的时候，给这个注解赋值时，本来应该是：
@MyColumn(value="name_")
现在可以简略一点，写为
@MyColumn("name_")
只有当名称是value的时候可以这样，其他名称如name,strategy等不行
 */

import annotation.hibernate_annotation.*;

@MyEntity
@MyTable(name="hero_")
public class Hero {
    private int id;
    private String name;
    private int damage;
    private int armor;

    @MyId
    @MyGeneratedValue(strategy="identity")
    @MyColumn("id_")
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    @MyColumn("name_")
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    @MyColumn("damage_")
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }
    @MyColumn("armor_")
    public int getArmor(){
        return armor;
    }
    public void setArmor(int armor){
        this.armor = armor;
    }
}
