import javax.naming.InsufficientResourcesException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.rmi.RemoteException;

// Java 异常处理
public class ExceptionDemo {

    ExceptionDemo() {

    }

    // 捕获异常
    void catchDemo() {
        // 下面的例子中声明有两个元素的一个数组，当代码试图访问数组的第三个元素的时候就会抛出一个异常
        try {
            int a[] = new int[2];
            System.out.println("Access element three: " + a[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception thrown: " + e);
        }
        System.out.println("Out of the block");
    }

    // 多重捕获块
    void mutiCatchDemo() {
        try {
            OutputStream outputStream = new FileOutputStream("sdsss");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // throws/throw 关键字：
    // 一个方法可以声明抛出多个异常，多个异常之间用逗号隔开。
    void throwsDemo() throws RemoteException, InsufficientResourcesException {

    }
}
