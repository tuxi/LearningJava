/*
* Java 继承
继承是java面向对象编程技术的一块基石，因为它允许创建分等级层次的类。
继承就是子类继承父类的特征和行为，使得子类对象（实例）具有父类的实例域和方法，或子类从父类继承方法，使得子类具有父类相同的行为。
* */

public class ExtendsDemo {
    ExtendsDemo() {
        Animal a = new Animal("animal", 0);
        a.eat();

        Dog d = new Dog("dog", 111);
        d.eatTest();

        System.out.println("------SubClass 类继承------");
    }
}

// 动物类 公共类
class Animal {
    private String name;
    private int id;
    Animal(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void eat() {
        System.out.println(name + "正在吃");
    }

    void sleep() {
        System.out.println(name + "正在睡");
    }

    void introduction() {
        System.out.println("大家好！我是" + id + "号" + name + "。");
    }
}

// extends关键字
// 在 Java 中，类的继承是单一继承，也就是说，一个子类只能拥有一个父类，所以 extends 只能继承一个类。
// 企鹅类
class Penguin extends Animal {
    Penguin(String name, int id) {
        super(name, id);
    }
}

// 老鼠类
class Mouse extends Animal {
    Mouse(String name, int id) {
        super(name, id);
    }
}


interface A {
    void eat();
    void sleep();
}
interface B {
    void show();
}

// implements关键字
// 使用 implements 关键字可以变相的使java具有多继承的特性，使用范围为类继承接口的情况，可以同时继承多个接口（接口跟接口之间采用逗号分隔）。
class C implements A, B {
    public void eat() {

    }
    public void sleep() {

    }
    public void show() {

    }
}

// super 与 this 关键字
// super关键字：我们可以通过super关键字来实现对父类成员的访问，用来引用当前对象的父类。
// this关键字：指向自己的引用。
class Dog extends Animal {
    Dog(String name, int id) {
        super(name, id);
    }

    @Override
    void eat() {
        System.out.println("dog: eat");
    }

    void eatTest() {
        // this 调用自己的方法
        this.eat();
        // super 调用父类的方法
        super.eat();
    }
}

class SuperClass {
    private int n;
    SuperClass() {
        System.out.println("SuperClass()");
    }
    SuperClass(int n) {
        System.out.println("\"SuperClass(int n");
        this.n = n;
    }
}

class SubClass1 extends SuperClass {
    // 自动调用父类的构造函数
    SubClass1() {
        System.out.println("SubClass");
    }

    SubClass1(int n) {
        super(n);
    }
}