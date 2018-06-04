# Java程序运行机制

running mechanism

# UML 设计

1 用例图
2 类图
3 组件图
4 部署图
5 顺序图
6 活动图
7 状态机图

# 数据类型

# 运算符

# 流程控制

# 面向对象

## 面向对象的特征

计算机软件系统是现实生活中的业务在计算机中的映射, 而现实生活中的业务其实就是一个
个对象协作的过程。面向对象编程就是按现实业务一样的方式将程序代码按一个个对象进行
组织和编写, 让计算机系统能够识别和理解用对象方式组织和编写的程序代码, 这样就可以
把现实生活中的业务对象映射到计算机系统中。
面向对象的编程语言有, 吗等4个主要的特征。

### 封装：

封装是保证软件部件具有优良的模块性的基础, 封装的目标就是要实现软件部件的
**"高内聚、低耦合"**
防止程序相互依赖性而带来的变动影响。在面向对象的编程语言中, 对象是封装
的最基本单位, 面向对象的封装比传统语言的封装更为清晰、更为有力。

```java
// 面向对象的封装就是把描述一个对象的属性和行为的代码封装在一个"模块"中, 也就是一个类中
```

属性用变量定义, 行为用方法进行定义, 方法可以直接访问同一个对象中的属性。
通常情况下, 只要记住让变量和访问这个变量的方法放在一起, 将一个类中的成员变量全部定义成私有的, 
只有这个类自己的方法才可以访问到这些成员变量, 这就基本上实现对象的封装, 就很容易
找出要分配到这个类上的方法了, 就基本上算是会面向对象的编程了。把握一个原则：把
对同一事物进行操作的方法和相关的方法放在同一个类中, 把方法和它操作的数据放在同
一个类中。
例如, 人要在黑板上画圆, 这一共涉及三个对象：人、黑板、圆, 画圆的方法要分配给哪个
对象呢？由于画圆需要使用到圆心和半径, 圆心和半径显然是圆的属性, 如果将它们在类中
定义成了私有的成员变量, 那么, 画圆的方法必须分配给圆, 它才能访问到圆心和半径这两
个属性, 人以后只是调用圆的画圆方法、表示给圆发给消息而已, 画圆这个方法不应该分配
在人这个对象上, 这就是面向对象的封装性, 即将对象封装成一个高度自治和相对封闭的
个体, 对象状态(属性)由这个对象自己的行为(方法)来读取和改变。一个更便于理解
的例子就是, 司机将火车刹住了, 刹车的动作是分配给司机, 还是分配给火车, 显然, 应该
分配给火车, 因为司机自身是不可能有那么大的力气将一个火车给停下来的, 只有火车自己
才能完成这一动作, 火车需要调用内部的离合器和刹车片等多个器件协作才能完成刹车这个
动作, 司机刹车的过程只是给火车发了一个消息, 通知火车要执行刹车动作而已。

### 抽象：

```java
// 抽象就是找出一些事物的相似和共性之处, 然后将这些事物归为一个类
```

这个类只考虑这些事物的相似和共性之处, 并且会忽略与当前主题和目标无关的那些方面, 
将注意力集中在与当前目标有关的方面。例如, 看到一只蚂蚁和大象, 你能够想象出它们的相同之处, 
那就是抽象。抽象包括行为抽象和状态抽象两个方面。例如, 定义一个Person 类, 如下：
classPerson {
	String name;
	int age;
}
人本来是很复杂的事物, 有很多方面, 但因为当前系统只需要了解人的姓名和年龄, 所以上
面定义的类中只包含姓名和年龄这两个属性, 这就是一种抽像, 使用抽象可以避免考虑一些
与目标无关的细节。我对抽象的理解就是不要用显微镜去看一个事物的所有方面, 这样涉及
的内容就太多了, 而是要善于划分问题的边界, 当前系统需要什么, 就只考虑什么。

### 继承：

在定义和实现一个类的时候, 可以在一个已经存在的类的基础之上来进行, 
把这个已经存在的类所定义的内容作为自己的内容, 并可以加入若干新的内容, 
或修改原来的方法使之更适合特殊的需要, 这就是继承。继承是子类自动共享父类数据和方法的机制, 
这是类之间的一种关系, 提高了软件的可重用性和可扩展性。

### 多态：

```java
// 多态是指程序中定义的引用变量所指向的具体类型和通过该引用变量发出的方法调用在编程时并不确定, 
// 而是在程序运行期间才确定, 即一个引用变量倒底会指向哪个类的实例对象, 
// 该引用变量发出的方法调用到底是哪个类中实现的方法, 必须在由程序运行期间才能决定。
```

因为在程序运行时才确定具体的类, 这样, 不用修改源程序代码, 就可以让引用变量绑定到
各种不同的类实现上, 从而导致该引用调用的具体方法随之改变, 即不修改程序代码就可以
改变程序运行时所绑定的具体代码, 让程序可以选择多个运行状态, 这就是多态性。多态性
增强了软件的灵活性和扩展性。例如, 下面代码中的UserDao 是一个接口, 它定义引用变
量userDao 指向的实例对象由daofactory.getDao()在执行的时候返回, 有时候指向的是
UserJdbcDao 这个实现, 有时候指向的是UserHibernateDao 这个实现, 这样, 不用修改
源代码, 就可以改变userDao 指向的具体类实现, 从而导致userDao.insertUser()方法调用
的具体代码也随之改变, 即有时候调用的是UserJdbcDao 的insertUser 方法, 有时候调用
的是UserHibernateDao 的insertUser 方法：
UserDao userDao =daofactory.getDao();
userDao.insertUser(user);
比喻：人吃饭, 你看到的是左手, 还是右手？

# 类

## 类加载过程

JVM加载类过程：
1.加载：
类字节码文件从硬盘读入到内存中

类加载器(BootStrapClassLoader,ExtensionClassLoader,SystemClassLoader）加载字节码文件在方法区存放生成类对应的Class对象

2.连接
这个过程又包括了：验证、准备、解析
验证：对class等进行验证的过程；
准备阶段：为静态变量开辟内存空间并赋上默认初始值；

解析：符号化链接解析成实际链接（调用对象方法符号表示转变为方法的实际地址）

3.初始化
执行静态成员的初始化语句（为在连接部分中的准备阶段中已经分配内存空间和赋上默认值的静态成员赋值）
执行静态语句块
类加载过程是先加载父类，然后再加载子类
类加载完毕后，如果要进行对象实例化就需要执行：
父类非静态成员初始化语句（包括代码块，按照在类定义中的顺序执行）->父类构造函数->子类非静态成员初始化语句（包括代码块，按照在类定义中的顺序执行）->子类构造方法

下面是总结的一个顺序，比较清楚：
有父类的情况
1. 加载父类
    1.1 为静态属性分配存储空间并赋初始值 
    1.2 执行静态初始化块和静态初始化语句（从上至下）
2. 加载子类
    2.1 为静态属性分配存储空间
    2.2 执行静态初始化块和静态初始化语句（从上至下）
3. 加载父类构造器
    3.1 为实例属性分配存数空间并赋初始值 
    3.2 执行实例初始化块和实例初始化语句
    3.3 执行构造器内容
4. 加载子类构造器
    4.1 为实例属性分配存数空间并赋初始值 
    4.2 执行实例初始化块和实例初始化语句
    4.3 执行构造器内容

## abstract class 和 interface

含有abstract 修饰符的class 即为抽象类, abstract 类不能创建的实例对象。含有abstract方法的类必须定义为abstract class, abstract class 类中的方法不必是抽象的。abstract class类中定义抽象方法必须在具体(Concrete)子类中实现, 所以, 不能有抽象构造方法或抽象静态方法(因为抽象的方法是要被子类实现的, 而static 与子类扯不上关系!)。如果的子类没有实现抽象父类中的所有抽象方法, 那么子类也必须定义为abstract类型。接口(interface)可以说成是抽象类的一种特例, 接口中的所有方法都必须是抽象的。接口中的方法定义默认为public abstract 类型, 接口中的成员变量类型默认为public static final。
下面比较一下两者的语法区别：

1. 抽象类可以有构造方法, 接口中不能有构造方法。
2. 抽象类中可以有普通成员变量, 接口中没有普通成员变量
3. 抽象类中可以包含非抽象的普通方法, 接口中的所有方法必须都是抽象的, 不能有非抽象的普通方法。
4. 抽象类中的抽象方法的访问类型可以是public, protected 和(默认类型,虽然eclipse 下不报错, 但应该也不行), 
  但接口中的抽象方法只能是public 类型的, 并且默认即为public abstract 类型。
5. 抽象类中可以包含静态方法, 接口中不能包含静态方法
6. 抽象类和接口中都可以包含静态成员变量, 抽象类中的静态成员变量的访问类型可以任意, 
  但接口中定义的变量只能是public static final 类型, 并且默认即为public static final 类型。
7. 一个类可以实现多个接口, 但只能继承一个抽象类。

下面接着再说说两者在应用上的区别：

```java
// 接口更多的是在系统架构设计方法发挥作用, 主要用于定义模块之间的通信契约。
// 而抽象类在代码实现方面发挥作用, 可以实现代码的重用, 例如, 模板方法设计模式是抽象类的一个典型应用, 
```

假设某个项目的所有Servlet 类都要用相同的方式进行权限判断、记录访问日志和处理异常, 那么就可以定义一个抽象的基类, 让所有的Servlet 都继承这个抽象基类, 在抽象基类的service 方法中完成权限判断、记录访问日志和处理异常的代码, 在各个子类中只是完成各自的业务逻辑代码, 
伪代码如下：

```java
public abstract classBase Servlet extends HttpServlet {
	public final void service(HttpServletRequest request, HttpServletResponse
		response)throws IOExcetion, ServletException {
		// 记录访问日志
		// 进行权限判断
		if (具有权限) {
			try {
				doService(request, response);
			} catch (Excetpion e) {
				记录异常信息
			}
		}
	}
	protected abstract void doService(HttpServletRequest
		request, HttpServletResponse response)throws IOExcetion,
	ServletException;
	//注意访问权限定义成protected, 显得既专业, 又严谨, 因为它是专门给子类用的
}
public class MyServlet1 extends BaseServlet {
	protected voiddoService(HttpServletRequest request, HttpServletResponse response)
	throwsIOExcetion,
	ServletException {
		本Servlet 只处理的具体业务逻辑代码
	}
}
```

父类方法中间的某段代码不确定, 留给子类干, 就用模板方法设计模式。
备注：这道题的思路是先从总体解释抽象类和接口的基本概念, 然后再比较两者的语法细节, 最后再说两者的应用区别。比较两者语法细节区别的条理是：先从一个类中的构造方法、普通成员变量和方法(包括抽象方法), 静态变量和方法, 继承性等6个方面逐一去比较回答, 接着从第三者继承的角度的回答, 特别是最后用了一个典型的例子来展现自己深厚的技术功底。



## 重载和覆盖

Overload 是重载的意思, Override 是覆盖的意思, 也就是重写。
	重载Overload 表示同一个类中可以有多个名称相同的方法, 但这些方法的参数列表各不相同(即参数个数或类型不同)。
	覆盖Override 表示子类中的方法可以与父类中的某个方法的名称和参数完全相同, 通过子类创建的实例对象调用这个方法时, 将调用子类中的定义方法, 这相当于把父类中定义的那个完全相同的方法给覆盖了, 这也是面向对象编程的多态性的一种表现。子类覆盖父类的方法时, 只能比父类抛出更少的异常, 或者是抛出父类抛出的异常的子异常, 因为子类可以解决父类的一些问题, 不能比父类有更多的问题。子类方法的访问权限只能比父类的更大, 不能更小。如果父类的方法是private 类型, 那么, 子类则不存在覆盖的限制, 相当于子类中增加了一个全新的方法。

在覆盖要注意以下的几点：
1、覆盖的方法的标志必须要和被覆盖的方法的标志完全匹配, 才能达到覆盖的效果；
2、覆盖的方法的返回值必须和被覆盖的方法的返回一致；
3、覆盖的方法所抛出的异常必须和被覆盖方法的所抛出的异常一致, 或者是其子类；
4、被覆盖的方法不能为private, 否则在其子类中只是新定义了一个方法, 并没有对其进行覆盖。
overload 对我们来说可能比较熟悉, 可以翻译为重载, 它是指我们可以定义一些名称相同的方法, 
通过定义不同的输入参数来区分这些方法, 然后再调用时, VM 就会根据不同的参数样式, 来选择合适的方法执行。

在使用重载要注意以下的几点：
1、在使用重载时只能通过不同的参数样式。例如, 不同的参数类型, 不同的参数个数, 
不同的参数顺序(当然, 同一方法内的几个参数类型必须不一样, 例如可以是fun(int,float), 但是不能为fun(int,int))；
2、不能通过访问权限、返回类型、抛出的异常进行重载；
3、方法的异常类型和数目不会对重载造成影响；
4、对于继承来说, 如果某一方法在父类中是访问权限是priavte, 那么就不能在子类对其进行重载, 
如果定义的话, 也只是定义了一个新方法, 而不会达到重载的效果。

## 内部类

　　在Java中，可以将一个类定义在另一个类里面或者一个方法里面，这样的类称为内部类。广泛意义上的内部类一般来说包括这四种：成员内部类、局部内部类、匿名内部类和静态内部类。下面就先来了解一下这四种内部类的用法。

### 1.成员内部类

　　成员内部类是最普通的内部类，它的定义为位于另一个类的内部，形如下面的形式：

```java
class Circle {
    double radius = 0;
     
    public Circle(double radius) {
        this.radius = radius;
    }
     
    class Draw {     //内部类
        public void drawSahpe() {
            System.out.println("drawshape");
        }
    }
}
```



　　这样看起来，类Draw像是类Circle的一个成员，Circle称为外部类。成员内部类可以无条件访问外部类的所有成员属性和成员方法（包括private成员和静态成员）。

```java
class Circle {
    private double radius = 0;
    public static int count =1;
    public Circle(double radius) {
        this.radius = radius;
    }
     
    class Draw {     //内部类
        public void drawSahpe() {
            System.out.println(radius);  //外部类的private成员
            System.out.println(count);   //外部类的静态成员
        }
    }
}
```



　　不过要注意的是，当成员内部类拥有和外部类同名的成员变量或者方法时，会发生隐藏现象，即默认情况下访问的是成员内部类的成员。如果要访问外部类的同名成员，需要以下面的形式进行访问：

```java
外部类.this.成员变量
外部类.this.成员方法
```



　　虽然成员内部类可以无条件地访问外部类的成员，而外部类想访问成员内部类的成员却不是这么随心所欲了。在外部类中如果要访问成员内部类的成员，必须先创建一个成员内部类的对象，再通过指向这个对象的引用来访问：

```java
class Circle {
    private double radius = 0;
 
    public Circle(double radius) {
        this.radius = radius;
        getDrawInstance().drawSahpe();   //必须先创建成员内部类的对象，再进行访问
    }
     
    private Draw getDrawInstance() {
        return new Draw();
    }
     
    class Draw {     //内部类
        public void drawSahpe() {
            System.out.println(radius);  //外部类的private成员
        }
    }
}
```



　　成员内部类是依附外部类而存在的，也就是说，如果要创建成员内部类的对象，前提是必须存在一个外部类的对象。创建成员内部类对象的一般方式如下：

```java
public class Test {
    public static void main(String[] args)  {
        //第一种方式：
        Outter outter = new Outter();
        Outter.Inner inner = outter.new Inner();  //必须通过Outter对象来创建
         
        //第二种方式：
        Outter.Inner inner1 = outter.getInnerInstance();
    }
}
 
class Outter {
    private Inner inner = null;
    public Outter() {
         
    }
     
    public Inner getInnerInstance() {
        if(inner == null)
            inner = new Inner();
        return inner;
    }
      
    class Inner {
        public Inner() {
             
        }
    }
}
```



　　内部类可以拥有private访问权限、protected访问权限、public访问权限及包访问权限。比如上面的例子，如果成员内部类Inner用private修饰，则只能在外部类的内部访问，如果用public修饰，则任何地方都能访问；如果用protected修饰，则只能在同一个包下或者继承外部类的情况下访问；如果是默认访问权限，则只能在同一个包下访问。这一点和外部类有一点不一样，外部类只能被public和包访问两种权限修饰。我个人是这么理解的，由于成员内部类看起来像是外部类的一个成员，所以可以像类的成员一样拥有多种权限修饰。

### 2.局部内部类

　　局部内部类是定义在一个方法或者一个作用域里面的类，它和成员内部类的区别在于局部内部类的访问仅限于方法内或者该作用域内。

```java
class People{
    public People() {
         
    }
}
 
class Man{
    public Man(){
         
    }
     
    public People getWoman(){
        class Woman extends People{   //局部内部类
            int age =0;
        }
        return new Woman();
    }
}
```



　　注意，局部内部类就像是方法里面的一个局部变量一样，是不能有public、protected、private以及static修饰符的。

### 3.匿名内部类

　　匿名内部类应该是平时我们编写代码时用得最多的，在编写事件监听的代码时使用匿名内部类不但方便，而且使代码更加容易维护。下面这段代码是一段Android事件监听代码：

```java
scan_bt.setOnClickListener(new OnClickListener() {
	 
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 
	}
});
 
history_bt.setOnClickListener(new OnClickListener() {
	 
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 
	}
});
```



　　这段代码为两个按钮设置监听器，这里面就使用了匿名内部类。这段代码中的：

```java
new OnClickListener() {
	 
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 
	}
}
```



　　就是匿名内部类的使用。代码中需要给按钮设置监听器对象，使用匿名内部类能够在实现父类或者接口中的方法情况下同时产生一个相应的对象，但是前提是这个父类或者接口必须先存在才能这样使用。当然像下面这种写法也是可以的，跟上面使用匿名内部类达到效果相同。

```java
private void setListener()
{
    scan_bt.setOnClickListener(new Listener1());       
    history_bt.setOnClickListener(new Listener2());
}
 
class Listener1 implements View.OnClickListener{
    @Override
    public void onClick(View v) {
    // TODO Auto-generated method stub
             
    }
}
 
class Listener2 implements View.OnClickListener{
    @Override
    public void onClick(View v) {
    // TODO Auto-generated method stub
             
    }
}
```



　　这种写法虽然能达到一样的效果，但是既冗长又难以维护，所以一般使用匿名内部类的方法来编写事件监听代码。同样的，匿名内部类也是不能有访问修饰符和static修饰符的。

　　匿名内部类是唯一一种没有构造器的类。正因为其没有构造器，所以匿名内部类的使用范围非常有限，大部分匿名内部类用于接口回调。匿名内部类在编译的时候由系统自动起名为Outter$1.class。一般来说，匿名内部类用于继承其他类或是实现接口，并不需要增加额外的方法，只是对继承方法的实现或是重写。

```java
public class Test {
    public static void main(String[] args)  {
        Outter.Inner inner = new Outter.Inner();
    }
}
 
class Outter {
    public Outter() {
         
    }
     
    static class Inner {
        public Inner() {
             
        }
    }
}
```



### 4.静态内部类

　　静态内部类也是定义在另一个类里面的类，只不过在类的前面多了一个关键字static。静态内部类是不需要依赖于外部类的，这点和类的静态成员属性有点类似，并且它不能使用外部类的非static成员变量或者方法，这点很好理解，因为在没有外部类的对象的情况下，可以创建静态内部类的对象，如果允许访问外部类的非static成员就会产生矛盾，因为外部类的非static成员必须依附于具体的对象。

# Java基础类库

# Java集合

# 泛型

# 异常处理

# 

# JDBC编程

# 注解

# IO

# NIO

# 反射

类加载机制与反射

# 多线程

# 网络编程

# AWT编程

# Swing编程

# 正则表达式

# Java 正则表达式

正则表达式定义了字符串的模式。

正则表达式可以用来搜索、编辑或处理文本。

正则表达式并不仅限于某一种语言，但是在每种语言中有细微的差别。

### 正则表达式实例

一个字符串其实就是一个简单的正则表达式，例如 **Hello World** 正则表达式匹配 "Hello World" 字符串。

**.**（点号）也是一个正则表达式，它匹配任何一个字符如："a" 或 "1"。

下表列出了一些正则表达式的实例及描述：

| 正则表达式       | 描述                                                         |
| ---------------- | ------------------------------------------------------------ |
| this is text     | 匹配字符串 "this is text"                                    |
| this\s+is\s+text | 注意字符串中的 **\s+**。匹配单词 "this" 后面的 **\s+** 可以匹配多个空格，之后匹配 is 字符串，再之后 **\s+** 匹配多个空格然后再跟上 text 字符串。可以匹配这个实例：this is text |
| ^\d+(\.\d+)?     | ^ 定义了以什么开始\d+ 匹配一个或多个数字? 设置括号内的选项是可选的\. 匹配 "."可以匹配的实例："5", "1.5" 和 "2.21"。 |

Java 正则表达式和 Perl 的是最为相似的。

java.util.regex 包主要包括以下三个类：

- Pattern 类：

  pattern 对象是一个正则表达式的编译表示。Pattern 类没有公共构造方法。要创建一个 Pattern 对象，你必须首先调用其公共静态编译方法，它返回一个 Pattern 对象。该方法接受一个正则表达式作为它的第一个参数。

- Matcher 类：

  Matcher 对象是对输入字符串进行解释和匹配操作的引擎。与Pattern 类一样，Matcher 也没有公共构造方法。你需要调用 Pattern 对象的 matcher 方法来获得一个 Matcher 对象。

- PatternSyntaxException：

  PatternSyntaxException 是一个非强制异常类，它表示一个正则表达式模式中的语法错误。

以下实例中使用了正则表达式 **.\*runoob.*** 用于查找字符串中是否包了 **runoob** 子串：

## 实例

import java.util.regex.*;   class RegexExample1{    public static void main(String args[]){       String content = "I am noob " +         "from runoob.com.";         String pattern = ".*runoob.*";         boolean isMatch = Pattern.matches(pattern, content);       System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);    } }

实例输出结果为：

字符串中是否包含了 'runoob' 子字符串? true

------

## 捕获组

捕获组是把多个字符当一个单独单元进行处理的方法，它通过对括号内的字符分组来创建。

例如，正则表达式 (dog) 创建了单一分组，组里包含"d"，"o"，和"g"。

捕获组是通过从左至右计算其开括号来编号。例如，在表达式（（A）（B（C））），有四个这样的组：

- ((A)(B(C)))
- (A)
- (B(C))
- (C)

可以通过调用 matcher 对象的 groupCount 方法来查看表达式有多少个分组。groupCount 方法返回一个 int 值，表示matcher对象当前有多个捕获组。

还有一个特殊的组（group(0)），它总是代表整个表达式。该组不包括在 groupCount 的返回值中。

## 实例

下面的例子说明如何从一个给定的字符串中找到数字串：

## RegexMatches.java 文件代码：

import java.util.regex.Matcher; import java.util.regex.Pattern;   public class RegexMatches {     public static void main( String args[] ){         // 按指定模式在字符串查找       String line = "This order was placed for QT3000! OK?";       String pattern = "(\\D*)(\\d+)(.*)";         // 创建 Pattern 对象       Pattern r = Pattern.compile(pattern);         // 现在创建 matcher 对象       Matcher m = r.matcher(line);       if (m.find( )) {          System.out.println("Found value: " + m.group(0) );          System.out.println("Found value: " + m.group(1) );          System.out.println("Found value: " + m.group(2) );          System.out.println("Found value: " + m.group(3) );        } else {          System.out.println("NO MATCH");       }    } }

以上实例编译运行结果如下：

```
Found value: This order was placed for QT3000! OK?
Found value: This order was placed for QT
Found value: 3000
Found value: ! OK?
```

------

## 正则表达式语法

在其他语言中，\\ 表示：**我想要在正则表达式中插入一个普通的（字面上的）反斜杠，请不要给它任何特殊的意义。**

在 Java 中，\\ 表示：**我要插入一个正则表达式的反斜线，所以其后的字符具有特殊的意义。**

所以，在其他的语言中（如Perl），一个反斜杠 \ 就足以具有转义的作用，而在 Java 中正则表达式中则需要有两个反斜杠才能被解析为其他语言中的转义作用。也可以简单的理解在 Java 的正则表达式中，两个 \\ 代表其他语言中的一个 \，这也就是为什么表示一位数字的正则表达式是 \\d，而表示一个普通的反斜杠是 \\\\。

| 字符          | 说明                                                         |
| ------------- | ------------------------------------------------------------ |
| \             | 将下一字符标记为特殊字符、文本、反向引用或八进制转义符。例如，"n"匹配字符"n"。"\n"匹配换行符。序列"\\\\"匹配"\\"，"\\("匹配"("。 |
| ^             | 匹配输入字符串开始的位置。如果设置了 **RegExp** 对象的 **Multiline** 属性，^ 还会与"\n"或"\r"之后的位置匹配。 |
| $             | 匹配输入字符串结尾的位置。如果设置了 **RegExp** 对象的 **Multiline** 属性，$ 还会与"\n"或"\r"之前的位置匹配。 |
| *             | 零次或多次匹配前面的字符或子表达式。例如，zo* 匹配"z"和"zoo"。* 等效于 {0,}。 |
| +             | 一次或多次匹配前面的字符或子表达式。例如，"zo+"与"zo"和"zoo"匹配，但与"z"不匹配。+ 等效于 {1,}。 |
| ?             | 零次或一次匹配前面的字符或子表达式。例如，"do(es)?"匹配"do"或"does"中的"do"。? 等效于 {0,1}。 |
| {*n*}         | *n* 是非负整数。正好匹配 *n* 次。例如，"o{2}"与"Bob"中的"o"不匹配，但与"food"中的两个"o"匹配。 |
| {*n*,}        | *n* 是非负整数。至少匹配 *n* 次。例如，"o{2,}"不匹配"Bob"中的"o"，而匹配"foooood"中的所有 o。"o{1,}"等效于"o+"。"o{0,}"等效于"o*"。 |
| {*n*,*m*}     | *M* 和 *n* 是非负整数，其中 *n* <= *m*。匹配至少 *n* 次，至多 *m* 次。例如，"o{1,3}"匹配"fooooood"中的头三个 o。'o{0,1}' 等效于 'o?'。注意：您不能将空格插入逗号和数字之间。 |
| ?             | 当此字符紧随任何其他限定符（*、+、?、{*n*}、{*n*,}、{*n*,*m*}）之后时，匹配模式是"非贪心的"。"非贪心的"模式匹配搜索到的、尽可能短的字符串，而默认的"贪心的"模式匹配搜索到的、尽可能长的字符串。例如，在字符串"oooo"中，"o+?"只匹配单个"o"，而"o+"匹配所有"o"。 |
| .             | 匹配除"\r\n"之外的任何单个字符。若要匹配包括"\r\n"在内的任意字符，请使用诸如"[\s\S]"之类的模式。 |
| (*pattern*)   | 匹配 *pattern* 并捕获该匹配的子表达式。可以使用 **$0…$9** 属性从结果"匹配"集合中检索捕获的匹配。若要匹配括号字符 ( )，请使用"\("或者"\)"。 |
| (?:*pattern*) | 匹配 *pattern* 但不捕获该匹配的子表达式，即它是一个非捕获匹配，不存储供以后使用的匹配。这对于用"or"字符 (\|) 组合模式部件的情况很有用。例如，'industr(?:y\|ies) 是比 'industry\|industries' 更经济的表达式。 |
| (?=*pattern*) | 执行正向预测先行搜索的子表达式，该表达式匹配处于匹配 *pattern* 的字符串的起始点的字符串。它是一个非捕获匹配，即不能捕获供以后使用的匹配。例如，'Windows (?=95\|98\|NT\|2000)' 匹配"Windows 2000"中的"Windows"，但不匹配"Windows 3.1"中的"Windows"。预测先行不占用字符，即发生匹配后，下一匹配的搜索紧随上一匹配之后，而不是在组成预测先行的字符后。 |
| (?!*pattern*) | 执行反向预测先行搜索的子表达式，该表达式匹配不处于匹配 *pattern* 的字符串的起始点的搜索字符串。它是一个非捕获匹配，即不能捕获供以后使用的匹配。例如，'Windows (?!95\|98\|NT\|2000)' 匹配"Windows 3.1"中的 "Windows"，但不匹配"Windows 2000"中的"Windows"。预测先行不占用字符，即发生匹配后，下一匹配的搜索紧随上一匹配之后，而不是在组成预测先行的字符后。 |
| *x*\|*y*      | 匹配 *x* 或 *y*。例如，'z\|food' 匹配"z"或"food"。'(z\|f)ood' 匹配"zood"或"food"。 |
| [*xyz*]       | 字符集。匹配包含的任一字符。例如，"[abc]"匹配"plain"中的"a"。 |
| [^*xyz*]      | 反向字符集。匹配未包含的任何字符。例如，"[^abc]"匹配"plain"中"p"，"l"，"i"，"n"。 |
| [*a-z*]       | 字符范围。匹配指定范围内的任何字符。例如，"[a-z]"匹配"a"到"z"范围内的任何小写字母。 |
| [^*a-z*]      | 反向范围字符。匹配不在指定的范围内的任何字符。例如，"[^a-z]"匹配任何不在"a"到"z"范围内的任何字符。 |
| \b            | 匹配一个字边界，即字与空格间的位置。例如，"er\b"匹配"never"中的"er"，但不匹配"verb"中的"er"。 |
| \B            | 非字边界匹配。"er\B"匹配"verb"中的"er"，但不匹配"never"中的"er"。 |
| \c*x*         | 匹配 *x* 指示的控制字符。例如，\cM 匹配 Control-M 或回车符。*x* 的值必须在 A-Z 或 a-z 之间。如果不是这样，则假定 c 就是"c"字符本身。 |
| \d            | 数字字符匹配。等效于 [0-9]。                                 |
| \D            | 非数字字符匹配。等效于 [^0-9]。                              |
| \f            | 换页符匹配。等效于 \x0c 和 \cL。                             |
| \n            | 换行符匹配。等效于 \x0a 和 \cJ。                             |
| \r            | 匹配一个回车符。等效于 \x0d 和 \cM。                         |
| \s            | 匹配任何空白字符，包括空格、制表符、换页符等。与 [ \f\n\r\t\v] 等效。 |
| \S            | 匹配任何非空白字符。与 [^ \f\n\r\t\v] 等效。                 |
| \t            | 制表符匹配。与 \x09 和 \cI 等效。                            |
| \v            | 垂直制表符匹配。与 \x0b 和 \cK 等效。                        |
| \w            | 匹配任何字类字符，包括下划线。与"[A-Za-z0-9_]"等效。         |
| \W            | 与任何非单词字符匹配。与"[^A-Za-z0-9_]"等效。                |
| \x*n*         | 匹配 *n*，此处的 *n* 是一个十六进制转义码。十六进制转义码必须正好是两位数长。例如，"\x41"匹配"A"。"\x041"与"\x04"&"1"等效。允许在正则表达式中使用 ASCII 代码。 |
| \*num*        | 匹配 *num*，此处的 *num* 是一个正整数。到捕获匹配的反向引用。例如，"(.)\1"匹配两个连续的相同字符。 |
| \*n*          | 标识一个八进制转义码或反向引用。如果 \*n* 前面至少有 *n* 个捕获子表达式，那么 *n* 是反向引用。否则，如果 *n* 是八进制数 (0-7)，那么 *n* 是八进制转义码。 |
| \*nm*         | 标识一个八进制转义码或反向引用。如果 \*nm* 前面至少有 *nm* 个捕获子表达式，那么 *nm* 是反向引用。如果 \*nm* 前面至少有 *n* 个捕获，则 *n* 是反向引用，后面跟有字符 *m*。如果两种前面的情况都不存在，则 \*nm* 匹配八进制值 *nm*，其中 *n* 和 *m* 是八进制数字 (0-7)。 |
| \nml          | 当 *n* 是八进制数 (0-3)，*m* 和 *l* 是八进制数 (0-7) 时，匹配八进制转义码 *nml*。 |
| \u*n*         | 匹配 *n*，其中 *n* 是以四位十六进制数表示的 Unicode 字符。例如，\u00A9 匹配版权符号 (©)。 |

> 根据 Java Language Specification 的要求，Java 源代码的字符串中的反斜线被解释为 Unicode 转义或其他字符转义。因此必须在字符串字面值中使用两个反斜线，表示正则表达式受到保护，不被 Java 字节码编译器解释。例如，当解释为正则表达式时，字符串字面值 "\b" 与单个退格字符匹配，而 "\\b" 与单词边界匹配。字符串字面值 "\(hello\)" 是非法的，将导致编译时错误；要与字符串 (hello) 匹配，必须使用字符串字面值 "\\(hello\\)"。

------

## Matcher 类的方法

## 索引方法

索引方法提供了有用的索引值，精确表明输入字符串中在哪能找到匹配：

| **序号** | **方法及说明**                                               |
| -------- | ------------------------------------------------------------ |
| 1        | **public int start()**  返回以前匹配的初始索引。             |
| 2        | **public int start(int group)**  返回在以前的匹配操作期间，由给定组所捕获的子序列的初始索引 |
| 3        | **public int end()** 返回最后匹配字符之后的偏移量。          |
| 4        | **public int end(int group)** 返回在以前的匹配操作期间，由给定组所捕获子序列的最后字符之后的偏移量。 |

## 研究方法

研究方法用来检查输入字符串并返回一个布尔值，表示是否找到该模式：

| **序号** | **方法及说明**                                               |
| -------- | ------------------------------------------------------------ |
| 1        | **public boolean lookingAt()**   尝试将从区域开头开始的输入序列与该模式匹配。 |
| 2        | **public boolean find()**  尝试查找与该模式匹配的输入序列的下一个子序列。 |
| 3        | **public boolean find(int start****）** 重置此匹配器，然后尝试查找匹配该模式、从指定索引开始的输入序列的下一个子序列。 |
| 4        | **public boolean matches()**  尝试将整个区域与模式匹配。     |

## 替换方法

替换方法是替换输入字符串里文本的方法：

| **序号** | **方法及说明**                                               |
| -------- | ------------------------------------------------------------ |
| 1        | **public Matcher appendReplacement(StringBuffer sb, String replacement)** 实现非终端添加和替换步骤。 |
| 2        | **public StringBuffer appendTail(StringBuffer sb)** 实现终端添加和替换步骤。 |
| 3        | **public String replaceAll(String replacement)**   替换模式与给定替换字符串相匹配的输入序列的每个子序列。 |
| 4        | **public String replaceFirst(String replacement)**  替换模式与给定替换字符串匹配的输入序列的第一个子序列。 |
| 5        | **public static String quoteReplacement(String s)** 返回指定字符串的字面替换字符串。这个方法返回一个字符串，就像传递给Matcher类的appendReplacement 方法一个字面字符串一样工作。 |

## start 和 end 方法

下面是一个对单词 "cat" 出现在输入字符串中出现次数进行计数的例子：

## RegexMatches.java 文件代码：

import java.util.regex.Matcher; import java.util.regex.Pattern;   public class RegexMatches {     private static final String REGEX = "\\bcat\\b";     private static final String INPUT =                                     "cat cat cat cattie cat";       public static void main( String args[] ){        Pattern p = Pattern.compile(REGEX);        Matcher m = p.matcher(INPUT); // 获取 matcher 对象        int count = 0;          while(m.find()) {          count++;          System.out.println("Match number "+count);          System.out.println("start(): "+m.start());          System.out.println("end(): "+m.end());       }    } }

以上实例编译运行结果如下：

```
Match number 1
start(): 0
end(): 3
Match number 2
start(): 4
end(): 7
Match number 3
start(): 8
end(): 11
Match number 4
start(): 19
end(): 22
```

可以看到这个例子是使用单词边界，以确保字母 "c" "a" "t" 并非仅是一个较长的词的子串。它也提供了一些关于输入字符串中匹配发生位置的有用信息。

Start 方法返回在以前的匹配操作期间，由给定组所捕获的子序列的初始索引，end 方法最后一个匹配字符的索引加 1。

## matches 和 lookingAt 方法

matches 和 lookingAt 方法都用来尝试匹配一个输入序列模式。它们的不同是 matches 要求整个序列都匹配，而lookingAt 不要求。

lookingAt 方法虽然不需要整句都匹配，但是需要从第一个字符开始匹配。

这两个方法经常在输入字符串的开始使用。

我们通过下面这个例子，来解释这个功能：

## RegexMatches.java 文件代码：

import java.util.regex.Matcher; import java.util.regex.Pattern;   public class RegexMatches {     private static final String REGEX = "foo";     private static final String INPUT = "fooooooooooooooooo";     private static final String INPUT2 = "ooooofoooooooooooo";     private static Pattern pattern;     private static Matcher matcher;     private static Matcher matcher2;       public static void main( String args[] ){        pattern = Pattern.compile(REGEX);        matcher = pattern.matcher(INPUT);        matcher2 = pattern.matcher(INPUT2);          System.out.println("Current REGEX is: "+REGEX);        System.out.println("Current INPUT is: "+INPUT);        System.out.println("Current INPUT2 is: "+INPUT2);            System.out.println("lookingAt(): "+matcher.lookingAt());        System.out.println("matches(): "+matcher.matches());        System.out.println("lookingAt(): "+matcher2.lookingAt());    } }

以上实例编译运行结果如下：

```
Current REGEX is: foo
Current INPUT is: fooooooooooooooooo
Current INPUT2 is: ooooofoooooooooooo
lookingAt(): true
matches(): false
lookingAt(): false
```

## replaceFirst 和 replaceAll 方法

replaceFirst 和 replaceAll 方法用来替换匹配正则表达式的文本。不同的是，replaceFirst 替换首次匹配，replaceAll 替换所有匹配。

下面的例子来解释这个功能：

## RegexMatches.java 文件代码：

import java.util.regex.Matcher; import java.util.regex.Pattern;   public class RegexMatches {     private static String REGEX = "dog";     private static String INPUT = "The dog says meow. " +                                     "All dogs say meow.";     private static String REPLACE = "cat";       public static void main(String[] args) {        Pattern p = Pattern.compile(REGEX);        // get a matcher object        Matcher m = p.matcher(INPUT);         INPUT = m.replaceAll(REPLACE);        System.out.println(INPUT);    } }

以上实例编译运行结果如下：

```
The cat says meow. All cats say meow.
```

## appendReplacement 和 appendTail 方法

Matcher 类也提供了appendReplacement 和 appendTail 方法用于文本替换：

看下面的例子来解释这个功能：

## RegexMatches.java 文件代码：

import java.util.regex.Matcher; import java.util.regex.Pattern;   public class RegexMatches {    private static String REGEX = "a*b";    private static String INPUT = "aabfooaabfooabfoobkkk";    private static String REPLACE = "-";    public static void main(String[] args) {       Pattern p = Pattern.compile(REGEX);       // 获取 matcher 对象       Matcher m = p.matcher(INPUT);       StringBuffer sb = new StringBuffer();       while(m.find()){          m.appendReplacement(sb,REPLACE);       }       m.appendTail(sb);       System.out.println(sb.toString());    } }

以上实例编译运行结果如下：

```
-foo-foo-foo-kkk
```

## PatternSyntaxException 类的方法

PatternSyntaxException 是一个非强制异常类，它指示一个正则表达式模式中的语法错误。

PatternSyntaxException 类提供了下面的方法来帮助我们查看发生了什么错误。

| **序号** | **方法及说明**                                               |
| -------- | ------------------------------------------------------------ |
| 1        | **public String getDescription()** 获取错误的描述。          |
| 2        | **public int getIndex()**   获取错误的索引。                 |
| 3        | **public String getPattern()**  获取错误的正则表达式模式。   |
| 4        | **public String getMessage()**  返回多行字符串，包含语法错误及其索引的描述、错误的正则表达式模式和模式中错误索引的可视化指示。 |





# 疯狂Java讲义（第4版）  目录

## 第1章　Java语言概述与开发环境
1.1　Java语言的发展简史
1.2　 Java程序运行机制
1.2.1　高级语言的运行机制
1.2.2　Java程序的运行机制和JVM
1.3　开发Java的准备
1.3.1　下载和安装Java 9的JDK
不是说JVM是运行Java程序的虚拟机吗？那JRE和JVM的关系是怎样的呢？
为什么不安装公共JRE呢？
1.3.2　设置PATH环境变量
为什么选择用户变量？用户变量与系统变量有什么区别？
1.4　第一个Java程序
1.4.1　编辑Java源代码
1.4.2　编译Java程序
当编译C程序时，不仅需要指定存放目标文件的位置，也需要指定目标文件的文件名，这里使用javac编译Java程序时怎么不需要指定目标文件的文件名呢？
1.4.3　运行Java程序
1.4.4　根据CLASSPATH环境变量定位类
1.5　Java程序的基本规则
1.5.1　Java程序的组织形式
1.5.2　Java源文件的命名规则
1.5.3　初学者容易犯的错误
1.6　JDK 9新增的jshell工具
1.7　Java 9的G1垃圾回收器
1.8　何时开始使用IDE工具
我想学习Java编程，到底是学习Eclipse好，还是学习NetBeans好呢？
1.9　本章小结
本章练习
## 第2章　理解面向对象
2.1 面向对象
2.1.1 结构化程序设计简介
2.1.2 程序的三种基本结构
2.1.3 面向对象程序设计简介
2.1.4 面向对象的基本特征
2.2 UML （统一建模语言）介绍
2.2.1 用例图
2.2.2 类图
2.2.3 组件图
2.2.4 部署图
2.2.5 顺序图
2.2.6 活动图
2.2.7 状态机图
2.3 Java的面向对象特征
2.3.1 一切都是对象
2.3.2 类和对象
2.4 本章小结
## 第3章　数据类型和运算符
3.1 注释
3.1.1 单行注释和多行注释
3.1.2 Java 9增强文档注释
API文档是什么?
为什么要学习查看API文档的方法？
3.2 标识符和关键字
3.2.1 分隔符
3.2.2 Java 9的标识符规则
3.2.3 Java关键字
3.3 数据类型分类
什么是变量？变量有什么用？
3.4 基本数据类型
3.4.1 整型
3.4.2 字符型
什么是字符集？
3.4.3 浮点型
3.4.4 数值中使用下画线分隔
3.4.5 布尔型
3.5 基本类型的类型转换
3.5.1 自动类型转换
3.5.2 强制类型转换
3.5.3 表达式类型的自动提升
3.6 直接量
3.6.1 直接量的类型
3.6.2 直接量的赋值
3.7 运算符
3.7.1 算术运算符
3.7.2 赋值运算符
3.7.3 位运算符
3.7.4 扩展后的赋值运算符
3.7.5 比较运算符
3.7.6 逻辑运算符
3.7.7 三目运算符
3.7.8 运算符的结合性和优先级
3.8 本章小结
本章练习
## 第4章　流程控制与数组
4.1 顺序结构
4.2 分支结构
4.2.1 if条件语句
4.2.2 Java 7增强后的switch分支语句
4.3 循环结构
4.3.1 while循环语句
4.3.2 do while循环语句
4.3.3 for循环
4.3.4 嵌套循环
4.4 控制循环结构
4.4.1 使用break结束循环
4.4.2 使用continue忽略本次循环剩下语句
4.4.3 使用return结束方法
4.5 数组类型
4.5.1 理解数组：数组也是一种类型
int[]是一种类型吗？怎么使用这种类型呢？
4.5.2 定义数组
4.5.3 数组的初始化
能不能只分配内存空间，不赋初始值呢？
4.5.4 使用数组
为什么要我记住这些异常信息？
4.5.5 foreach循环
4.6 深入数组
4.6.1 内存中的数组
为什么有栈内存和堆内存之分？
4.6.2 基本类型数组的初始化
4.6.3 引用类型数组的初始化
4.6.4 没有多维数组
我是否可以让图4.13中灰色覆盖的数组元素再次指向另一个数组？这样不就可以扩展成三维数组，甚至扩展成更多维的数组吗？
4.6.5 Java 8增强的工具类：Arrays
4.6.6 数组的应用举例
4.7 本章小结
本章练习
## 第5章　面向对象（上）
5.1 类和对象
5.1.1 定义类
构造器不是没有返回值吗？为什么不能用void声明呢？
5.1.2 对象的产生和使用
5.1.3 对象、引用和指针
5.1.4 对象的this引用
5.2 方法详解
5.2.1 方法的所属性
5.2.2 方法的参数传递机制
5.2.3 形参个数可变的方法
5.2.4 递归方法
5.2.5 方法重载
为什么方法的返回值类型不能用于区分重载的方法？
5.3 成员变量和局部变量
5.3.1 成员变量和局部变量是什么
5.3.2 成员变量的初始化和内存中的运行机制
5.3.3 局部变量的初始化和内存中的运行机制
5.3.4 变量的使用规则
5.4 隐藏和封装
5.4.1 理解封装
5.4.2 使用访问控制符
5.4.3 package、import和import static
5.4.4 Java的常用包
5.5 深入构造器
5.5.1 使用构造器执行初始化
构造器是创建Java对象的途径，是不是说构造器完全负责创建Java对象？
5.5.2 构造器重载
为什么要用this来调用另一个重载的构造器？我把另一个构造器里的代码复制、粘贴到这个构造器里不就可以了吗？
5.6 类的继承
5.6.1 继承的特点
5.6.2 重写父类的方法
5.6.3 super限定
5.6.4 调用父类构造器
为什么我创建Java对象时从未感觉到java.lang. Object类的构造器被调用过？
5.7 多态
5.7.1 多态性
5.7.2 引用变量的强制类型转换
5.7.3 instanceof运算符
5.8 继承与组合
5.9 初始化块
5.10 本章小结
本章练习
## 第6章　面向对象（下）
6.1 Java 8增强的包装类
Java为什么要对这些数据进行缓存呢?
6.2 处理对象
6.3 类成员
6.4 final修饰符
6.5 抽象类
6.6 Java 9改进的接口
6.7 内部类
6.8 Java 8新增的Lambda表达式
6.9 枚举类
6.10 对象与垃圾回收
6.11 修饰符的适用范围
6.12 Java 9的多版本JAR包
6.13 本章小结
本章练习
## 第7章 Java基础类库
7.1 与用户互动
7.2 系统相关
7.3 常用类
7.4 日期、时间类
7.5 正则表达式
7.6 变量处理和方法处理
7.7 Java 9改进的国际化与格式化
7.8 Java 8新增的日期、时间格式器
7.9 本章小结
本章练习
## 第8章 Java集合
8.1 Java集合概述
8.2 Collection和Iterator接口
8.3 Set集合
8.4 List集合
8.5 Queue集合
8.6 Java 8增强的Map集合
8.7 HashSet和HashMap的性能选项
8.8 操作集合的工具类：Collections
8.9 烦琐的接口：Enumeration
8.10 本章小结
本章练习
## 第9章 泛型
9.1 泛型入门
9.2 深入泛型
9.3 类型通配符
9.4 泛型方法
9.5 擦除和转换
9.6 泛型与数组
9.7 本章小结
## 第10章 异常处理
10.1 异常概述
10.2 异常处理机制
10.3 Checked异常和Runtime异常体系
10.4 使用throw抛出异常
10.5 Java的异常跟踪栈
10.6 异常处理规则
10.7 本章小结
本章练习
## 第11章 AWT编程
11.1 Java 9改进的GUI（图形用户界面）和AWT
11.2 AWT容器
11.3 布局管理器
11.4 AWT常用组件
11.5 事件处理
11.6 AWT菜单
11.7 在AWT中绘图
11.8 处理位图
11.9 剪贴板
11.10 拖放功能
11.11 本章小结
本章练习
## 第12章　Swing编程
12.1 Swing概述
12.2 Swing基本组件的用法
12.3 Swing中的特殊容器
12.4 Swing简化的拖放功能
12.5 Java 7新增的Swing功能
12.6 使用JProgressBar、ProgressMonitor和BoundedRangeModel创建进度条
12.7 使用JSlider和BoundedRangeModel创建滑动条
12.8 使用JSpinner和SpinnerModel创建微调控制器
12.9 使用JList、JComboBox创建列表框
12.10 使用JTree和TreeModel创建树
12.11 使用JTable和TableModel创建表格
12.12 使用JFormattedTextField和JTextPane创建格式文本
12.13 本章小结
本章练习
## 第13章　MySQL数据库与JDBC编程
13.1 JDBC基础
13.2 SQL语法
13.3 JDBC的典型用法
13.4 执行SQL语句的方式
13.5 管理结果集
13.6 Javar的RowSet
13.7 事务处理
13.8 分析数据库信息
13.9 使用连接池管理连接
13.10 本章小结
本章练习
## 第14章　注解（Annotation）
14.1 基本注解
14.2 JDK的元注解
14.3 自定义注解
14.4 编译时处理注解
14.5 本章小结
## 第15章　输入/输出
15.1 File类
15.2 理解Java的IO流
15.3 字节流和字符流
15.4 输入/输出流体系
15.5 重定向标准输入/输出
15.6 Java虚拟机读写其他进程的数据
15.7 RandomAccessFile
15.8 Java 9改进的对象序列化
15.9 NIO
15.10 Java 7的NIO.2
15.11 本章小结
本章练习
## 第16章　多线程
16.1 线程概述
16.2 线程的创建和启动
16.3 线程的生命周期
16.4 控制线程
16.5 线程同步
16.6 线程通信
16.7 线程组和未处理的异常
16.8 线程池
16.9 线程相关类
16.10 本章小结
本章练习
## 第17章　网络编程
17.1 网络编程的基础知识
17.2 Java的基本网络支持
17.3 基于TCP协议的网络编程
17.4 基于UDP协议的网络编程
17.5 使用代理服务器
17.6 本章小结
本章练习
## 第18章　类加载机制与反射
18.1 类的加载、连接和初始化
18.2 类加载器
18.3 通过反射查看类信息
18.4 使用反射生成并操作对象
18.5 使用反射生成JDK动态代理
18.6 反射和泛型
18.7 本章小结
本章练习





