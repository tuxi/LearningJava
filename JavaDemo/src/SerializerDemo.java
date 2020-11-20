// Java Serialize 序列化

import java.io.*;

// 序列化demo
public class SerializerDemo {

    static String FILE_PATH = "/Users/xiaoyuan/Desktop/test/employee.ser";

    SerializerDemo() {
        Employee1 e = new Employee1();
        e.name = "xiaoyuan";
        e.address = "北京市";
        e.SSN = 1133311;
        e.number = 101;
        try {

            FileOutputStream fileOut = new FileOutputStream(FILE_PATH);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in %s", FILE_PATH);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("文件未找到");
            return;
        } catch (NotSerializableException ex2) {
            System.out.println("实体未实现java.io.Serializable接口");
            return;
        } catch (IOException ex1) {
            ex1.printStackTrace();
            return;
        }

        // 反序列化
        new DeserializeDemo();
    }
}

class Employee1 implements java.io.Serializable
{
    public String name;
    public String address;
    public transient int SSN;
    public int number;
    public void mailCheck()
    {
        System.out.println("Mailing a check to " + name
                + " " + address);
    }
}

// 反序列化对象
class DeserializeDemo {
    DeserializeDemo() {
        Employee1 e = null;
        try {
            FileInputStream fileIn = new FileInputStream(SerializerDemo.FILE_PATH);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            // readObject() 方法的返回值被转化成 Employee1 引用。没有这个类则抛出异常 ClassNotFoundException
            e = (Employee1) in.readObject();
        } catch (FileNotFoundException ex) {
            System.out.printf("文件没找到：%s", SerializerDemo.FILE_PATH);
            return;
        }
        catch (ClassNotFoundException ex2) {
            System.out.println("没找到这个类Employee1");
            return;
        }
        catch (IOException ex1) {
            ex1.printStackTrace();
            return;
        }

        System.out.println("Deserialized Emloyee1...");
        System.out.println("Name: " + e.name);
        System.out.println("Address: " + e.address);
        System.out.println("SSN: " + e.SSN);
        System.out.println("Number: " + e.number);
    }
}