/*
* 源文件规则
* 一个源文件中只能有一个public 类
* 一个源文件可以有多个非public类
* 源文件的名称应该和public 类的类名称保持一致。例如：源文件中public 类的类名是Employee，那么源文件应该命名为Employee.java
* 如果一个类定义在某个包中，那么package语句应该在源文件的首行
* 如果源文件包含import 语句
* */

import test.Dog;
import test.Employee;

import java.io.IOException;

class FreshJuice {
    enum FreshJuiceSize { SMALL, MEDIUM, LARGE }
    FreshJuiceSize size;
    // 常量在运行时不能被修改，用大写字母表示常量
    final double PI = 3.1415927;
}

// 类变量、实例变量、局部变量
class Variable {
    // 类变量
    /*
    * 类变量
    * 类变量也称为静态变量，在类中以 static 关键字声明，但必须在方法之外。
    * 无论一个类创建了多少个对象，类只拥有类变量的一份拷贝。
    * 静态变量除了被声明为常量外很少使用，静态变量是指声明为 public/private，final 和 static 类型的变量。静态变量初始化后不可改变
    * 静态变量存储在静态存储区，经常被声明为常量，很少单独使用static 声明变量
    * 静态变量在第一次访问时创建，在程序结束时销毁
    * 与实例变量具有相似的可见性，但是为了对类的使用者可见，大多数静态变量声明为public 类型
    * 默认值和实例变量相似。数值类型默认值为0，布尔型为false，引用类型默认值为null，变量的值可以在声明时指定，也可以在构造器中指定
    * 静态变量可以通过ClassName.VariableName的方式访问
    * 类静态变量被声明为public static final 类型时，类变量名称一般建议使用大写字母。如果静态变量不是public 和 final 类型，其命名方式与实例变量以及局部变量的命名方式一致。
    * */
    public static int allClicks = 0;
    // 静态私有变量
    private static double salary;


    // 实例变量
    /*
    * 实例变量
    * 实例变量声明在一个类中，但在方法和语句块之外
    * 当一个对象被实例化之后，每个实例变量的值就跟着确定
    * 实例变量在对象创建时创建，在对象销毁时销毁
    * 实力变量具有默认值，数值类型的默认值为0，布尔型变量的默认值为false，引用类型变量的默认值为null。变量的值可以在声明时指定，也可以构造方法中指定
    * */
    String str = "hello world";

    public Variable() {
        salary = 10000;
    }

    public void method() {
        /*
         * Java局部变量
         * 局部变量声明在方法、构造方法或者语句中
         * 局部变量在方法、构造方法、或者语句被执行的时候创建，当他们执行完成后，变量会被销毁
         * 访问修饰符不能用于局部变量
         * 局部变量只能声明他的方法、构造方法或者语句块中可见
         * 局部变量是在栈区分配的
         * 局部变量没有默认值，所以局部变量被声明后，必须经过初始化，才可以使用
         * */

        // 局部变量
        int i = 0;

        // 不同点
        // 局部变量没有默认值，所以局部变量被声明后，必须经过初始化，才可以使用
//        int a;
//        System.out.println(a);
    }


}

public class Hello {

    static void zidongleixingZhuanhuan() {
        // 定义一个char类型
        char c1 = 'a';
        // char 类型自动转换为int
        int i1 = c1;
        System.out.println("char 自动转换为 int 后的值等于:" + i1);
        // 定义一个char 类型
        char c2 = 'A';
        // char 类型和int 类型计算
        int i2 = c2 + 1;
        System.out.println("char 类型和int类型计算后的值等于：" + i2);
    }

    public static void main(String[] args) {
        System.out.println("test");

        FreshJuice juice = new FreshJuice();
        juice.size = FreshJuice.FreshJuiceSize.MEDIUM;

        System.out.println(juice.toString());
        System.out.println(juice.PI);

        Puppy myPuppy = new Puppy("tommy");
        myPuppy.run();
        myPuppy.setAge(10);
        System.out.println("小狗的年龄：" + myPuppy.getAge());

        Dog dog = new Dog();
        dog.run();

        Employee emp1 = new Employee("xiaoyuan");
        emp1.setAge(10);
        emp1.setDesignation("CTO");
        emp1.setSalary(1000000);
        System.out.println(emp1.descripition());

        Employee emp2 = new Employee("ketao");
        emp2.setSalary(1000000);
        emp2.setAge(11);
        emp2.setDesignation("CFO");
        System.out.println(emp2.descripition());

        zidongleixingZhuanhuan();

        System.out.println("Starting with " +
        StreamingAudioPlayer.getCount() + " instances");
        for (int i = 0; i < 500; i++) {
            new StreamingAudioPlayer();
        }
        System.out.println("Created " + StreamingAudioPlayer.getCount() + " instances");

        DateDemo dateIns = new DateDemo();
        dateIns.test();

        RegexDemo regex = new RegexDemo();

//        StreamDemo stream = new StreamDemo();
//        try {
//            stream.readChar();
//            stream.readLine();
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        }

       FileStream fStream = new FileStream();
        fStream.inputStreamDemo();
        fStream.inputOutputStreamDemo();
        fStream.inputOutputStreamDemo1();
//        fStream.bufferedReaderDemo();
        fStream.mkdirsDemo();
        fStream.readDirsDemo();
        fStream.deleteDirsDemo();

        ExceptionDemo exceptionDemo = new ExceptionDemo();

        new ExtendsDemo();

        new OverrideDemo();

        new AbstractDemo();

        new EnumDemo();

        new BitSetDemo();

        new VectorDemo();

        new ArrayListDemo();

        new LinkedListDemo();

        new IteratorDemo();

        new GenericDemo();

        new SerializerDemo();

        new ThreadDemo();
    }
}


