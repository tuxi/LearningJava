// Java 重写(Override)与重载(Overload)
/*
* 重写(Override)
重写是子类对父类的允许访问的方法的实现过程进行重新编写, 返回值和形参都不能改变。即外壳不变，核心重写！
重写的好处在于子类可以根据需要，定义特定于自己的行为。 也就是说子类能够根据需要实现父类的方法。
重写方法不能抛出新的检查异常或者比被重写方法申明更加宽泛的异常。例如： 父类的一个方法申明了一个检查异常 IOException，但是在重写这个方法的时候不能抛出 Exception 异常，因为 Exception 是 IOException 的父类，只能抛出 IOException 的子类异常。
* */

public class OverrideDemo {

    OverrideDemo() {
        /*
        * 在下面的例子中可以看到，尽管 b 属于 Animal 类型，但是它运行的是 Dog 类的 move方法。
            这是由于在编译阶段，只是检查参数的引用类型。
            然而在运行时，Java 虚拟机(JVM)指定对象的类型并且运行该对象的方法。
            因此在上面的例子中，之所以能编译成功，是因为 Animal 类中存在 move 方法，然而运行时，运行的是特定对象的方法。
        * */
        Animal a = new Animal();
        Animal b = new Dog();
        a.move();
        b.move();
    }

    class Animal {
        void move() {
            System.out.println("动物可以移动");
        }
    }

    class Dog extends Animal {
        @Override
        void move() {
            super.move();
            System.out.println("狗可以跑着走");
        }

        void bark() {
            System.out.println("狗可以嗷嗷叫");
        }
    }

}

/* 重载(Overload)
重载(overloading) 是在一个类里面，方法名字相同，而参数不同。返回类型可以相同也可以不同。
每个重载的方法（或者构造函数）都必须有一个独一无二的参数类型列表。
最常用的地方就是构造器的重载。
重载规则:
被重载的方法必须改变参数列表(参数个数或类型不一样)；
被重载的方法可以改变返回类型；
被重载的方法可以改变访问修饰符；
被重载的方法可以声明新的或更广的检查异常；
方法能够在同一个类中或者在一个子类中被重载。
无法以返回值类型作为重载函数的区分标准。
*/
class Overloading {
    int test() {
        System.out.println("test1");
        return 1;
    }

    void test(int a) {
        System.out.println("test2");
    }

    String test(int a, String s) {
        System.out.println("test3");
        return "string3";
    }

    String test(String s, int a) {
        System.out.println("test4");
        return "test4";
    }
}
