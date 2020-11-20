import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class StreamDemo {

    StreamDemo() {

    }

    // 从控制台读取多字符输入
    void readChar() throws IOException {
        char c;
        // 使用System.in 创建BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符，按下'q' 按键退出。");
        // 读取字符
        do {
            // 从 BufferedReader 对象读取一个字符要使用 read() 方法
            c = (char) br.read();
            System.out.println(c);;
        } while (c != 'q');
    }

    // 从控制台读取字符串
    void readLine() throws IOException {
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Enter lines of text");
        System.out.println("Enter 'end' to quit");
        do {
            // 从标准输入读取一个字符串需要使用 BufferedReader 的 readLine() 方法。
            str = br.readLine();
            System.out.println(str);
        } while (!str.equals("end"));
    }
}
