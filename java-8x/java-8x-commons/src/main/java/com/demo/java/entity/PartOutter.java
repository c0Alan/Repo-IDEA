package com.demo.java.entity;

/**
 * 局部内部类
 * 局部内部类是定义在一个方法或者一个作用域里面的类，
 * 它和成员内部类的区别在于局部内部类的访问仅限于方法内或者该作用域内
 * 局部内部类就像是方法里面的一个局部变量一样
 *
 * @author liuxl
 * @date 2018/6/5 12:34
 */
public class PartOutter {

    public static void main(String[] args) {
        PartOutter outter = new PartOutter();
        outter.getDog().sound(); // wang wang

        // 这里会报错, 静态方法中不能new内部类的实例对象 : 无法从静态上下文中引用非静态 变量 this
        // 原因: 内部类的最重要的一个特点就是它可以直接访问它外部类的成员变量。成员变量是对象身上的。
        // 结论: 静态方法中使用内部类不能通过 new
//        getStaticCat().sound();

        PartOutter.Coal coal = new PartOutter.Coal();
        coal.sound(); // mao mao
    }

    public Animal getDog(){
        class Dog extends Animal{
            public void sound(){
                System.out.println("wang wang");
            }
        }
        return new Dog();
    }

    /**
     * 静态方法内部类
     * 在静态方法中定义的内部类, 静态方法中使用内部类不能通过new
     * 不能在类前面加static 关键字
     * 除了可以直接访问外部类中的 static 的成员变量, 还可以访问静态方法中的局部变量, 但是该局部变量前必须加final 修饰符
     * 可以访问外部类的成员变量, 不能定义静态成员
     */
/*    public static Animal getStaticCat(){
        class Cat extends Animal{
            public void sound(){
                System.out.println("miao miao");
            }
        }
        return new Cat();
    }*/

    static class Coal{

        public void sound() {
            System.out.println("mao mao");
        }
    }

    abstract class Animal{
        public abstract void sound();
    }

}
