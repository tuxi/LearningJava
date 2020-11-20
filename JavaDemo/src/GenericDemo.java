import java.util.ArrayList;
import java.util.List;

// Java generic 泛型
/*
Java 泛型（generics）是 JDK 5 中引入的一个新特性, 泛型提供了编译时类型安全检测机制，该机制允许程序员在编译时检测到非法的类型。
泛型的本质是参数化类型，也就是说所操作的数据类型被指定为一个参数。
* */
public class GenericDemo {

    // 泛型方法
    public static <E> void printArray(E[] inputArray)
    {
        // 输出数组元素
        for (E element: inputArray) {
            System.out.printf("%s", element);
        }
        System.out.println();
    }

    GenericDemo() {
        // 创建不同类型数组
        Integer[] intArray = {1, 2, 3, 5, 3, 6};
        Double[] doubleArray = {1.1, 1.5, 13.6, 1.9};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};

        printArray(intArray);
        printArray(doubleArray);
        printArray(charArray);

        new MaximumDemo();

        Box<Integer> integerBox = new Box<>();
        Box<String> stringBox = new Box<>();
        integerBox.setT(10);
        stringBox.setT("菜鸟");
        System.out.printf("整型值为：%d\n\n", integerBox.getT());
        System.out.printf("字符串为：%s\n\n", stringBox.getT());

        // 类型通配符
        // 类通配符一般是使用？代替具体的类型参数。例如List<?> 在逻辑上是List<String>, List<Integer> 等所有List<具体实例实参>的父类
        List<String> names = new ArrayList<String>();
        List<Integer> ages = new ArrayList<Integer>();
        List<Number> numbers = new ArrayList<Number>();
        names.add("icon");
        ages.add(18);
        numbers.add(314);
        getData(numbers);
        getData(ages);
        getData(names);

        getUperNumer(ages);
        //出现错误，因为getUperNumber()方法中的参数已经限定了参数泛型上限为Number，所以泛型为String是不在这个范围之内，所以会报错
//        getUperNumer(names); x
        getUperNumer(numbers);

    }

    public static void getData(List<?> data) {
        System.out.println("data: " + data.get(0));
    }

    public static void getUperNumer(List<? extends Number> data) {
        System.out.println("data: " + data.get(0) );
    }

}

class MaximumDemo {

    /*
    有界的类型参数: 类似swift 的类型约束
    可能有时候，你会想限制那些被允许传递到一个类型参数的类型种类范围。例如，一个操作数字的方法可能只希望接受Number或者Number子类的实例。这就是有界类型参数的目的。
    要声明一个有界的类型参数，首先列出类型参数的名称，后跟extends关键字，最后紧跟它的上界。
    * */
    // 比较三个值并返回最大的值
    static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        // 假设x 是初始最大值
        T max = x;
        if (y.compareTo(max) > 0) {
            // y 更大 记录
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        // 返回最大对象
        return max;
    }

    MaximumDemo() {
        System.out.printf(" %d, %d 和 %d 中最大数为 %d\n\n", 3, 4, 5, maximum(3, 4, 5));
        System.out.printf(" %.1f, %.1f 和 %.1f 中最大数为 %.1f\n\n", 6.6, 8.8, 7.7, maximum(6.6, 8.8, 7.7));
        System.out.printf(" %s, %s 和 %s 中最大数为 %s\n\n", "pear", "apple", "orange", maximum("pear", "apple", "orange"));
    }
}

// 泛型类
/*
泛型类的声明和非泛型类的声明类似，除了在类名后面添加了类型参数声明部分。
和泛型方法一样，泛型类的类型参数声明部分也包含一个或多个类型参数，参数间用逗号隔开。一个泛型参数，也被称为一个类型变量，是用于指定一个泛型类型名称的标识符。因为他们接受一个或多个参数，这些类被称为参数化的类或参数化的类型。
* */
class Box<T> {
    private T t;
    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

}


