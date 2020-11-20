import java.util.*;

// Vector 类实现了一个动态数组
// Vector 是同步访问的。
// Vector 包含了许多传统的方法，这些方法不属于集合框架。
public class VectorDemo {

    VectorDemo() {
        Vector v = new Vector(3, 2);
        System.out.println("Initial size: " + v.size());
        System.out.println("Initial capacity: " + v.capacity());
        v.addElement(new Integer(1));
        v.addElement(new Integer(2));
        v.addElement(new Integer(3));
        v.addElement(new Integer(4));
        System.out.println("Capacity after for additions: " + v.capacity());
        v.addElement(new Double(5.45));
        System.out.println("Current capacity: " + v.capacity());
        v.addElement(new Double(6.08));
        v.addElement(new Integer(7));
        System.out.println("Current capacity: " +
                v.capacity());
        v.addElement(new Float(9.4));
        v.addElement(new Integer(10));
        System.out.println("Current capacity: " +
                v.capacity());
        v.addElement(new Integer(11));
        v.addElement(new Integer(12));
        System.out.println("First element: " +
                (Integer)v.firstElement());
        System.out.println("Last element: " +
                (Integer)v.lastElement());
        if(v.contains(new Integer(3)))
            System.out.println("Vector contains 3.");


        // enumerate the elements in the vector.
        Enumeration vEnum = v.elements();
        System.out.println("\n Elements in vector: ");
        while (vEnum.hasMoreElements()) {
            System.out.println(vEnum.nextElement() + "");
        }
        System.out.println();

        new StackDemo();
        new PropertiesDemo();
        new HashtableDemo();
    }
}

class StackDemo {
    StackDemo() {
        // 栈是Vector的一个子类，它实现了一个标准的后进先出的栈。
        Stack<Integer> stack = new Stack<Integer>();
        System.out.println("stack: " + stack);
        showPush(stack, 42);
        showPush(stack, 66);
        showPush(stack, 99);
        showPop(stack);
        showPop(stack);
        try {
            showPop(stack);
        } catch (EmptyStackException e) {
            System.out.println("Empty stack");
        }

    }

    static void showPush(Stack<Integer> stack, int a) {
        stack.push(new Integer(a));
        System.out.println("push(" + a + ")");
        System.out.println("stack: " + stack);
    }

    static void showPop(Stack<Integer> stack) {
        System.out.print("pop --> ");
        Integer a = (Integer) stack.pop();
        System.out.println(a);
        System.out.println("stack: " + stack);
    }
}

/*
* Properties 类
* Properties 继承于 Hashtable.表示一个持久的属性集.属性列表中每个键及其对应值都是一个字符串。
Properties 类被许多Java类使用。例如，在获取环境变量时它就作为System.getProperties()方法的返回值。
Properties 定义如下实例变量.这个变量持有一个Properties对象相关的默认属性列表。
* */
class PropertiesDemo {
    PropertiesDemo() {
        Properties capitals = new Properties();
        Set states;
        String str;

        capitals.put("Illinois", "SpringField");
        capitals.put("Missouri", "Jefferson City");
        capitals.put("Washington", "Olympia");
        capitals.put("California", "Sacramento");

        states = capitals.keySet();
        Iterator itr = states.iterator();
        while (itr.hasNext()) {
            str = (String) itr.next();
            System.out.println("The capital of " + str + " is " + capitals.getProperty(str) + ".");
        }
        System.out.println();

        str = capitals.getProperty("Florida", "Not Found");
        System.out.println("The capital of Florida is " + str + ".");
    }
}
// Hashtable是原始的java.util的一部分， 是一个Dictionary具体的实现 。
class HashtableDemo {
    HashtableDemo() {
        Hashtable balance = new Hashtable();
        Enumeration names;
        String str;
        double bal;

        balance.put("Zara", new Double(3434.34));
        balance.put("Mahnaz", new Double(123.22));
        balance.put("Ayan", new Double(1378.00));
        balance.put("Daisy", new Double(99.22));
        balance.put("Qadir", new Double(-19.08));

        names = balance.keys();
        while (names.hasMoreElements()) {
            str = (String) names.nextElement();
            System.out.println(str + ": "+ balance.get(str));
        }
    }
}