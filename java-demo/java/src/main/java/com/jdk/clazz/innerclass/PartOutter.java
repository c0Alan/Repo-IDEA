package com.jdk.clazz.innerclass;

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
        outter.getDog().sound();

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
     * 这里会报错 : 无法从静态上下文中引用非静态 变量 this
     */
/*    public static Animal getStaticDog(){
        class Dog extends Animal{
            public void sound(){
                System.out.println("wang wang");
            }
        }
        return new Dog();
    }*/

    abstract class Animal{
        public abstract void sound();
    }

}
